package moe.crx.roadblock.objects.championship

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.ChampionshipRoundId

class ChampionshipSpecialEventData : RObject {

    var qualifyingData: ChampionshipQualifyingStageData = ChampionshipQualifyingStageData()
    var finalsData: ChampionshipFinalsStageData = ChampionshipFinalsStageData()
    var registeredFromRound: ChampionshipRoundId = 0
    var isQualified: Boolean = false
    var qualifiedInRound: ChampionshipRoundId = 0
    var claimData: ChampionshipClaimData = ChampionshipClaimData()
    var nextFreePackClaimTimePoint: Instant = now()
    var needsSyncServices: Boolean = false
    var forceBan: Boolean = false
    var pushNotificationCount: Int = 0
    var usedDebugSuffix: List<RString> = listOf()
    var nitroGhostResetCount: Int = 0
    var bestNitroGhostTimePerTrackDef: Map<RInt, RInt> = mapOf()

    override fun read(sink: InputSink) {
        qualifyingData = sink.readObject()
        finalsData = sink.readObject()
        registeredFromRound = sink.readInt()
        isQualified = sink.readBoolean()
        qualifiedInRound = sink.readInt()
        claimData = sink.readObject()
        nextFreePackClaimTimePoint = sink.readInstant()
        needsSyncServices = sink.readBoolean()
        forceBan = sink.readBoolean()
        pushNotificationCount = sink.readInt()
        usedDebugSuffix = sink.readList()
        nitroGhostResetCount = sink.readInt()
        bestNitroGhostTimePerTrackDef = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(qualifyingData)
        sink.writeObject(finalsData)
        sink.writeInt(registeredFromRound)
        sink.writeBoolean(isQualified)
        sink.writeInt(qualifiedInRound)
        sink.writeObject(claimData)
        sink.writeInstant(nextFreePackClaimTimePoint)
        sink.writeBoolean(needsSyncServices)
        sink.writeBoolean(forceBan)
        sink.writeInt(pushNotificationCount)
        sink.writeList(usedDebugSuffix)
        sink.writeInt(nitroGhostResetCount)
        sink.writeMap(bestNitroGhostTimePerTrackDef)
    }
}