package moe.crx.roadblock.objects.settings

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ControlSettings : RObject {

    var isTouchDriveDisabled: Int = 0
    var touchControl: TouchControlSettings = TouchControlSettings()
    var gamepadControls: List<GamepadControlSettings> = listOf()
    var keyboardControl: KeyboardControlSettings = KeyboardControlSettings()
    var isAutoAccelerationEnabled: Boolean = false
    var isManualAccelerationTutorialNeeded: Boolean = false
    var isRumbleEnabled: Boolean = false

    override fun read(sink: InputSink) {
        isTouchDriveDisabled = sink.readInt()
        touchControl = sink.readObject()
        gamepadControls = sink.readList()
        keyboardControl = sink.readObject()
        isAutoAccelerationEnabled = sink.readBoolean()
        isManualAccelerationTutorialNeeded = sink.readBoolean()
        if (sink newer "24.0.0") {
            isRumbleEnabled = sink.readBoolean()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(isTouchDriveDisabled)
        sink.writeObject(touchControl)
        sink.writeList(gamepadControls)
        sink.writeObject(keyboardControl)
        sink.writeBoolean(isAutoAccelerationEnabled)
        sink.writeBoolean(isManualAccelerationTutorialNeeded)
        if (sink newer "24.0.0") {
            sink.writeBoolean(isRumbleEnabled)
        }
    }
}