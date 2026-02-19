package moe.crx.roadblock.objects.club

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.ClubId
import moe.crx.roadblock.objects.account.ClubRequestId

@Serializable
data class ClubSentRequestData(
    var id: ClubRequestId,
    var clubId: ClubId,
    var clubName: String,
)