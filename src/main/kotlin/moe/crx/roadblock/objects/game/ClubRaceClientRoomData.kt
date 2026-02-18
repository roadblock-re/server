package moe.crx.roadblock.objects.game

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubRaceClientRoomData : RObject {

    var eventId: ClubRaceEventId = 0
    var laps: Int = 0
    var creatorName: String = ""
    var creatorFederationId: String = ""
    var creatorRank: ClubMemberRank = ClubMemberRank.Manager
    var creationTimestamp: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readInt()
        laps = sink.readInt()
        creatorName = sink.readString()
        creatorFederationId = sink.readString()
        creatorRank = sink.readEnum()
        creationTimestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(eventId)
        sink.writeInt(laps)
        sink.writeString(creatorName)
        sink.writeString(creatorFederationId)
        sink.writeEnum(creatorRank)
        sink.writeInstant(creationTimestamp)
    }
}