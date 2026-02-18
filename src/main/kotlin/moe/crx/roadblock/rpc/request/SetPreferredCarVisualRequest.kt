package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CarVisualConfiguration
import moe.crx.roadblock.rpc.base.RequestPacket

class SetPreferredCarVisualRequest : RequestPacket() {

    var carId: CarId = 0
    var visualConfiguration: CarVisualConfiguration = CarVisualConfiguration()

    override fun read(sink: InputSink) {
        super.read(sink)
        carId = sink.readInt()
        visualConfiguration = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(carId)
        sink.writeObject(visualConfiguration)
    }
}