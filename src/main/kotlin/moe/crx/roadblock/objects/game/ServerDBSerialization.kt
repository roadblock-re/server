package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ServerDBSerialization : RObject {

    var gameDb: ConfigData? = null
    var carWhitelist: ConfigData? = null

    override fun read(sink: InputSink) {
        gameDb = sink.readOptional()
        carWhitelist = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(gameDb)
        sink.writeOptional(carWhitelist)
    }
}