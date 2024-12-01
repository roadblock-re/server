package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CurrencyType
import moe.crx.roadblock.objects.game.Money
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket

class TLEventResetNitroGhostRequest : RequestPacket() {

    var tlEventId: TLEventId = TLEventId()
    var currencyType: CurrencyType = CurrencyType.Credits
    var cost: Money = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        tlEventId = sink.readObject()
        currencyType = sink.readEnum()
        cost = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(tlEventId)
        sink.writeEnum(currencyType)
        sink.writeInt(cost)
    }
}