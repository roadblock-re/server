package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket

class GetCredentialsForConsoleUsersRequest : RequestPacket() {

    var allConsoleFriends: List<Credentials> = listOf()
    var unknownCredentials: List<Credentials> = listOf()

    override fun read(sink: InputSink) {
        super.read(sink)
        allConsoleFriends = sink.readList()
        unknownCredentials = sink.readList()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeList(allConsoleFriends)
        sink.writeList(unknownCredentials)
    }
}