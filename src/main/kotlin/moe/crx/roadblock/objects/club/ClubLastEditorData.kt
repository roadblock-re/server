package moe.crx.roadblock.objects.club

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.objects.game.CredentialsList

class ClubLastEditorData : RObject {

    var credential: Credentials = Credentials()
    var timestamp: Instant = now()
    var alias: RString? = null
    var name: RString? = null
    var platform: RInt? = null
    var allCredentials: CredentialsList? = null

    override fun read(sink: InputSink) {
        credential = sink.readObject()
        timestamp = sink.readInstant()
        alias = sink.readOptional()
        name = sink.readOptional()
        platform = sink.readOptional()
        allCredentials = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(credential)
        sink.writeInstant(timestamp)
        sink.writeOptional(alias)
        sink.writeOptional(name)
        sink.writeOptional(platform)
        sink.writeOptional(allCredentials)
    }

}
