package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubRaceRoom : RObject {

    var clientData: ClubRaceClientRoomData = ClubRaceClientRoomData()
    var encryptedServerData: String = ""

    override fun read(sink: InputSink) {
        clientData = sink.readObject()
        encryptedServerData = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(clientData)
        sink.writeString(encryptedServerData)
    }
}