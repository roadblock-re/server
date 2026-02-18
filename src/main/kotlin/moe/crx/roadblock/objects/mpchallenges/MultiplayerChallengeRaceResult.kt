package moe.crx.roadblock.objects.mpchallenges

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.ControlSchemeType
import moe.crx.roadblock.objects.game.RaceStats
import moe.crx.roadblock.objects.game.RaceToken

class MultiplayerChallengeRaceResult : RObject {

    var eventId: Int = 0
    var raceConfigId: Int = 0
    var raceToken: RaceToken = 0
    var raceStats: RaceStats = RaceStats()
    var finishReason: Int = 0
    var gameplayServerCreationTime: Instant = now()
    var raceFinishServerTime: Instant = now()
    var controlSchemeType: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive
    var forceDefeatCheat: Boolean = false
    var carId: CarId = 0

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        raceConfigId = sink.readInt()
        raceToken = sink.readInt()
        raceStats = sink.readObject()
        finishReason = sink.readInt()
        gameplayServerCreationTime = sink.readInstant()
        raceFinishServerTime = sink.readInstant()
        controlSchemeType = sink.readEnum()
        forceDefeatCheat = sink.readBoolean()
        carId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeInt(raceConfigId)
        sink.writeInt(raceToken)
        sink.writeObject(raceStats)
        sink.writeInt(finishReason)
        sink.writeInstant(gameplayServerCreationTime)
        sink.writeInstant(raceFinishServerTime)
        sink.writeEnum(controlSchemeType)
        sink.writeBoolean(forceDefeatCheat)
        sink.writeInt(carId)
    }
}