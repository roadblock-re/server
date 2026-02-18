package moe.crx.roadblock.objects.clubwars

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RShort

class ClubWarsRoundData : RObject {

    var refreshTimestamp: Instant = now()
    var registrationData: ClubWarsRegistrationData? = null
    var defenseNodeRegions: Map<RShort, ClubWarsBoardDefenseRegion> = mapOf()
    var attackNodeRegions: Map<RShort, ClubWarsBoardAttackRegion> = mapOf()
    var forceRefreshRegistration: Boolean = false
    var forceProcessMatchmaking: Boolean = false

    override fun read(sink: InputSink) {
        refreshTimestamp = sink.readInstant()
        registrationData = sink.readOptional()
        defenseNodeRegions = sink.readMap()
        attackNodeRegions = sink.readMap()
        forceRefreshRegistration = sink.readBoolean()
        forceProcessMatchmaking = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(refreshTimestamp)
        sink.writeOptional(registrationData)
        sink.writeMap(defenseNodeRegions)
        sink.writeMap(attackNodeRegions)
        sink.writeBoolean(forceRefreshRegistration)
        sink.writeBoolean(forceProcessMatchmaking)
    }
}