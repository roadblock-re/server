package moe.crx.roadblock.objects.uber

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.UberExperience
import moe.crx.roadblock.objects.game.UberHazardLevel

class UberSpecialEventData : RObject {

    var experience: UberExperience = 0
    var tierData: List<UberSpecialTierData> = listOf()
    var levelData: List<UberSpecialLevelData> = listOf()
    var currentHazardLevel: UberHazardLevel = 0
    var lastHazardCleanTime: Instant = now()
    var hasCurrencyBeenConverted: Boolean = false
    var discoveredCars: List<RInt> = listOf()

    override fun read(sink: InputSink) {
        experience = sink.readInt()
        tierData = sink.readList()
        levelData = sink.readList()
        currentHazardLevel = sink.readInt()
        lastHazardCleanTime = sink.readInstant()
        hasCurrencyBeenConverted = sink.readBoolean()
        discoveredCars = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(experience)
        sink.writeList(tierData)
        sink.writeList(levelData)
        sink.writeInt(currentHazardLevel)
        sink.writeInstant(lastHazardCleanTime)
        sink.writeBoolean(hasCurrencyBeenConverted)
        sink.writeList(discoveredCars)
    }
}