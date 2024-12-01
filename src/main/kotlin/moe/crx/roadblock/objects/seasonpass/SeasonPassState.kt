package moe.crx.roadblock.objects.seasonpass

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject

class SeasonPassState : RObject {

    var endDate: Instant = now()
    var seasonPassId: Int = 0
    var episodes: Map<RByte, EpisodeData> = mapOf()
    var tiers: Map<RByte, TierData> = mapOf()
    var benefits: LegendPassBenefitsMultipliers = LegendPassBenefitsMultipliers()
    var nextDayFromLastRace: Instant = now()

    override fun read(sink: InputSink) {
        endDate = sink.readInstant()
        seasonPassId = sink.readInt()
        episodes = sink.readMap()
        tiers = sink.readMap()
        benefits = sink.readObject()
        nextDayFromLastRace = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(endDate)
        sink.writeInt(seasonPassId)
        sink.writeMap(episodes)
        sink.writeMap(tiers)
        sink.writeObject(benefits)
        sink.writeInstant(nextDayFromLastRace)
    }
}