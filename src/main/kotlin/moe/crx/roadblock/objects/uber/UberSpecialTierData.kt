package moe.crx.roadblock.objects.uber

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.Money
import moe.crx.roadblock.objects.account.UberExperience

@Serializable
data class UberSpecialTierData(
    var xpGainedInTier: UberExperience,
    var uberTokensGainedInPinnedMissions: Money,
)