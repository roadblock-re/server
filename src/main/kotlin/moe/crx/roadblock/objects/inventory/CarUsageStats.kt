package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInstant
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class CarUsageStats : RObject {

    var lastUsageTime: RInstant? = null
    var consecutiveDays: RInt? = null
    var numRacesCareer: Short = 0
    var numRacesMultiplayer: Short = 0
    var numRacesTLE: Short = 0
    var numRacesClubRace: Short = 0

    override fun read(sink: InputSink) {
        lastUsageTime = sink.readOptional()
        consecutiveDays = sink.readOptional()
        numRacesCareer = sink.readShort()
        numRacesMultiplayer = sink.readShort()
        numRacesTLE = sink.readShort()
        if (sink older "24.6.0") {
            numRacesClubRace = sink.readShort()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(lastUsageTime)
        sink.writeOptional(consecutiveDays)
        sink.writeShort(numRacesCareer)
        sink.writeShort(numRacesMultiplayer)
        sink.writeShort(numRacesTLE)
        if (sink older "24.6.0") {
            sink.writeShort(numRacesClubRace)
        }
    }
}