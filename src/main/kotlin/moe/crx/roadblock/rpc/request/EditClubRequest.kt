package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.club.ClubLogo
import moe.crx.roadblock.objects.game.ClubId
import moe.crx.roadblock.rpc.base.RequestPacket

class EditClubRequest : RequestPacket() {

    var clubId: ClubId = ""
    var name: String = ""
    var motto: String = ""
    var logo: ClubLogo = ClubLogo()
    var regionId: Short = 0
    var membershipType: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        clubId = sink.readString()
        name = sink.readString()
        motto = sink.readString()
        logo = sink.readObject()
        regionId = sink.readShort()
        membershipType = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(clubId)
        sink.writeString(name)
        sink.writeString(motto)
        sink.writeObject(logo)
        sink.writeShort(regionId)
        sink.writeInt(membershipType)
    }
}