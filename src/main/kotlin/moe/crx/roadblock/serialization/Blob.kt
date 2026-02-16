package moe.crx.roadblock.serialization

import kotlinx.serialization.Serializable

@Serializable
data class Blob(val bytes: ByteArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Blob) return false
        return bytes.contentEquals(other.bytes)
    }

    override fun hashCode() = bytes.contentHashCode()
}