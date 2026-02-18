package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RBoolean
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class UserAccountInfo : RObject {

    var credentials: List<RString> = listOf()
    var lastLogin: RString? = null
    var alias: RString? = null
    var account: String = ""
    var installations: UserInstallations? = null
    var isGhost: RBoolean? = null

    override fun read(sink: InputSink) {
        credentials = sink.readList()
        lastLogin = sink.readOptional()
        alias = sink.readOptional()
        account = sink.readString()
        installations = sink.readOptional()
        isGhost = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(credentials)
        sink.writeOptional(lastLogin)
        sink.writeOptional(alias)
        sink.writeString(account)
        sink.writeOptional(installations)
        sink.writeOptional(isGhost)
    }
}