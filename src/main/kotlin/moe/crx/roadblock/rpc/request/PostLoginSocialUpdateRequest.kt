package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.social.SocialUpdateReason
import moe.crx.roadblock.rpc.base.RequestPacket

class PostLoginSocialUpdateRequest : RequestPacket() {

    var reason: SocialUpdateReason = SocialUpdateReason.Cheats
    var debugEnableAlerts: Boolean = false

    override fun read(sink: InputSink) {
        super.read(sink)
        reason = sink.readEnum()
        debugEnableAlerts = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeEnum(reason)
        sink.writeBoolean(debugEnableAlerts)
    }
}