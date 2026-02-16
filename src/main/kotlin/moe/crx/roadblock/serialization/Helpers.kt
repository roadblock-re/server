package moe.crx.roadblock.serialization

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialInfo
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
data class Blob(val bytes: ByteArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Blob) return false
        return bytes.contentEquals(other.bytes)
    }

    override fun hashCode() = bytes.contentHashCode()
}

interface VariantCompanion<T : Any> {
    fun variants(version: SerializationVersion): List<KClass<out T>>
}

@OptIn(ExperimentalSerializationApi::class)
@SerialInfo
@Target(AnnotationTarget.PROPERTY)
annotation class ByteEnum

fun List<Annotation>?.byteEnum(): Boolean {
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