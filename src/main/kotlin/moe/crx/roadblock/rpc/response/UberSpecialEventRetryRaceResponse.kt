package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class UberSpecialEventRetryRaceResponse : UpdatesQueueWithRootReactionsResponse() {

    var raceToken: RaceToken = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        raceToken = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceToken)
    }
}