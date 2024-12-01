package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.objects.game.StatusUpdatesQueueWithRootReactions
import moe.crx.roadblock.rpc.base.ResponsePacket

class MultiplayerSeriesStartMatchmakingResponse : ResponsePacket() {

    var raceToken: RaceToken = 0
    var finishRaceRetries: List<RInt> = listOf()
    var updates: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions()

    override fun read(sink: InputSink) {
        super.read(sink)
        raceToken = sink.readInt()
        finishRaceRetries = sink.readList()
        updates = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceToken)
        sink.writeList(finishRaceRetries)
        sink.writeObject(updates)
    }
}