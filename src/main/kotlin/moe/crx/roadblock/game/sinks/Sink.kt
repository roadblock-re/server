package moe.crx.roadblock.game.sinks

import moe.crx.roadblock.game.serialization.SerializationVersion

abstract class Sink(var ver: SerializationVersion) {

    infix fun older(version: String): Boolean {
        return ver older version
    }

    infix fun newer(version: String): Boolean {
        return ver newer version
    }
}