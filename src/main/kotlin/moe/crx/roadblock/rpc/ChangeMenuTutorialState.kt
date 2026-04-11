package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.playerstats.MenuTutorialType
import moe.crx.roadblock.objects.playerstats.TutorialState
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse
import moe.crx.roadblock.rpc.base.flatten
import moe.crx.roadblock.updates.PlayerStatsMenuTutorialStateChanged

@Serializable
data class ChangeMenuTutorialStateRequest(
    var menuTutorialType: MenuTutorialType,
    var tutorialState: TutorialState,
    var durationMicroseconds: UInt,
) : RequestPacket()

@Serializable
class ChangeMenuTutorialStateResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleChangeMenuTutorialState(
    session: GameConnection,
    request: ChangeMenuTutorialStateRequest
) {
    val reaction = PlayerStatsMenuTutorialStateChanged(
        type = request.menuTutorialType,
        oldState = session.gameState.playerStats.menuTutorials[request.menuTutorialType],
        newState = request.tutorialState,
    )

    session.gameState.playerStats.menuTutorials[request.menuTutorialType] = request.tutorialState

    session.sendResponse(ChangeMenuTutorialStateResponse().flatten(reaction))
}