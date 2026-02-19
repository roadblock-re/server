package moe.crx.roadblock.objects.piggybank

import kotlinx.serialization.Serializable

@Serializable
data class PiggyBankTierState(
    var attempts: UInt,
)