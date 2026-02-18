package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.social.SocialUpdateReason
import moe.crx.roadblock.rpc.base.RequestPacket

class PostLoginSocialUpdateRequest : RequestPacket() {

    var reason: SocialUpdateReason = SocialUpdateReason.Cheats
    var debugEnableAlerts: Boolean = false
    var platformHasPlatformUsersList: Boolean = false

    override fun read(sink: InputSink) {
        super.read(sink)
        reason = sink.readEnum()
        debugEnableAlerts = sink.readBoolean()
        if (sink newer "45.0.0") {
            platformHasPlatformUsersList = sink.readBoolean()
        }
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeEnum(reason)
        sink.writeBoolean(debugEnableAlerts)
        if (sink newer "45.0.0") {
            sink.writeBoolean(platformHasPlatformUsersList)
        }
    }
}