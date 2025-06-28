package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.settings.ControlSettings
import moe.crx.roadblock.objects.settings.Localization

class GameSettings : RObject {

    var cameraType: String = ""
    var isImperialSpeedUnit: Int = 0
    var enableKnockdowns: Boolean = false
    var language: Localization = Localization()
    var region: Int = 0
    var controls: ControlSettings = ControlSettings()
    var promoScreensEnabled: Boolean = false

    override fun read(sink: InputSink) {
        cameraType = sink.readString()
        isImperialSpeedUnit = sink.readInt()
        enableKnockdowns = sink.readBoolean()
        language = sink.readObject()
        region = sink.readInt()
        controls = sink.readObject()
        if (sink newer "24.0.0") {
            promoScreensEnabled = sink.readBoolean()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeString(cameraType)
        sink.writeInt(isImperialSpeedUnit)
        sink.writeBoolean(enableKnockdowns)
        sink.writeObject(language)
        sink.writeInt(region)
        sink.writeObject(controls)
        if (sink newer "24.0.0") {
            sink.writeBoolean(promoScreensEnabled)
        }
    }
}