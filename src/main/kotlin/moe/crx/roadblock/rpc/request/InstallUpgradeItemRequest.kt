package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CarStatType
import moe.crx.roadblock.objects.game.CarUpgradeItemSlotId
import moe.crx.roadblock.objects.game.CarUpgradeLevel
import moe.crx.roadblock.rpc.base.RequestPacket

class InstallUpgradeItemRequest : RequestPacket() {

    var carId: CarId = 0
    var statType: CarStatType = CarStatType.TopSpeed
    var upgradeLevel: CarUpgradeLevel = 0
    var upgradeSlot: CarUpgradeItemSlotId = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        carId = sink.readInt()
        statType = sink.readEnum()
        upgradeLevel = sink.readByte()
        upgradeSlot = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(carId)
        sink.writeEnum(statType)
        sink.writeByte(upgradeLevel)
        sink.writeInt(upgradeSlot)
    }
}