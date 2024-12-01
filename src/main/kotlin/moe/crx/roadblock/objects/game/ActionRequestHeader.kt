package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ActionRequestHeader : RObject {

    var actionId: Int = 0
    var clientId: String = ""
    //var clientTime: Instant = now() // ALU has it

    override fun read(sink: InputSink) {
        actionId = sink.readInt()
        clientId = sink.readString()
        //clientTime = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(actionId)
        sink.writeString(clientId)
        //sink.writeInstant(clientTime)
    }
}