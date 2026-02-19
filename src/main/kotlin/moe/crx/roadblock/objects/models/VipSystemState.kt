package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.VipExperience

@Serializable
data class VipSystemState(
    var vipExperience: VipExperience = 0u,
    var vipBlackMarketState: VipBlackMarketState = VipBlackMarketState(),
    var purchasedVIPBundleAtVIPLevel: List<UByte> = listOf(),
    var nextDailyGiftRestore: Instant = now(),
)