package moe.crx.roadblock.rpc.response

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class CreateTransferCodeResponse : UpdatesQueueWithRootReactionsResponse() {

    var code: String = ""
    var expirationTime: Instant = now()

    override fun read(sink: InputSink) {
        super.read(sink)
        code = sink.readString()
        expirationTime = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(code)
        sink.writeInstant(expirationTime)
    }
}