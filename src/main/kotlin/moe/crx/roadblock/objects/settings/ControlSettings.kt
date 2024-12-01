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
    var isRumbleEnabled: Byte = 0
    var gamepadControls: List<GamepadControlSettings> = listOf()
    var keyboardControl: KeyboardControlSettings = KeyboardControlSettings()
    var isAutoAccelerationEnabled: Byte = 0
    var isManualAccelerationTutorialNeeded: Byte = 0

    override fun read(sink: InputSink) {
        isTouchDriveDisabled = sink.readInt()
        touchControl = sink.readObject()
        isRumbleEnabled = sink.readByte()
        gamepadControls = sink.readList()
        keyboardControl = sink.readObject()
        isAutoAccelerationEnabled = sink.readByte()
        isManualAccelerationTutorialNeeded = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(isTouchDriveDisabled)
        sink.writeObject(touchControl)
        sink.writeByte(isRumbleEnabled)
        sink.writeList(gamepadControls)
        sink.writeObject(keyboardControl)
        sink.writeByte(isAutoAccelerationEnabled)
        sink.writeByte(isManualAccelerationTutorialNeeded)
    }
}