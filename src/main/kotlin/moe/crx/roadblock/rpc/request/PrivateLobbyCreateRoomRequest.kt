package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.objects.game.RegionLatencyMap
import moe.crx.roadblock.objects.privatelobby.PrivateLobbyRacerData
import moe.crx.roadblock.rpc.base.RequestPacket

class PrivateLobbyCreateRoomRequest : RequestPacket() {

    var eventId: Int = 0
    var trackId: Int = 0
    var laps: Int = 0
    var racerData: PrivateLobbyRacerData? = null
    var snsCredential: Credentials? = null
    var regionLatencyMap: RegionLatencyMap? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readInt()
        trackId = sink.readInt()
        laps = sink.readInt()
        racerData = sink.readOptional()
        snsCredential = sink.readOptional()
        regionLatencyMap = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(eventId)
        sink.writeInt(trackId)
        sink.writeInt(laps)
        sink.writeOptional(racerData)
        sink.writeOptional(snsCredential)
        sink.writeOptional(regionLatencyMap)
    }
}