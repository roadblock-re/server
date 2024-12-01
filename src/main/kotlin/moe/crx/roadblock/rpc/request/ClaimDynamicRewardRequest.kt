package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket

class ClaimDynamicRewardRequest : RequestPacket() {

    var templateId: String = ""
    var sourceCredential: Credentials? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        templateId = sink.readString()
        sourceCredential = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(templateId)
        sink.writeOptional(sourceCredential)
    }
}