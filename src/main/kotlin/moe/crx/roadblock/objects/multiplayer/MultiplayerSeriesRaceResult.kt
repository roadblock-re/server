package moe.crx.roadblock.objects.multiplayer

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RFloat
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.*

class MultiplayerSeriesRaceResult : RObject {

    var seriesId: MultiplayerSeriesId = 0
    var eventId: CalendarEventId = ""
    var raceConfigId: MultiplayerRaceConfigId = 0
    var raceToken: RaceToken = 0
    var carId: CarId = 0
    var eventCar: EventCarInfo? = null
    var raceStats: RaceStats = RaceStats()
    var finishReason: MultiplayerSeriesFinishRaceReason = MultiplayerSeriesFinishRaceReason.Completed
    var eloByFinishPosition: List<RFloat> = listOf() // PlayerElo
    var gameplayServerCreationTime: Instant = now()
    var raceFinishServerTime: Instant = now()
    var disconnectionPenaltyStrength: Float = 0.0f
    var controlSchemeType: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive

    override fun read(sink: InputSink) {
        seriesId = sink.readInt()
        eventId = sink.readString()
        raceConfigId = sink.readInt()
        raceToken = sink.readInt()
        carId = sink.readInt()
        eventCar = sink.readOptional()
        raceStats = sink.readObject()
        finishReason = sink.readEnum()
        eloByFinishPosition = sink.readList()
        gameplayServerCreationTime = sink.readInstant()
        raceFinishServerTime = sink.readInstant()
        disconnectionPenaltyStrength = sink.readFloat()
        controlSchemeType = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(seriesId)
        sink.writeString(eventId)
        sink.writeInt(raceConfigId)
        sink.writeInt(raceToken)
        sink.writeInt(carId)
        sink.writeOptional(eventCar)
        sink.writeObject(raceStats)
        sink.writeEnum(finishReason)
        sink.writeList(eloByFinishPosition)
        sink.writeInstant(gameplayServerCreationTime)
        sink.writeInstant(raceFinishServerTime)
        sink.writeFloat(disconnectionPenaltyStrength)
        sink.writeEnum(controlSchemeType)
    }
}