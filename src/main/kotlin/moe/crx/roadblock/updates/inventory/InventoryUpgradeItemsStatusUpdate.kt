package moe.crx.roadblock.updates.inventory

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.UpgradeItems
import moe.crx.roadblock.objects.item.UpgradeItem

class InventoryUpgradeItemsStatusUpdate : RObject {

    var item: UpgradeItem = UpgradeItem()
    var oldAmount: UpgradeItems = 0
    var newAmount: UpgradeItems = 0

    override fun read(sink: InputSink) {
        item = sink.readObject()
        oldAmount = sink.readInt()
        newAmount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(item)
        sink.writeInt(oldAmount)
        sink.writeInt(newAmount)
    }
}