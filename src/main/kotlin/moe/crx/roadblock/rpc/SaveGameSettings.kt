package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.settings.GameSettings
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SaveGameSettingsRequest(
    var settings: GameSettings,
) : RequestPacket()

@Serializable
class SaveGameSettingsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSaveGameSettings(
    session: GameConnection,
    request: SaveGameSettingsRequest
) {
    session.sendResponse(SaveGameSettingsResponse())
}