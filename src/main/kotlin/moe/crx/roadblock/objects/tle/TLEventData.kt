package moe.crx.roadblock.objects.tle

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class TLEventData : RObject {

    var soloData: SoloTLEventData = SoloTLEventData()
    var rankData: RankTLEventData = RankTLEventData()
    var clubData: ClubTLEventData = ClubTLEventData()
    var bestRace: TLEventRaceData = TLEventRaceData()
    var quarantine: TLEventQuarantineData? = null
    var timestamp: Instant = now()
    var forceQuarantine: Boolean = false
    var isAutoClaimed: Boolean = false
    var nitroGhostResetCount: Int = 0 // 3.9+ only (also maybe 3.8)
    var bestNitroGhostTimeInSeconds: Int = 0 // 3.9+ only (also maybe 3.8)
    var lastRace: TLEventLastRace = TLEventLastRace()
    var optAutoplayData: TLEventAutoplayData? = null
    var evoFreeTryData: Map<RString, EvoFreeTryData> = mapOf()

    override fun read(sink: InputSink) {
        soloData = sink.readObject()
        rankData = sink.readObject()
        clubData = sink.readObject()
        bestRace = sink.readObject()
        quarantine = sink.readOptional()
        timestamp = sink.readInstant()
        forceQuarantine = sink.readBoolean()
        isAutoClaimed = sink.readBoolean()
        nitroGhostResetCount = sink.readInt()
        bestNitroGhostTimeInSeconds = sink.readInt()
        if (sink newer "24.6.0") {
            lastRace = sink.readObject()
            optAutoplayData = sink.readOptional()
        }
        if (sink newer "47.1.0") {
            evoFreeTryData = sink.readMap()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(soloData)
        sink.writeObject(rankData)
        sink.writeObject(clubData)
        sink.writeObject(bestRace)
        sink.writeOptional(quarantine)
        sink.writeInstant(timestamp)
        sink.writeBoolean(forceQuarantine)
        sink.writeBoolean(isAutoClaimed)
        sink.writeInt(nitroGhostResetCount)
        sink.writeInt(bestNitroGhostTimeInSeconds)
        if (sink newer "24.6.0") {
            sink.writeObject(lastRace)
            sink.writeOptional(optAutoplayData)
        }
        if (sink newer "47.1.0") {
            sink.writeMap(evoFreeTryData)
        }
    }
}