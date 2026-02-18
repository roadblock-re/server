package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.club.ClubLogo
import moe.crx.roadblock.objects.game.CurrencyType
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.rpc.base.RequestPacket

class CreateClubRequest : RequestPacket() {

    var name: String = ""
    var motto: String = ""
    var logo: ClubLogo = ClubLogo()
    var regionId: Short = 0
    var membershipType: Int = 0
    var currencyType: CurrencyType = CurrencyType.Credits
    var cost: Money = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        name = sink.readString()
        motto = sink.readString()
        logo = sink.readObject()
        regionId = sink.readShort()
        membershipType = sink.readInt()
        currencyType = sink.readEnum()
        cost = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(name)
        sink.writeString(motto)
        sink.writeObject(logo)
        sink.writeShort(regionId)
        sink.writeInt(membershipType)
        sink.writeEnum(currencyType)
        sink.writeInt(cost)
    }
}