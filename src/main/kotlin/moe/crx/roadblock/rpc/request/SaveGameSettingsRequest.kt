package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.GameSettings
import moe.crx.roadblock.rpc.base.RequestPacket

class SaveGameSettingsRequest : RequestPacket() {

    var settings: GameSettings = GameSettings()

    override fun read(sink: InputSink) {
        super.read(sink)
        settings = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(settings)
    }
}