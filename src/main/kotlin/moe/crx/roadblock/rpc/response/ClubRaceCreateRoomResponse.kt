package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.objects.game.RegionPreferences
import moe.crx.roadblock.objects.game.RequiredPlaybackCondition
import moe.crx.roadblock.objects.game.RequiredPlaybackDetailLevel
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class ClubRaceCreateRoomResponse : UpdatesQueueWithRootReactionsResponse() {

    var requiredPlaybackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer
    var requiredPlaybackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never
    var raceToken: RaceToken = 0
    var encryptedServerUserData: String = ""
    var encryptedServerRoomData: String = ""
    var clientUserData: String = ""
    var clientRoomData: String = ""
    var filter: String = ""
    var regionPreferences: RegionPreferences? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        requiredPlaybackDetailLevel = sink.readEnum()
        requiredPlaybackCondition = sink.readEnum()
        raceToken = sink.readInt()
        encryptedServerUserData = sink.readString()
        encryptedServerRoomData = sink.readString()
        clientUserData = sink.readString()
        clientRoomData = sink.readString()
        filter = sink.readString()
        regionPreferences = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeEnum(requiredPlaybackDetailLevel)
        sink.writeEnum(requiredPlaybackCondition)
        sink.writeInt(raceToken)
        sink.writeString(encryptedServerUserData)
        sink.writeString(encryptedServerRoomData)
        sink.writeString(clientUserData)
        sink.writeString(clientRoomData)
        sink.writeString(filter)
        sink.writeOptional(regionPreferences)
    }
}