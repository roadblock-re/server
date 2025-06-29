package moe.crx.roadblock.objects.piggybank

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInstant
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Money

class PiggyBankState : RObject {

    var startDate: Instant = now()
    var eventId: Int = 0
    var currentTier: Int = 0
    var currentProgress: Int = 0
    var bankFilledTimestamp: RInstant? = null
    var tiers: Map<RInt, PiggyBankTierState> = mapOf()
    var totalProgress: Money = 0

    override fun read(sink: InputSink) {
        startDate = sink.readInstant()
        eventId = sink.readInt()
        currentTier = sink.readInt()
        currentProgress = sink.readInt()
        bankFilledTimestamp = sink.readOptional()
        tiers = sink.readMap()
        if (sink newer "24.0.0") {
            totalProgress = sink.readInt()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(startDate)
        sink.writeInt(eventId)
        sink.writeInt(currentTier)
        sink.writeInt(currentProgress)
        sink.writeOptional(bankFilledTimestamp)
        sink.writeMap(tiers)
        if (sink newer "24.0.0") {
            sink.writeInt(totalProgress)
        }
    }
}