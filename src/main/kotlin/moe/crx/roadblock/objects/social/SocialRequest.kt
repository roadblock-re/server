package moe.crx.roadblock.objects.social

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.FriendRequestId
import moe.crx.roadblock.objects.game.OnlineUserData

class SocialRequest : RObject {

    var id: FriendRequestId = ""
    var creation: Instant = now()
    var connectionType: String = ""
    var requesterUserData: OnlineUserData = OnlineUserData()
    var connectorUserData: OnlineUserData? = null

    override fun read(sink: InputSink) {
        id = sink.readString()
        creation = sink.readInstant()
        connectionType = sink.readString()
        requesterUserData = sink.readObject()
        connectorUserData = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(id)
        sink.writeInstant(creation)
        sink.writeString(connectionType)
        sink.writeObject(requesterUserData)
        sink.writeOptional(connectorUserData)
    }
}