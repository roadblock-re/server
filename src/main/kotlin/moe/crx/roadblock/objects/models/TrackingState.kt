package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject

class TrackingState : RObject {

    var trackingToken: Int = 0
    var gameTime: Float = 0f
    var sessionId: Int = 0
    var sessionTime: Float = 0f
    var trackingBannedState: RByte? = null

    override fun read(sink: InputSink) {
        trackingToken = sink.readInt()
        gameTime = sink.readFloat()
        sessionId = sink.readInt()
        sessionTime = sink.readFloat()
        trackingBannedState = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(trackingToken)
        sink.writeFloat(gameTime)
        sink.writeInt(sessionId)
        sink.writeFloat(sessionTime)
        sink.writeOptional(trackingBannedState)
    }
}