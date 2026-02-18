package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.rpc.base.RequestPacket

class GainAllCarItemsCheatRequest : RequestPacket() {

    var carId: CarId = 0
    var gainBlueprints: Boolean = false
    var gainUpgradeItems: Boolean = false

    override fun read(sink: InputSink) {
        super.read(sink)
        carId = sink.readInt()
        gainBlueprints = sink.readBoolean()
        gainUpgradeItems = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(carId)
        sink.writeBoolean(gainBlueprints)
        sink.writeBoolean(gainUpgradeItems)
    }
}