package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ControlSchemeType
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.objects.game.RegionLatencyMap
import moe.crx.roadblock.objects.mpchallenges.MultiplayerChallengesStartMatchmakingDebugOptions
import moe.crx.roadblock.rpc.base.RequestPacket

class MultiplayerChallengesStartMatchmakingRequest : RequestPacket() {

    var debugOptions: MultiplayerChallengesStartMatchmakingDebugOptions =
        MultiplayerChallengesStartMatchmakingDebugOptions()
    var eventId: CalendarEventId = ""
    var sponsorId: Int = 0
    var snsCredential: Credentials? = null
    var controlSchemeType: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive
    var regionLatencyMap: RegionLatencyMap? = null
    var connectivityType: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        debugOptions = sink.readObject()
        eventId = sink.readString()
        sponsorId = sink.readInt()
        snsCredential = sink.readOptional()
        controlSchemeType = sink.readEnum()
        regionLatencyMap = sink.readOptional()
        connectivityType = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(debugOptions)
        sink.writeString(eventId)
        sink.writeInt(sponsorId)
        sink.writeOptional(snsCredential)
        sink.writeEnum(controlSchemeType)
        sink.writeOptional(regionLatencyMap)
        sink.writeString(connectivityType)
    }
}