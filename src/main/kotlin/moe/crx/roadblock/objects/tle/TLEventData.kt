package moe.crx.roadblock.objects.tle

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

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
    }
}