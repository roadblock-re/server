package moe.crx.roadblock.objects.settings

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class KeyboardControlSettings : RObject {

    var isAutoselectEnabled: Boolean = false
    var manualSensitivity: Float = 0f
    var isKeyboardAzerty: Int = 0

    override fun read(sink: InputSink) {
        isAutoselectEnabled = sink.readBoolean()
        manualSensitivity = sink.readFloat()
        isKeyboardAzerty = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(isAutoselectEnabled)
        sink.writeFloat(manualSensitivity)
        sink.writeInt(isKeyboardAzerty)
    }
}