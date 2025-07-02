package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class UserInstallations : RObject {

    var installations: List<DeviceInfo> = listOf()

    override fun read(sink: InputSink) {
        installations = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(installations)
    }
}
