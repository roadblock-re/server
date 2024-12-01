package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.objects.game.RequiredPlaybackCondition
import moe.crx.roadblock.objects.game.RequiredPlaybackDetailLevel
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class TLEventStartRaceResponse : UpdatesQueueWithRootReactionsResponse() {

    var raceId: RaceToken = 0
    var playbackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer
    var playbackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never
    var requiredPlaybackRaceTimeToBeatMicroseconds: RInt? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        raceId = sink.readInt()
        playbackDetailLevel = sink.readEnum()
        playbackCondition = sink.readEnum()
        requiredPlaybackRaceTimeToBeatMicroseconds = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceId)
        sink.writeEnum(playbackDetailLevel)
        sink.writeEnum(playbackCondition)
        sink.writeOptional(requiredPlaybackRaceTimeToBeatMicroseconds)
    }
}