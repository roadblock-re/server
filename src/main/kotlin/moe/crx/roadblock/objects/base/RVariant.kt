package moe.crx.roadblock.objects.base

import moe.crx.roadblock.io.VariantIO.readVariant
import moe.crx.roadblock.io.VariantIO.writeVariant
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import kotlin.reflect.KClass

abstract class RVariant(vararg clazz: KClass<out RObject>) : RObject {

    constructor(clazz: List<KClass<out RObject>>) : this(*clazz.toTypedArray())

    val classes: Array<out KClass<out RObject>> = clazz
    var variant: RObject = RVoid()

    override fun read(sink: InputSink) {
        variant = sink.readVariant(*classes)
    }

    override fun write(sink: OutputSink) {
        sink.writeVariant(variant, *classes)
    }
}