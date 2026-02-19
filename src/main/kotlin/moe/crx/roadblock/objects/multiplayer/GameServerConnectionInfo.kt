package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion

@Serializable
data class GameServerConnectionInfo(
    var scheme: GameServerScheme,
    var host: String,
    var port: UShort,
    @FromVersion("24.0.0")
    var neuronUdpPort: UShort? = null,
)