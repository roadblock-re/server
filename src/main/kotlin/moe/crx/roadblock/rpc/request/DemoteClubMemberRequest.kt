package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.ClubId
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket

class DemoteClubMemberRequest : RequestPacket() {

    var clubId: ClubId = ""
    var memberCredential: Credentials = Credentials()
    var memberName: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        clubId = sink.readString()
        memberCredential = sink.readObject()
        memberName = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(clubId)
        sink.writeObject(memberCredential)
        sink.writeString(memberName)
    }
}