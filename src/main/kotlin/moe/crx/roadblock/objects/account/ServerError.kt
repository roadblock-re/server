package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class ServerError(
    var code: UInt = 0u,
    var what: String = "",
    var innerError: ServerError? = null,
)