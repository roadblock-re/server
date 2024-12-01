package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CarUpgradeTier
import moe.crx.roadblock.rpc.base.RequestPacket

class UnlockUpgradeTierRequest : RequestPacket() {

    var carId: CarId = 0
    var tier: CarUpgradeTier = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        carId = sink.readInt()
        tier = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(carId)
        sink.writeByte(tier)
    }
}