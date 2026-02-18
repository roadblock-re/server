package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class PlatformCredentials : RObject {

    var authority: CredentialAuthority = CredentialAuthority.Uninitialized
    var username: String = ""

    override fun read(sink: InputSink) {
        if (sink older "24.0.0") {
            authority = sink.readEnum()
        }
        username = sink.readString()
    }

    override fun write(sink: OutputSink) {
        if (sink older "24.0.0") {
            sink.writeEnum(authority)
        }
        sink.writeString(username)
    }
}