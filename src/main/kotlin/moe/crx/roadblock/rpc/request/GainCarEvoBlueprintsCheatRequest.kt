package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.rpc.base.RequestPacket

class GainCarEvoBlueprintsCheatRequest : RequestPacket() {

    var carId: CarId = 0
    var carEvoTier: Byte = 0
    var amount: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        carId = sink.readInt()
        carEvoTier = sink.readByte()
        amount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(carId)
        sink.writeByte(carEvoTier)
        sink.writeInt(amount)
    }
}