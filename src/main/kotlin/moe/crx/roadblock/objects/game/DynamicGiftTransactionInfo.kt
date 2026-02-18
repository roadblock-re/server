package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class DynamicGiftTransactionInfo : RObject {

    var templateId: String = ""
    var sourceCredential: String = ""

    override fun read(sink: InputSink) {
        templateId = sink.readString()
        sourceCredential = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(templateId)
        sink.writeString(sourceCredential)
    }
}