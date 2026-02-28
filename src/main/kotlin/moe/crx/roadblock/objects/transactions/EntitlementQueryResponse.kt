package moe.crx.roadblock.objects.transactions

import kotlinx.serialization.Serializable

@Serializable
data class EntitlementQueryResponse(
    var transactions: List<TransactionInfo>,
)