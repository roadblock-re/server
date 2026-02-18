package moe.crx.roadblock.game.io

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import kotlin.enums.enumEntries

object EnumIO {
    inline fun <reified T : Enum<T>> InputSink.readEnum(): T {
        return enumEntries<T>()[readInt()]
    }

    fun <T : Enum<T>> OutputSink.writeEnum(obj: T) {
        writeInt(obj.ordinal)
    }

    inline fun <reified T : Enum<T>> InputSink.readEnum8(): T {
        return enumEntries<T>()[readByte().toInt()]
    }

    fun <T : Enum<T>> OutputSink.writeEnum8(obj: T) {
        writeByte(obj.ordinal.toByte())
    }

    inline fun <reified T : Enum<T>> InputSink.readEnumString(): T {
        val stringName = readString()
        return enumEntries<T>().first { it.name == stringName }
    }

    fun <T : Enum<T>> OutputSink.writeEnumString(obj: T) {
        writeString(obj.name)
    }
}