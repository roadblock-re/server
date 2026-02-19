package moe.crx.roadblock.objects.club

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.ClubDonationItemId

@Serializable
data class ClubDonationData(
    var requestedItem: ClubDonationItemId = 0u,
    var lastRequestTimestamp: Instant = now(),
    var templateId: String? = null,
)