package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.SponsorshipContractId
import moe.crx.roadblock.objects.sponsorship.SponsorshipContractState

@Serializable
data class SponsorshipSystemState(
    var activeContract: SponsorshipContractState? = null,
    var completedContractIds: Map<SponsorshipContractId, UInt> = mapOf(),
)