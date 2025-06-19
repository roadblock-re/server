package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class PlatformCredentials : RObject {

    var authority: CredentialAuthority = CredentialAuthority.Uninitialized
    var username: String = ""

    override fun read(sink: InputSink) {
        authority = sink.readEnum()
        username = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(authority)
        sink.writeString(username)
    }
}