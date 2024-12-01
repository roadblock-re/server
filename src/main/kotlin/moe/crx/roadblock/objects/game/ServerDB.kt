package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ServerDB : RObject {

    var probablyGameVersionStatusErrorCode: Int = 0 // TODO Could it be String?
    var config: ConfigData = ConfigData()
    var probablyGameDbObsolete: Byte = 0 // TODO

    override fun read(sink: InputSink) {
        probablyGameVersionStatusErrorCode = sink.readInt()
        config = sink.readObject()
        probablyGameDbObsolete = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(probablyGameVersionStatusErrorCode)
        sink.writeObject(config)
        sink.writeByte(probablyGameDbObsolete)
    }
}