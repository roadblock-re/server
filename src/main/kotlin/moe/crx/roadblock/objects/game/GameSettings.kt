package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.settings.ControlSettings
import moe.crx.roadblock.objects.settings.Localization

class GameSettings : RObject {

    // ALU uses int instead of string?
    var cameraType: String = ""
    var speedUnit: Int = 0
    var enableKnockdowns: Byte = 0
    var language: Localization = Localization()
    var region: Int = 0
    var controls: ControlSettings = ControlSettings()

    override fun read(sink: InputSink) {
        cameraType = sink.readString()
        speedUnit = sink.readInt()
        enableKnockdowns = sink.readByte()
        language = sink.readObject()
        region = sink.readInt()
        controls = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(cameraType)
        sink.writeInt(speedUnit)
        sink.writeByte(enableKnockdowns)
        sink.writeObject(language)
        sink.writeInt(region)
        sink.writeObject(controls)
    }
}