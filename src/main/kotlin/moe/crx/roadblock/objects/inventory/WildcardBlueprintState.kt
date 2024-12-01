package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class WildcardBlueprintState : RObject {

    var upgradeTier: Byte = 0
    var amount: Int = 0

    override fun read(sink: InputSink) {
        upgradeTier = sink.readByte()
        amount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(upgradeTier)
        sink.writeInt(amount)
    }
}