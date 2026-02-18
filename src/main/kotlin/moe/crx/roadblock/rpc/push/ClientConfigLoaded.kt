package moe.crx.roadblock.rpc.push

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.ConfigData
import moe.crx.roadblock.objects.game.ServerDBSerialization

class ClientConfigLoaded : PushMessagePacket() {

    var configData: ConfigData = ConfigData()
    var serverDBs: ServerDBSerialization = ServerDBSerialization()
    var isGameDbObsolete: Boolean = false

    override fun read(sink: InputSink) {
        super.read(sink)
        configData = sink.readObject()
        serverDBs = sink.readObject()
        isGameDbObsolete = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(configData)
        sink.writeObject(serverDBs)
        sink.writeBoolean(isGameDbObsolete)
    }
}