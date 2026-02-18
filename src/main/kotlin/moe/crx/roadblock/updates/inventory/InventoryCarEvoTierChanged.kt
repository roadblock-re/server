package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId

class InventoryCarEvoTierChanged : RObject {

    var carId: CarId = 0
    var oldTier: RByte? = null // CarUpgradeTier
    var newTier: RByte? = null // CarUpgradeTier

    override fun read(sink: InputSink) {
        carId = sink.readInt()
        oldTier = sink.readOptional()
        newTier = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(carId)
        sink.writeOptional(oldTier)
        sink.writeOptional(newTier)
    }
}