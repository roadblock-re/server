package moe.crx.roadblock.io.sinks

import moe.crx.roadblock.objects.game.SerializationVersion

abstract class Sink(val ver: SerializationVersion) {

    infix fun older(version: String): Boolean {
        val split = version.split('.')
        val major = split[0].toInt()
        val minor = split[1].toInt()
        val build = split[2].toInt()

        if (major > ver.major) {
            return true
        }

        if (minor > ver.minor) {
            return true
        }

        if (build > ver.build) {
            return true
        }

        return false
    }

    infix fun newer(version: String): Boolean {
        val split = version.split('.')
        val major = split[0].toInt()
        val minor = split[1].toInt()
        val build = split[2].toInt()

        if (major < ver.major) {
            return true
        }

        if (minor < ver.minor) {
            return true
        }

        if (build < ver.build) {
            return true
        }

        return false
    }
}