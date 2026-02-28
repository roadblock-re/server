package moe.crx.roadblock.objects.clubrace

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ClubRaceEventId
import moe.crx.roadblock.objects.club.ClubMemberRank

@Serializable
data class ClubRaceClientRoomData(
    var eventId: ClubRaceEventId,
    var laps: UInt,
    var creatorName: String,
    var creatorFederationId: String,
    var creatorRank: ClubMemberRank,
    var creationTimestamp: Instant,
)