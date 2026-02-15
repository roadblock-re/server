package moe.crx.roadblock.serialization

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialInfo

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