package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CheatToPerform
import moe.crx.roadblock.rpc.base.RequestPacket

class PerformCheatRequest : RequestPacket() {

    var cheatToPerform: CheatToPerform = CheatToPerform()

    override fun read(sink: InputSink) {
        super.read(sink)
        cheatToPerform = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(cheatToPerform)
    }
}