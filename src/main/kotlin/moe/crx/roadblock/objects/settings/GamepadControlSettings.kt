package moe.crx.roadblock.objects.settings

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class GamepadControlSettings : RObject {

    var gamepadId: Long = 0
    var isAutoselectEnabled: Byte = 0
    var tiltingSensitivity: Float = 0f
    var selectedLayout: Int = 0
    var touchDriveSensitivity: Float = 0f
    var manualSensitivity: Float = 0f

    override fun read(sink: InputSink) {
        gamepadId = sink.readLong()
        isAutoselectEnabled = sink.readByte()
        tiltingSensitivity = sink.readFloat()
        selectedLayout = sink.readInt()
        touchDriveSensitivity = sink.readFloat()
        manualSensitivity = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        sink.writeLong(gamepadId)
        sink.writeByte(isAutoselectEnabled)
        sink.writeFloat(tiltingSensitivity)
        sink.writeInt(selectedLayout)
        sink.writeFloat(touchDriveSensitivity)
        sink.writeFloat(manualSensitivity)
    }
}