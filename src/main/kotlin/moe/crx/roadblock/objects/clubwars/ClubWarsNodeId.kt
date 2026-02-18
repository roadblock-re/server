package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ClubWarsBoardNodeId
import moe.crx.roadblock.objects.game.ClubWarsRegionId
import moe.crx.roadblock.objects.game.ClubWarsRoundIndex

class ClubWarsNodeId : RObject {

    var roundId: ClubWarsRoundIndex = 0
    var regionId: ClubWarsRegionId = 0
    var nodeId: ClubWarsBoardNodeId = 0

    override fun read(sink: InputSink) {
        roundId = sink.readByte()
        regionId = sink.readShort()
        nodeId = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(roundId)
        sink.writeShort(regionId)
        sink.writeShort(nodeId)
    }
}