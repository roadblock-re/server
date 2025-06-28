package moe.crx.roadblock.utils

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.InputStreamSink
import moe.crx.roadblock.io.sinks.OutputStreamSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.SerializationVersion
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.security.MessageDigest
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import kotlin.enums.enumEntries
import kotlin.reflect.KClass

inline fun <reified T : Enum<T>> Number.toEnum(): T {
    return enumEntries<T>()[toInt()]
}

fun ByteArray.sink(ver: SerializationVersion): InputStreamSink {
    return InputStreamSink(ByteArrayInputStream(this), ver)
}

fun <T : RObject> InputSink.readFully(clazz: KClass<T>): T {
    readObject(clazz).let {
        check(available() == 0) {
            "Packet isn't read until the end, ${available()} bytes still available"
        }
        return it
    }
}

inline fun <reified T : RObject> InputSink.readFully(): T {
    return readFully(T::class)
}

fun byteOutputSink(ver: SerializationVersion): OutputStreamSink {
    return OutputStreamSink(ByteArrayOutputStream(), ver)
}

fun OutputStreamSink.bytes(): ByteArray {
    check(output is ByteArrayOutputStream)
    return output.toByteArray()
}

fun RObject.bytes(ver: SerializationVersion): ByteArray {
    return byteOutputSink(ver).apply {
        writeObject(this@bytes)
    }.bytes()
}

fun ByteArray.sha256() = MessageDigest.getInstance("SHA-256").digest(this).toHexString()

fun ByteArray.toHexString() = joinToString("") { it.toHexString() }

fun Byte.toHexString() = "%02x".format(this)

fun decryptDesEcbZeroPadding(encryptedBase64: String, keyString: String): String {
    val keyBytes = keyString.toByteArray(Charsets.UTF_8)
    val keySpec = SecretKeySpec(keyBytes, "DES")

    val cipher = Cipher.getInstance("DES/ECB/NoPadding")
    cipher.init(Cipher.DECRYPT_MODE, keySpec)

    val encryptedBytes = Base64.getDecoder().decode(encryptedBase64)
    val decryptedBytes = cipher.doFinal(encryptedBytes)

    val unpadded = decryptedBytes.takeWhile { it != 0.toByte() }.toByteArray()

    return String(unpadded, Charsets.UTF_8)
}

fun ByteArray.toBigEndianInt(): Int {
    val bytes = take(4).map { it.toInt() and 0xFF }.reversed()
    val ch1 = bytes[0]
    val ch2 = bytes[1] shl 8
    val ch3 = bytes[2] shl 16
    val ch4 = bytes[3] shl 24
    return ch1 or ch2 or ch3 or ch4
}

fun ByteArray.toLittleEndianInt(): Int {
    val bytes = take(4).map { it.toInt() and 0xFF }
    val ch1 = bytes[0]
    val ch2 = bytes[1] shl 8
    val ch3 = bytes[2] shl 16
    val ch4 = bytes[3] shl 24
    return ch1 or ch2 or ch3 or ch4
}

fun Int.toBigEndianBytes(): ByteArray {
    val ch1 = this and 0xFF
    val ch2 = this ushr 8 and 0xFF
    val ch3 = this ushr 16 and 0xFF
    val ch4 = this ushr 24 and 0xFF
    return byteArrayOf(ch4.toByte(), ch3.toByte(), ch2.toByte(), ch1.toByte())
}

fun evpBytesToKey(
    password: ByteArray,
    salt: ByteArray,
    keyLen: Int = 32,
    ivLen: Int = 16,
    digest: String = "SHA-256",
    count: Int = 1
): Pair<ByteArray, ByteArray> {
    val md = MessageDigest.getInstance(digest)
    val output = mutableListOf<Byte>()
    var prev = ByteArray(0)

    while (output.size < keyLen + ivLen) {
        val data = prev + password + salt
        var digestResult = md.digest(data)

        repeat(count - 1) {
            digestResult = md.digest(digestResult)
        }

        output.addAll(digestResult.toList())
        prev = digestResult
    }

    val key = output.take(keyLen).toByteArray()
    val iv = output.drop(keyLen).take(ivLen).toByteArray()
    return Pair(key, iv)
}