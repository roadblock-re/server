package moe.crx.roadblock.objects.settings

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class TouchControlSettings : RObject {

    var touchDriveSensitivity: Float = 0f
    var tappingSensitivity: Float = 0f
    var iconsScale: Float = 0f
    var leftNitroOffset: Vector2f = Vector2f(0f, 0f)
    var leftDriftOffset: Vector2f = Vector2f(0f, 0f)
    var rightNitroOffset: Vector2f = Vector2f(0f, 0f)
    var rightDriftOffset: Vector2f = Vector2f(0f, 0f)
    var tiltingSensitivity: Float = 0f
    var isHorizonTiltEnabled: Boolean = false
    var isTiltSteeringEnabled: Int = 0
    var isAutoselectEnabled: Boolean = false

    override fun read(sink: InputSink) {
        touchDriveSensitivity = sink.readFloat()
        tappingSensitivity = sink.readFloat()
        iconsScale = sink.readFloat()
        leftNitroOffset = sink.readObject()
        leftDriftOffset = sink.readObject()
        rightNitroOffset = sink.readObject()
        rightDriftOffset = sink.readObject()
        tiltingSensitivity = sink.readFloat()
        isHorizonTiltEnabled = sink.readBoolean()
        isTiltSteeringEnabled = sink.readInt()
        if (sink newer "24.0.0") {
            isAutoselectEnabled = sink.readBoolean()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeFloat(touchDriveSensitivity)
        sink.writeFloat(tappingSensitivity)
        sink.writeFloat(iconsScale)
        sink.writeObject(leftNitroOffset)
        sink.writeObject(leftDriftOffset)
        sink.writeObject(rightNitroOffset)
        sink.writeObject(rightDriftOffset)
        sink.writeFloat(tiltingSensitivity)
        sink.writeBoolean(isHorizonTiltEnabled)
        sink.writeInt(isTiltSteeringEnabled)
        if (sink newer "24.0.0") {
            sink.writeBoolean(isAutoselectEnabled)
        }
    }
}