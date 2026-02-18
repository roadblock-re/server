package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.Blueprints
import moe.crx.roadblock.objects.game.CarClass
import moe.crx.roadblock.objects.game.CarUpgradeTier
import moe.crx.roadblock.rpc.base.RequestPacket

class GainWildcardBlueprintsCheatRequest : RequestPacket() {

    var carClass: CarClass = CarClass.A
    var tier: CarUpgradeTier = 0
    var amount: Blueprints = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        carClass = sink.readEnum()
        tier = sink.readByte()
        amount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeEnum(carClass)
        sink.writeByte(tier)
        sink.writeInt(amount)
    }
}