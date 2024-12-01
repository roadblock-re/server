package moe.crx.roadblock.io

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import kotlin.enums.enumEntries

object ListIO {
    // TODO Rewrite every listOf() to enum array where needed
    inline fun <reified T : RObject> InputSink.readList(): List<T> {
        return buildList {
            repeat(readInt()) {
                add(readObject())
            }
        }
    }

    fun <T : RObject> OutputSink.writeList(list: List<T>) {
        writeInt(list.size)
        list.forEach { writeObject(it) }
    }

    inline fun <reified E : Enum<E>, reified T : RObject> InputSink.readEnumList(): List<T> {
        enumEntries<E>().size.let {
            check(it == readInt()) {
                "DESERIALIZATION ISSUE: List size doesn't match enum entries count."
            }
            return buildList {
                repeat(size) {
                    add(readObject())
                }
            }
        }
    }

    inline fun <reified E : Enum<E>, reified T : RObject> OutputSink.writeEnumList(list: List<T>) {
        enumEntries<E>().size.let {
            check(it == list.size) {
                "SERIALIZATION ISSUE: List size doesn't match enum entries count."
            }
            writeInt(it)
        }
        list.forEach {
            writeObject(it)
        }
    }
}