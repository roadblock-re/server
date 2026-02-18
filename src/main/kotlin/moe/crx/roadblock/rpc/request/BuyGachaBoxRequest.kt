package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.gacha.GachaType
import moe.crx.roadblock.rpc.base.RequestPacket

class BuyGachaBoxRequest : RequestPacket() {

    var gachaType: GachaType = GachaType.Retention
    var count: Int = 0
    var compactRewards: Boolean = false
    var doCriticalRoll: Boolean = false
    var walletEventId: RString? = null // CalendarEventId

    override fun read(sink: InputSink) {
        super.read(sink)
        gachaType = sink.readEnum()
        count = sink.readInt()
        compactRewards = sink.readBoolean()
        doCriticalRoll = sink.readBoolean()
        walletEventId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeEnum(gachaType)
        sink.writeInt(count)
        sink.writeBoolean(compactRewards)
        sink.writeBoolean(doCriticalRoll)
        sink.writeOptional(walletEventId)
    }
}