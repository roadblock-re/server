package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ActivationBlackMarketState : RObject {

    var slots: List<ActivationBlackMarketSlot> = listOf()
    var dailyRefreshes: Byte = 0
    var nextDailyRefreshesResetTime: Instant = now()
    var nextAutoRefreshTime: Instant = now()

    override fun read(sink: InputSink) {
        slots = sink.readList()
        dailyRefreshes = sink.readByte()
        nextDailyRefreshesResetTime = sink.readInstant()
        nextAutoRefreshTime = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(slots)
        sink.writeByte(dailyRefreshes)
        sink.writeInstant(nextDailyRefreshesResetTime)
        sink.writeInstant(nextAutoRefreshTime)
    }

}
