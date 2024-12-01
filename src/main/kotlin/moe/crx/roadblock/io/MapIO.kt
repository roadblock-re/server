package moe.crx.roadblock.io

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

object MapIO {
    // TODO Rewrite every listOf() to map where needed
    inline fun <reified K : RObject, reified V : RObject> InputSink.readMap(): Map<K, V> {
        return buildMap {
            repeat(readInt()) {
                val key = readObject<K>()
                val value = readObject<V>()
                put(key, value)
            }
        }
    }

    fun <K : RObject, V : RObject> OutputSink.writeMap(map: Map<K, V>) {
        writeInt(map.size)
        map.forEach {
            writeObject(it.key)
            writeObject(it.value)
        }
    }
}