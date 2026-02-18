package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.ClubId
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket

class InviteUserRequest : RequestPacket() {

    var userCredential: Credentials = Credentials()
    var clubId: ClubId = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        userCredential = sink.readObject()
        clubId = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(userCredential)
        sink.writeString(clubId)
    }
}