package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class SerializationVersion(var major: Short, var minor: Short, var build: Short) : RObject {

    constructor() : this(0, 0, 0)

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
        val split = version.split('.')
        val major = split[0].toInt()
        val minor = split[1].toInt()
        val build = split[2].toInt()

        if (this.major < major) {
            return false
        }

        if (this.minor < minor) {
            return false
        }

        if (this.build < build) {
            return false
        }

        return true
    }
}