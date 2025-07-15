package moe.crx.roadblock.objects.settings

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class GamepadControlSettings : RObject {

    var gamepadId: Long = 0
    var isAutoselectEnabled: Boolean = false
    var tiltingSensitivity: Float = 0f
    var isHorizonTiltEnabled: Boolean = false
    var selectedLayout: Int = 0
    var touchDriveSensitivity: Float = 0f
    var manualSensitivity: Float = 0f

    override fun read(sink: InputSink) {
        gamepadId = sink.readLong()
        isAutoselectEnabled = sink.readBoolean()
        tiltingSensitivity = sink.readFloat()
        if (sink newer "24.6.0") {
            isHorizonTiltEnabled = sink.readBoolean()
        }
        selectedLayout = sink.readInt()
        touchDriveSensitivity = sink.readFloat()
        manualSensitivity = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        sink.writeLong(gamepadId)
        sink.writeBoolean(isAutoselectEnabled)
        sink.writeFloat(tiltingSensitivity)
        if (sink newer "24.6.0") {
            sink.writeBoolean(isHorizonTiltEnabled)
        }
        sink.writeInt(selectedLayout)
        sink.writeFloat(touchDriveSensitivity)
        sink.writeFloat(manualSensitivity)
    }
}