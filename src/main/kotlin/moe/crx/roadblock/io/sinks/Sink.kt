package moe.crx.roadblock.io.sinks

import moe.crx.roadblock.serialization.SerializationVersion

abstract class Sink(var ver: SerializationVersion) {

    infix fun older(version: String): Boolean {
        return ver older version
    }

    infix fun newer(version: String): Boolean {
        return ver newer version
    }
}