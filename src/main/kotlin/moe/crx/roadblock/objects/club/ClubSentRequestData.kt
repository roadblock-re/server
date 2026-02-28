package moe.crx.roadblock.objects.club

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ClubId
import moe.crx.roadblock.objects.ClubRequestId

@Serializable
data class ClubSentRequestData(
    var id: ClubRequestId,
    var clubId: ClubId,
    var clubName: String,
)