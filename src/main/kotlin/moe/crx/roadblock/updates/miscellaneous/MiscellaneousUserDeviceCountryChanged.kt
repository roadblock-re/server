package moe.crx.roadblock.updates.miscellaneous

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MiscellaneousUserDeviceCountryChanged : RObject {

    var oldCountryStr: String = ""
    var newCountryStr: String = ""

    override fun read(sink: InputSink) {
        oldCountryStr = sink.readString()
        newCountryStr = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(oldCountryStr)
        sink.writeString(newCountryStr)
    }
}