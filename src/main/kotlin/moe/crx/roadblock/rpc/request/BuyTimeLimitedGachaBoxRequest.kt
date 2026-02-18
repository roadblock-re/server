package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket

class BuyTimeLimitedGachaBoxRequest : RequestPacket() {

    var calendarEventId: CalendarEventId = ""
    var count: Int = 0
    var compactRewards: Boolean = false
    var doCriticalRoll: Boolean = false
    var walletEventId: RString? = null // CalendarEventId

    override fun read(sink: InputSink) {
        super.read(sink)
        calendarEventId = sink.readString()
        count = sink.readInt()
        compactRewards = sink.readBoolean()
        doCriticalRoll = sink.readBoolean()
        walletEventId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(calendarEventId)
        sink.writeInt(count)
        sink.writeBoolean(compactRewards)
        sink.writeBoolean(doCriticalRoll)
        sink.writeOptional(walletEventId)
    }
}