package moe.crx.roadblock.objects.gauntlet

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class GauntletOpponentOptional : RObject {

    var opponent: GauntletOpponent? = null

    override fun read(sink: InputSink) {
        opponent = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(opponent)
    }
}