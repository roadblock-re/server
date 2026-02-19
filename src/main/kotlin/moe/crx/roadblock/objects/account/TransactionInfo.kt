package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion

@Serializable
data class TransactionInfo(
    var productId: AsphaltProductID,
    var transactionId: ULong,
    @FromVersion("45.0.0")
    var gamePassPerk: UByte? = null,
)