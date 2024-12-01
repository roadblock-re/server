package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CarStatType
import moe.crx.roadblock.objects.game.CarUpgradeLevel
import moe.crx.roadblock.objects.game.FreeUpgradeVariant
import moe.crx.roadblock.rpc.base.RequestPacket

class FreeUpgradeCarStatLevelRequest : RequestPacket() {

    var carId: CarId = 0
    var carStat: CarStatType = CarStatType.TopSpeed
    var upgradeLevel: CarUpgradeLevel = 0
    var freeUpgrade: FreeUpgradeVariant = FreeUpgradeVariant()

    override fun read(sink: InputSink) {
        super.read(sink)
        carId = sink.readInt()
        carStat = sink.readEnum()
        upgradeLevel = sink.readByte()
        freeUpgrade = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(carId)
        sink.writeEnum(carStat)
        sink.writeByte(upgradeLevel)
        sink.writeObject(freeUpgrade)
    }
}