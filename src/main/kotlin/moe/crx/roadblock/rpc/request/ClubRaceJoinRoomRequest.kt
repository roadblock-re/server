package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.*
import moe.crx.roadblock.rpc.base.RequestPacket

class ClubRaceJoinRoomRequest : RequestPacket() {

    var encryptedServerRoomData: String = ""
    var carId: CarId = 0
    var snsCredential: Credentials? = null
    var controlSchemeType: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive
    var regionLatencyMap: RegionLatencyMap? = null
    var flowType: ClubRaceFlowType = ClubRaceFlowType.FlowFromEventSelectionScreen

    override fun read(sink: InputSink) {
        super.read(sink)
        encryptedServerRoomData = sink.readString()
        carId = sink.readInt()
        snsCredential = sink.readOptional()
        controlSchemeType = sink.readEnum()
        regionLatencyMap = sink.readOptional()
        flowType = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(encryptedServerRoomData)
        sink.writeInt(carId)
        sink.writeOptional(snsCredential)
        sink.writeEnum(controlSchemeType)
        sink.writeOptional(regionLatencyMap)
        sink.writeEnum(flowType)
    }
}