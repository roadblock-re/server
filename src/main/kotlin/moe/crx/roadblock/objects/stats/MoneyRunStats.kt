package moe.crx.roadblock.objects.stats

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MoneyRunStats : RObject {

    var isDisqualified: Byte = 0
    var achievedMoney: Int = 0
    var hasEnoughMoney: Byte = 0

    override fun read(sink: InputSink) {
        isDisqualified = sink.readByte()
        achievedMoney = sink.readInt()
        hasEnoughMoney = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(isDisqualified)
        sink.writeInt(achievedMoney)
        sink.writeByte(hasEnoughMoney)
    }
}