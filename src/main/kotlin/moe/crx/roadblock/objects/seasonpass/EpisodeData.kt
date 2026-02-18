package moe.crx.roadblock.objects.seasonpass

import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RShort

class EpisodeData : RObject {

    var missions: Map<RShort, MissionData> = mapOf()
    var partiallyCompletedRewardState: Byte = 0

    override fun read(sink: InputSink) {
        missions = sink.readMap()
        partiallyCompletedRewardState = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(missions)
        sink.writeByte(partiallyCompletedRewardState)
    }
}