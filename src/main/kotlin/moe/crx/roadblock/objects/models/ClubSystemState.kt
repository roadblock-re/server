package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.club.*

class ClubSystemState : RObject {

    var clubSeason: ClubSeason = ClubSeason()
    var clubData: CurrentClubData? = null
    var sentRequest: ClubSentRequestData? = null
    var isLocked: Boolean = false
    var firstClub: FirstClubData = FirstClubData()
    var donationData: ClubDonationData = ClubDonationData()
    var leaveClubReason: RInt? = null
    var cancelJoinRequest: ClubCancelJoinRequestData? = null
    var clubWars: Map<RString, ClubWarsEventClubState> = mapOf()

    override fun read(sink: InputSink) {
        clubSeason = sink.readObject()
        clubData = sink.readOptional()
        sentRequest = sink.readOptional()
        isLocked = sink.readBoolean()
        firstClub = sink.readObject()
        if (sink newer "24.0.0") {
            donationData = sink.readObject()
        }
        leaveClubReason = sink.readOptional()
        cancelJoinRequest = sink.readOptional()
        if (sink older "45.0.0") {
            clubWars = sink.readMap()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(clubSeason)
        sink.writeOptional(clubData)
        sink.writeOptional(sentRequest)
        sink.writeBoolean(isLocked)
        sink.writeObject(firstClub)
        if (sink newer "24.0.0") {
            sink.writeObject(donationData)
        }
        sink.writeOptional(leaveClubReason)
        sink.writeOptional(cancelJoinRequest)
        if (sink older "45.0.0") {
            sink.writeMap(clubWars)
        }
    }
}