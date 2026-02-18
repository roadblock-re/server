package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.rpc.base.RequestPacket

class MiscellaneousSetUserOnlinePrivacyPolicyRequest :
    RequestPacket() {

    var privacyPolicy: RByte? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        privacyPolicy = if (sink older "24.6.0") {
            sink.readOptional()
        } else {
            RByte(sink.readInt().toByte())
        }
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        if (sink older "24.6.0") {
            sink.writeOptional(privacyPolicy)
        } else {
            sink.writeInt(privacyPolicy?.value?.toInt() ?: 0)
        }
    }
}