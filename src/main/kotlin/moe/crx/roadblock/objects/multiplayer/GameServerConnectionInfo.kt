package moe.crx.roadblock.objects.multiplayer

import moe.crx.roadblock.io.EnumIO.readEnumString
import moe.crx.roadblock.io.EnumIO.writeEnumString
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class GameServerConnectionInfo : RObject {

    var scheme: GameServerScheme = GameServerScheme.SecureWebsocket
    var host: String = ""
    var port: Short = 0

    override fun read(sink: InputSink) {
        scheme = sink.readEnumString()
        host = sink.readString()
        port = sink.readShort()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnumString(scheme)
        sink.writeString(host)
        sink.writeShort(port)
    }
}