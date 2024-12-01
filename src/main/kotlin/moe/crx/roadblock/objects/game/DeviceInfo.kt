package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class DeviceInfo : RObject {

    var gdId: String = ""
    var model: String = ""
    var country: String = ""
    var language: String = ""
    var carrier: String = ""
    var firmware: String = ""
    var width: String = ""
    var height: String = ""

    override fun read(sink: InputSink) {
        gdId = sink.readString()
        model = sink.readString()
        country = sink.readString()
        language = sink.readString()
        carrier = sink.readString()
        firmware = sink.readString()
        width = sink.readString()
        height = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(gdId)
        sink.writeString(model)
        sink.writeString(country)
        sink.writeString(language)
        sink.writeString(carrier)
        sink.writeString(firmware)
        sink.writeString(width)
        sink.writeString(height)
    }
}