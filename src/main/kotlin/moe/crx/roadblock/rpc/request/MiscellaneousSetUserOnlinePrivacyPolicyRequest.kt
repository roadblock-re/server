package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RBoolean
import moe.crx.roadblock.rpc.base.RequestPacket

class MiscellaneousSetUserOnlinePrivacyPolicyRequest :
    RequestPacket() {

    var isGPDRCompliant: RBoolean? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        isGPDRCompliant = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeOptional(isGPDRCompliant)
    }
}