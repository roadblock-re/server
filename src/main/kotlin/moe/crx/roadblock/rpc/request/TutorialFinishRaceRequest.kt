package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.*
import moe.crx.roadblock.rpc.base.RequestPacket

class TutorialFinishRaceRequest : RequestPacket() {

    var eventId: TutorialEventId = TutorialEventId.SmartDrive
    var carId: CarId = 0
    var raceStats: RaceStats? = null
    var raceTimeMicroseconds: Int = 0
    var startReason: TutorialStartReason = TutorialStartReason.Automatic
    var controlType: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive
    var trackDefId: EventTrackDefId = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readEnum()
        carId = sink.readInt()
        raceStats = sink.readOptional()
        raceTimeMicroseconds = sink.readInt()
        startReason = sink.readEnum()
        controlType = sink.readEnum()
        if (sink newer "24.0.0") {
            trackDefId = sink.readInt()
        }
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeEnum(eventId)
        sink.writeInt(carId)
        sink.writeOptional(raceStats)
        sink.writeInt(raceTimeMicroseconds)
        sink.writeEnum(startReason)
        sink.writeEnum(controlType)
        if (sink newer "24.0.0") {
            sink.writeInt(trackDefId)
        }
    }
}