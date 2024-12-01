package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.ClubId
import moe.crx.roadblock.objects.game.ClubMemberRank
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket

class KickClubMemberRequest : RequestPacket() {

    var clubId: ClubId = ""
    var memberCredential: Credentials = Credentials()
    var memberName: String = ""
    var memberRank: ClubMemberRank = ClubMemberRank.Manager
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        clubId = sink.readString()
        memberCredential = sink.readObject()
        memberName = sink.readString()
        memberRank = sink.readEnum()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(clubId)
        sink.writeObject(memberCredential)
        sink.writeString(memberName)
        sink.writeEnum(memberRank)
        sink.writeString(debugSuffix)
    }
}