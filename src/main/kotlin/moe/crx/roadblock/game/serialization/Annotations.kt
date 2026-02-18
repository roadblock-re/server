package moe.crx.roadblock.game.serialization

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialInfo
import moe.crx.roadblock.game.serialization.VariantCompanionRegistry.getVariantCompanion
import kotlin.reflect.KClass

@OptIn(ExperimentalSerializationApi::class)
@SerialInfo
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.CLASS)
annotation class ByteEnum

// TODO: Restrict ByteEnum when Map's both key and value types are enum.

fun List<Annotation>?.isByteEnum(): Boolean {
    if (this == null) return false

    for (annotation in this) {
        if (annotation is ByteEnum) return true
    }

    return false
}

@OptIn(ExperimentalSerializationApi::class)
@SerialInfo
@Target(AnnotationTarget.PROPERTY)
annotation class FromVersion(val version: String)

@OptIn(ExperimentalSerializationApi::class)
@SerialInfo
@Target(AnnotationTarget.PROPERTY)
annotation class UntilVersion(val version: String)

fun List<Annotation>?.isPresentIn(version: SerializationVersion): Boolean {
    if (this == null) return true

    var from: String? = null
    var until: String? = null

    for (annotation in this) {
        if (annotation is FromVersion) from = annotation.version
        if (annotation is UntilVersion) until = annotation.version
    }

    return (from == null || version newer from) && (until == null || version older until)
}

@OptIn(ExperimentalSerializationApi::class)
@SerialInfo
@Target(AnnotationTarget.PROPERTY)
annotation class VariantOf(val of: KClass<*>)

fun List<Annotation>?.getVariantCompanion(): Variant<*>? {
    if (this == null) return null

    for (annotation in this) {
        if (annotation is VariantOf) return annotation.of.getVariantCompanion()
    }

    return null
}