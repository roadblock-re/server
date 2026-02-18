package moe.crx.roadblock.game.io

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.game.serialization.SerializationVersion
import kotlin.reflect.KClass

object ObjectIO {
    fun <T : RObject> SerializationVersion.createObject(clazz: KClass<T>): T {
        val ctr = runCatching {
            clazz.java.getConstructor(SerializationVersion::class.java)
        }.getOrNull()

        val obj = if (ctr != null) {
            ctr.newInstance(this)
        } else {
            clazz.java.getConstructor().newInstance()
        }

        return obj
    }

    fun <T : RObject> InputSink.readObject(clazz: KClass<T>): T {
        val obj = ver.createObject(clazz)
        obj.read(this)
        return obj
    }

    inline fun <reified T : RObject> InputSink.readObject(): T {
        return readObject(T::class)
    }

    fun <T : RObject> OutputSink.writeObject(obj: T) {
        obj.write(this)
    }
}