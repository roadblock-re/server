package moe.crx.roadblock.objects.social

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.objects.game.OnlineUserData

class UserCredentialInfo : RObject {

    var fedId: Credentials = Credentials()
    var credentials: List<Credentials> = listOf()
    var publicUserData: OnlineUserData? = null

    override fun read(sink: InputSink) {
        fedId = sink.readObject()
        credentials = sink.readList()
        publicUserData = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(fedId)
        sink.writeList(credentials)
        sink.writeOptional(publicUserData)
    }
}