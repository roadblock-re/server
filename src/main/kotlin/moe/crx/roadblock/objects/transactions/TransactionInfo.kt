package moe.crx.roadblock.objects.transactions

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.AsphaltProductID

@Serializable
data class TransactionInfo(
    var productId: AsphaltProductID,
    var transactionId: ULong,
    @FromVersion("45.0.0")
    var gamePassPerk: UByte? = null,
)