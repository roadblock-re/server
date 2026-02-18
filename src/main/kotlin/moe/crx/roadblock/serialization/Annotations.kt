package moe.crx.roadblock.serialization

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialInfo

@OptIn(ExperimentalSerializationApi::class)
@SerialInfo
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.CLASS)
annotation class ByteEnum

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