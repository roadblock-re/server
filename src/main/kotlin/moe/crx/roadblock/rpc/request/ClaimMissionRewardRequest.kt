package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.MissionType
import moe.crx.roadblock.rpc.base.RequestPacket

class ClaimMissionRewardRequest : RequestPacket() {

    var missionType: MissionType = MissionType.Stunts

    override fun read(sink: InputSink) {
        super.read(sink)
        missionType = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeEnum(missionType)
    }
}