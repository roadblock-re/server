package moe.crx.roadblock.rpc.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConnectGameRequest(
    @SerialName("fed_id")
    var fedId: String,
    @SerialName("room_id")
    var roomId: String,
)