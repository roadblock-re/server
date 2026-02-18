package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.objects.game.RegionLatencyMap
import moe.crx.roadblock.objects.privatelobby.PrivateLobbyRacerData
import moe.crx.roadblock.rpc.base.RequestPacket

class PrivateLobbyJoinRoomRequest : RequestPacket() {

    var encryptedServerRoomData: String = ""
    var racerData: PrivateLobbyRacerData? = null
    var snsCredential: Credentials? = null
    var regionLatencyMap: RegionLatencyMap? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        encryptedServerRoomData = sink.readString()
        racerData = sink.readOptional()
        snsCredential = sink.readOptional()
        regionLatencyMap = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(encryptedServerRoomData)
        sink.writeOptional(racerData)
        sink.writeOptional(snsCredential)
        sink.writeOptional(regionLatencyMap)
    }
}