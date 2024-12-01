package moe.crx.roadblock.io

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import kotlin.reflect.KClass

object ObjectIO {
    fun <T : RObject> InputSink.readObject(clazz: KClass<T>): T {
        val obj = clazz.java.getConstructor().newInstance()
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