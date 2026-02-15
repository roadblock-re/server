package moe.crx.roadblock.serialization

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class SerializationVersion(var major: Short, var minor: Short, var build: Short) : RObject,
    Comparable<SerializationVersion> {

    companion object {
        val versionRegex = Regex("(\\d+)\\.(\\d+)\\.(\\d+)(\\w*)")
    }

    constructor() : this(0, 0, 0)

    constructor(version: String) : this() {
        val match = versionRegex.find(version)
        major = match?.groups[1]?.value?.toShortOrNull() ?: 0
        minor = match?.groups[2]?.value?.toShortOrNull() ?: 0
        build = match?.groups[3]?.value?.toShortOrNull() ?: 0
    }

    override fun read(sink: InputSink) {
        major = sink.readShort()
        minor = sink.readShort()
        build = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(major)
        sink.writeShort(minor)
        sink.writeShort(build)
    }

    override fun compareTo(other: SerializationVersion): Int {
        if (this.major != other.major) return this.major.compareTo(other.major)
        if (this.minor != other.minor) return this.minor.compareTo(other.minor)
        return this.build.compareTo(other.build)
    }

    infix fun newer(v: String) = this >= SerializationVersion(v)
    
    infix fun older(v: String) = this < SerializationVersion(v)

    override fun equals(other: Any?): Boolean {
        return other is SerializationVersion && other.major == major && other.minor == minor && other.build == build
    }

    override fun hashCode(): Int {
        var result = major.toInt()
        result = 31 * result + minor
        result = 31 * result + build
        return result
    }

    override fun toString(): String {
        return "$major.$minor.$build"
    }
}