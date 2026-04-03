package moe.crx.roadblock.core.utils

import java.security.MessageDigest
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import kotlin.enums.enumEntries

inline fun <reified T : Enum<T>> Number.toEnum(): T {
    return enumEntries<T>()[toInt()]
}

fun ByteArray.sha256() = MessageDigest.getInstance("SHA-256").digest(this).toHexString()

fun ByteArray.toHexString(separator: String = "") = joinToString(separator) { it.toHexString() }

fun String.fromHexString() = filterNot { it.isWhitespace() }.windowed(2, 2) {
    it.substring(0).toInt(16).toByte()
}.toByteArray()

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

fun ByteArray.fromBigEndian(): Int {
    val ch1 = (this[0].toInt() and 0xFF) shl 24
    val ch2 = (this[1].toInt() and 0xFF) shl 16
    val ch3 = (this[2].toInt() and 0xFF) shl 8
    val ch4 = (this[3].toInt() and 0xFF)
    return ch1 or ch2 or ch3 or ch4
}

fun ByteArray.fromLittleEndian(): Int {
    return reversedArray().fromBigEndian()
}

fun Int.toBigEndian(): ByteArray {
    val ch1 = ((this ushr 24) and 0xFF).toByte()
    val ch2 = ((this ushr 16) and 0xFF).toByte()
    val ch3 = ((this ushr 8) and 0xFF).toByte()
    val ch4 = ((this) and 0xFF).toByte()
    return byteArrayOf(ch1, ch2, ch3, ch4)
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