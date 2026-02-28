package moe.crx.roadblock.objects.sponsorship

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.SponsorshipContractId

@Serializable
data class SponsorshipContractState(
    var contractId: SponsorshipContractId,
    var loginCount: UInt,
    var startTimestamp: Instant,
    var nextDailyLoginTimestamp: Instant,
)