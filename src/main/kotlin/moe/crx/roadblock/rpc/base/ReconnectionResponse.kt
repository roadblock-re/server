package moe.crx.roadblock.rpc.base

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Error

class ReconnectionResponse : RObject {

    var error: Error? = null
    var lastActionId: Int = 0
    var lastCommitedActionId: Int = 0

    override fun read(sink: InputSink) {
        sink.readByte() // 2
        error = sink.readOptional()
        lastActionId = sink.readInt()
        lastCommitedActionId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(2)
        sink.writeOptional(error)
        sink.writeInt(lastActionId)
        sink.writeInt(lastCommitedActionId)
    }
}