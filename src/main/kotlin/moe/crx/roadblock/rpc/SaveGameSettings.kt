package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.settings.GameSettings
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse
import moe.crx.roadblock.rpc.base.flatten
import moe.crx.roadblock.updates.MiscellaneousGameSettingsChanged

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
    val reaction = MiscellaneousGameSettingsChanged(
        oldSettings = session.gameState.miscellaneous.gameSettings,
        newSettings = request.settings,
    )

    session.gameState.miscellaneous.gameSettings = request.settings

    session.sendResponse(SaveGameSettingsResponse().flatten(reaction))
}