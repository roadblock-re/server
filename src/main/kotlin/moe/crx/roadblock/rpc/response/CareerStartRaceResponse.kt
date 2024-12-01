package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.objects.game.RequiredPlaybackCondition
import moe.crx.roadblock.objects.game.RequiredPlaybackDetailLevel
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class CareerStartRaceResponse : UpdatesQueueWithRootReactionsResponse() {

    var raceId: RaceToken = 0
    var playbackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer
    var playbackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never

    override fun read(sink: InputSink) {
        super.read(sink)
        raceId = sink.readInt()
        playbackDetailLevel = sink.readEnum()
        playbackCondition = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceId)
        sink.writeEnum(playbackDetailLevel)
        sink.writeEnum(playbackCondition)
    }
}