package moe.crx.roadblock.io.sinks

import moe.crx.roadblock.objects.game.SerializationVersion

abstract class Sink(val ver: SerializationVersion) {

    infix fun older(version: String): Boolean {
        return !newer(version)
    }

    infix fun newer(version: String): Boolean {
        val split = version.split('.')
        val major = split[0].toInt()
        val minor = split[1].toInt()
        val build = split[2].toInt()

        if (ver.major < major) {
            return false
        }

        if (ver.minor < minor) {
            return false
        }

        if (ver.build < build) {
            return false
        }

        return true
    }
}