package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class PrivateLobbyStartRaceSpectatorResponse : UpdatesQueueWithRootReactionsResponse() {

    var gameplayServerLoginKey: Long = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        gameplayServerLoginKey = sink.readLong()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeLong(gameplayServerLoginKey)
    }
}