package moe.crx.roadblock.updates.miscellaneous

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.GameSettings

class MiscellaneousGameSettingsChanged : RObject {

    var oldSettings: GameSettings = GameSettings()
    var newSettings: GameSettings = GameSettings()

    override fun read(sink: InputSink) {
        oldSettings = sink.readObject()
        newSettings = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(oldSettings)
        sink.writeObject(newSettings)
    }
}