package moe.crx.roadblock.game.serialization

import kotlinx.serialization.Serializable

@Serializable
data class SerializationVersion(var major: UShort, var minor: UShort, var build: UShort) :
    Comparable<SerializationVersion> {

    companion object {
        val versionRegex = Regex("(\\d+)\\.(\\d+)\\.(\\d+)(\\w*)")
    }

    constructor() : this(0u, 0u, 0u)

    constructor(version: String) : this() {
        val match = versionRegex.find(version)
        major = match?.groups[1]?.value?.toShortOrNull()?.toUShort() ?: 0u
        minor = match?.groups[2]?.value?.toShortOrNull()?.toUShort() ?: 0u
        build = match?.groups[3]?.value?.toShortOrNull()?.toUShort() ?: 0u
    }

    override fun compareTo(other: SerializationVersion): Int {
        if (this.major != other.major) return this.major.compareTo(other.major)
        if (this.minor != other.minor) return this.minor.compareTo(other.minor)
        return this.build.compareTo(other.build)
    }

    infix fun newer(v: String) = this >= SerializationVersion(v)

    infix fun older(v: String) = this < SerializationVersion(v)

    infix fun eq(v: String) = this == SerializationVersion(v)

    override fun equals(other: Any?): Boolean {
        return other is SerializationVersion && other.major == major && other.minor == minor && other.build == build
    }

    override fun hashCode(): Int {
        var result = major.toInt()
        result = 31 * result + minor.toInt()
        result = 31 * result + build.toInt()
        return result
    }

    override fun toString(): String {
        return "$major.$minor.$build"
    }
}

