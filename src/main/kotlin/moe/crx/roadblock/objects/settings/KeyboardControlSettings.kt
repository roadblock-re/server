package moe.crx.roadblock.objects.settings

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class KeyboardControlSettings : RObject {

    var isAutoselectEnabled: Byte = 0
    var manualSensitivity: Float = 0f
    var isKeyboardAzerty: Int = 0

    override fun read(sink: InputSink) {
        isAutoselectEnabled = sink.readByte()
        manualSensitivity = sink.readFloat()
        isKeyboardAzerty = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(isAutoselectEnabled)
        sink.writeFloat(manualSensitivity)
        sink.writeInt(isKeyboardAzerty)
    }
}