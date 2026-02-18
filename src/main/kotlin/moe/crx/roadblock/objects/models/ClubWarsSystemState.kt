package moe.crx.roadblock.objects.models

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.clubwars.ClubWarsMarketState
import moe.crx.roadblock.objects.clubwars.ClubWarsState

class ClubWarsSystemState : RObject {

    var state: ClubWarsState = ClubWarsState()
    var market: ClubWarsMarketState = ClubWarsMarketState()

    override fun read(sink: InputSink) {
        state = sink.readObject()
        market = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(state)
        sink.writeObject(market)
    }
}