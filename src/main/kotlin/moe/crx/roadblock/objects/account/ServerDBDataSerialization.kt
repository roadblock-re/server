package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class ServerDBDataSerialization(
    var gameDb: ConfigData?,
    var carWhitelist: ConfigData? = null,
)