package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.ClubInvitationId
import moe.crx.roadblock.objects.game.ClubMemberRank
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket

class AcceptClubInvitationRequest : RequestPacket() {

    var invitationId: ClubInvitationId = ""
    var senderCredential: Credentials = Credentials()
    var senderRank: ClubMemberRank = ClubMemberRank.Manager
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        invitationId = sink.readString()
        senderCredential = sink.readObject()
        senderRank = sink.readEnum()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(invitationId)
        sink.writeObject(senderCredential)
        sink.writeEnum(senderRank)
        sink.writeString(debugSuffix)
    }
}