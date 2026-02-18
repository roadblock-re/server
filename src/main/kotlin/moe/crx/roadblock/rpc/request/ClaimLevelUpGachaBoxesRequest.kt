package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.GarageLevel
import moe.crx.roadblock.rpc.base.RequestPacket

class ClaimLevelUpGachaBoxesRequest : RequestPacket() {

    var garageLevel: GarageLevel = 0
    var boxesCount: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        garageLevel = sink.readShort()
        boxesCount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeShort(garageLevel)
        sink.writeInt(boxesCount)
    }
}