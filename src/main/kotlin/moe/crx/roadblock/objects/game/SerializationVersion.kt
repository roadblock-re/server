package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class SerializationVersion(var major: Short, var minor: Short, var build: Short) : RObject {

    constructor() : this(0, 0, 0)

    constructor(version: String) : this() {
        val split = version.split('.')
        major = split[0].toShort()
        minor = split[1].toShort()
        build = split[2].toShort()
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

    infix fun older(version: String): Boolean {
        return !newer(version)
    }

    infix fun newer(version: String): Boolean {
        val compared = SerializationVersion(version)

        if (this.major >= compared.major) {
            return true
        }

        if (this.minor >= compared.minor) {
            return true
        }

        if (this.build >= compared.build) {
            return true
        }

        return false
    }

    override fun equals(other: Any?): Boolean {
        return other is SerializationVersion && other.major == major && other.minor == minor && other.build == build
    }

    override fun hashCode(): Int {
        var result = major.toInt()
        result = 31 * result + minor
        result = 31 * result + build
        return result
    }
}