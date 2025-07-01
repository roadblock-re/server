package moe.crx.roadblock.io.sinks

import moe.crx.roadblock.objects.game.SerializationVersion

abstract class Sink(val ver: SerializationVersion) {

    infix fun older(version: String): Boolean {
        return ver older version
    }

    infix fun newer(version: String): Boolean {
        return ver newer version
    }
}