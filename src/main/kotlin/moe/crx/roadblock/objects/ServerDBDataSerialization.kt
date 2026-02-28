package moe.crx.roadblock.objects

import kotlinx.serialization.Serializable

@Serializable
data class ServerDBDataSerialization(
    var gameDb: ConfigData?,
    var carWhitelist: ConfigData? = null,
)