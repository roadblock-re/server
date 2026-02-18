package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.*
import moe.crx.roadblock.rpc.base.RequestPacket

class ClubRaceCreateRoomRequest : RequestPacket() {

    var eventId: ClubRaceEventId = 0
    var laps: Int = 0
    var carId: CarId = 0
    var snsCredential: Credentials? = null
    var controlSchemeType: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive
    var regionLatencyMap: RegionLatencyMap? = null
    var flowType: ClubRaceFlowType = ClubRaceFlowType.FlowFromEventSelectionScreen

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readInt()
        laps = sink.readInt()
        carId = sink.readInt()
        snsCredential = sink.readOptional()
        controlSchemeType = sink.readEnum()
        regionLatencyMap = sink.readOptional()
        flowType = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(eventId)
        sink.writeInt(laps)
        sink.writeInt(carId)
        sink.writeOptional(snsCredential)
        sink.writeEnum(controlSchemeType)
        sink.writeOptional(regionLatencyMap)
        sink.writeEnum(flowType)
    }
}