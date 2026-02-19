package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class EntitlementQueryResponse(
    var transactions: List<TransactionInfo>,
)