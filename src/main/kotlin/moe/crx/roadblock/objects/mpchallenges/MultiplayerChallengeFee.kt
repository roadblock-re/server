package moe.crx.roadblock.objects.mpchallenges

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.objects.Money

@Serializable
data class MultiplayerChallengeFee(
    var currency: CurrencyType,
    var value: Money,
)