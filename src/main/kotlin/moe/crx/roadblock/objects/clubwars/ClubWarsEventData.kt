package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject

class ClubWarsEventData : RObject {

    var rounds: Map<RByte, ClubWarsRoundData> = mapOf()
    var claimData: ClubWarsClaimData = ClubWarsClaimData()

    override fun read(sink: InputSink) {
        rounds = sink.readMap()
        claimData = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(rounds)
        sink.writeObject(claimData)
    }
}