package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.blackmarket.BlackMarketFatigue
import moe.crx.roadblock.objects.blackmarket.BlackMarketSlot

class BlackMarketState : RObject {

    var isLocked: Boolean = false
    var slots: List<BlackMarketSlot> = listOf()
    var fatigueConsecutiveRefreshes: List<BlackMarketFatigue> = listOf()
    var fatigueCooldownRefreshes: List<BlackMarketFatigue> = listOf()
    var dailyRefreshes: Byte = 0
    var nextDailyRefreshesResetTime: Instant = now()
    var nextAutoRefreshTime: Instant = now()

    override fun read(sink: InputSink) {
        isLocked = sink.readBoolean()
        slots = sink.readList()
        fatigueConsecutiveRefreshes = sink.readList()
        fatigueCooldownRefreshes = sink.readList()
        dailyRefreshes = sink.readByte()
        nextDailyRefreshesResetTime = sink.readInstant()
        nextAutoRefreshTime = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(isLocked)
        sink.writeList(slots)
        sink.writeList(fatigueConsecutiveRefreshes)
        sink.writeList(fatigueCooldownRefreshes)
        sink.writeByte(dailyRefreshes)
        sink.writeInstant(nextDailyRefreshesResetTime)
        sink.writeInstant(nextAutoRefreshTime)
    }
}