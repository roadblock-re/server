package moe.crx.roadblock.io.sinks

import kotlinx.datetime.Instant
import moe.crx.roadblock.objects.game.SerializationVersion

abstract class InputSink(ver: SerializationVersion) : Sink(ver) {

    fun readByte(): Byte {
        val bytes = readBytes(1)
        return bytes[0]
    }

    fun readBoolean(): Boolean {
        return readByte().toInt() != 0
    }

    fun readShort(): Short {
        val bytes = readBytes(2).map { it.toInt() and 0xFF }
        val ch1 = bytes[0]
        val ch2 = bytes[1] shl 8
        return (ch1 or ch2).toShort()
    }

    fun readInt(): Int {
        val bytes = readBytes(4).map { it.toInt() and 0xFF }
        val ch1 = bytes[0]
        val ch2 = bytes[1] shl 8
        val ch3 = bytes[2] shl 16
        val ch4 = bytes[3] shl 24
        return ch1 or ch2 or ch3 or ch4
    }

    fun readLong(): Long {
        val bytes = readBytes(8).map { it.toLong() and 0xFF }
        val ch1 = bytes[0]
        val ch2 = bytes[1] shl 8
        val ch3 = bytes[2] shl 16
        val ch4 = bytes[3] shl 24
        val ch5 = bytes[4] shl 32
        val ch6 = bytes[5] shl 40
        val ch7 = bytes[6] shl 48
        val ch8 = bytes[7] shl 56
        return ch1 or ch2 or ch3 or ch4 or ch5 or ch6 or ch7 or ch8
    }

    fun readFloat(): Float {
        return Float.fromBits(readInt())
    }

    fun readDouble(): Double {
        return Double.fromBits(readLong())
    }

    fun readByteArray(): ByteArray {
        val length = readInt()
        return readBytes(length)
    }

    fun readString(): String {
        return readByteArray().toString(Charsets.UTF_8)
    }

    fun readInstant(): Instant {
        return Instant.fromEpochSeconds(readLong(), 0)
    }

    fun readAllBytes(): ByteArray {
        return readBytes(available())
    }

    abstract fun readBytes(n: Int): ByteArray
    abstract fun available(): Int
}
