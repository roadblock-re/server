package moe.crx.roadblock.io

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import kotlin.reflect.KClass

object VariantIO {
    fun InputSink.readVariant(vararg clazz: KClass<out RObject>): RObject {
        check(clazz.isNotEmpty()) {
            "DESERIALIZATION ISSUE: Empty variant list."
        }
        val type = readByte().toInt()
        return readObject(clazz[type])
    }

    fun OutputSink.writeVariant(obj: RObject, vararg clazz: KClass<out RObject>) {
        check(clazz.isNotEmpty()) {
            "SERIALIZATION ISSUE: Empty variant list."
        }
        clazz.indexOfFirst {
            obj.javaClass == it.java
        }.let {
            check(it != -1) {
                "SERIALIZATION ISSUE: Can't find variant class ${obj.javaClass.name}"
            }

            writeByte(it.toByte())
            writeObject(obj)
        }
    }
}