package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.PlatformCredentials
import moe.crx.roadblock.rpc.base.RequestPacket

class ActionLoginRequest : RequestPacket() {

    var optSystemNotificationType: RInt? = null
    var platformCredentials: PlatformCredentials? = null
    var platformUsername: RString? = null
    var psnIssuerId: RString? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        optSystemNotificationType = sink.readOptional()
        platformCredentials = sink.readOptional()
        if (sink newer "24.0.0") {
            platformUsername = sink.readOptional()
            psnIssuerId = sink.readOptional()
        }
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeOptional(optSystemNotificationType)
        sink.writeOptional(platformCredentials)
        if (sink newer "24.0.0") {
            sink.writeOptional(platformUsername)
            sink.writeOptional(psnIssuerId)
        }
    }
}