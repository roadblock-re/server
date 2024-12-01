package moe.crx.roadblock.objects.settings

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RVector2F

class TouchControlSettings : RObject {

    var touchDriveSensitivity: Float = 0f
    var tappingSensitivity: Float = 0f
    var tappingIconSize: Float = 0f
    var tappingIconOffset1: RVector2F = RVector2F()
    var tappingIconOffset2: RVector2F = RVector2F()
    var tappingIconOffset3: RVector2F = RVector2F()
    var tappingIconOffset4: RVector2F = RVector2F()
    var tiltingSensitivity: Float = 0f
    var isHorizonTiltEnabled: Byte = 0
    var isTiltSteeringEnabled: Int = 0

    override fun read(sink: InputSink) {
        touchDriveSensitivity = sink.readFloat()
        tappingSensitivity = sink.readFloat()
        tappingIconSize = sink.readFloat()
        tappingIconOffset1 = sink.readObject()
        tappingIconOffset2 = sink.readObject()
        tappingIconOffset3 = sink.readObject()
        tappingIconOffset4 = sink.readObject()
        tiltingSensitivity = sink.readFloat()
        isHorizonTiltEnabled = sink.readByte()
        isTiltSteeringEnabled = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeFloat(touchDriveSensitivity)
        sink.writeFloat(tappingSensitivity)
        sink.writeFloat(tappingIconSize)
        sink.writeObject(tappingIconOffset1)
        sink.writeObject(tappingIconOffset2)
        sink.writeObject(tappingIconOffset3)
        sink.writeObject(tappingIconOffset4)
        sink.writeFloat(tiltingSensitivity)
        sink.writeByte(isHorizonTiltEnabled)
        sink.writeInt(isTiltSteeringEnabled)
    }
}