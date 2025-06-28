package moe.crx.roadblock.io.sinks

import kotlinx.datetime.Instant
import moe.crx.roadblock.objects.game.SerializationVersion

abstract class OutputSink(ver: SerializationVersion): Sink(ver) {

    fun writeByte(v: Byte) {
        val ch = v.toInt() and 0xFF
        writeBytes(ch)
    }

    fun writeBoolean(b: Boolean) {
        writeByte(if (b) 1 else 0)
    }

    fun writeInt(v: Int) {
        val ch1 = v and 0xFF
        val ch2 = v ushr 8 and 0xFF
        val ch3 = v ushr 16 and 0xFF
        val ch4 = v ushr 24 and 0xFF
        writeBytes(ch1, ch2, ch3, ch4)
    }

    fun writeFloat(v: Float) {
        writeInt(v.toRawBits())
    }

    fun writeShort(v: Short) {
        val ch1 = v.toInt() and 0xFF
        val ch2 = v.toInt() ushr 8 and 0xFF
        writeBytes(ch1, ch2)
    }

    fun writeLong(v: Long) {
        val ch1 = v and 0xFF
        val ch2 = v ushr 8 and 0xFF
        val ch3 = v ushr 16 and 0xFF
        val ch4 = v ushr 24 and 0xFF
        val ch5 = v ushr 32 and 0xFF
        val ch6 = v ushr 40 and 0xFF
        val ch7 = v ushr 48 and 0xFF
        val ch8 = v ushr 56 and 0xFF
        writeBytes(ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8)
    }

    fun writeDouble(v: Double) {
        writeLong(v.toRawBits())
    }

    fun writeByteArray(bytes: ByteArray) {
        writeInt(bytes.size)
        writeBytes(*bytes)
    }

    fun writeString(s: String) {
        writeByteArray(s.toByteArray())
    }

    fun writeBytes(vararg bytes: Int) {
        writeBytes(*bytes.map { it.toByte() }.toByteArray())
    }

    fun writeBytes(vararg bytes: Long) {
        writeBytes(*bytes.map { it.toByte() }.toByteArray())
    }

    fun writeInstant(i: Instant) {
        writeLong(i.epochSeconds)
    }

    abstract fun writeBytes(vararg bytes: Byte)
}