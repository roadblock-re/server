package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.item.TrashableItem
import moe.crx.roadblock.rpc.base.RequestPacket

class TrashItemRequest : RequestPacket() {

    var item: TrashableItem = TrashableItem()
    var amount: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        item = sink.readObject()
        amount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(item)
        sink.writeInt(amount)
    }
}