package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
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