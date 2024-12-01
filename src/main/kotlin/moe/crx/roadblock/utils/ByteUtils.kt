package moe.crx.roadblock.utils

import moe.crx.roadblock.io.ObjectIO.readObject
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