package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.objects.game.RequiredPlaybackCondition
import moe.crx.roadblock.objects.game.RequiredPlaybackDetailLevel
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class ChampionshipSpecialEventStartQualifyingRaceResponse : UpdatesQueueWithRootReactionsResponse() {

    var raceToken: RaceToken = 0
    var requiredPlaybackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer
    var requiredPlaybackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never

    override fun read(sink: InputSink) {
        super.read(sink)
        raceToken = sink.readInt()
        requiredPlaybackDetailLevel = sink.readEnum()
        requiredPlaybackCondition = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceToken)
        sink.writeEnum(requiredPlaybackDetailLevel)
        sink.writeEnum(requiredPlaybackCondition)
    }
}