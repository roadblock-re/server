package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.playerstats.GameplayTutorialType
import moe.crx.roadblock.objects.playerstats.TutorialState
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse
import moe.crx.roadblock.rpc.base.flatten
import moe.crx.roadblock.updates.PlayerStatsGameplayTutorialStateChanged

@Serializable
data class ChangeGameplayTutorialStateRequest(
    var tutorialType: GameplayTutorialType,
    var tutorialState: TutorialState,
    var stepDurationMicroseconds: UInt,
) : RequestPacket()

@Serializable
class ChangeGameplayTutorialStateResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleChangeGameplayTutorialState(
    session: GameConnection,
    request: ChangeGameplayTutorialStateRequest
) {
    val reaction = PlayerStatsGameplayTutorialStateChanged(
        type = request.tutorialType,
        oldState = session.gameState.playerStats.gameplayTutorials[request.tutorialType],
        newState = request.tutorialState,
    )

    session.gameState.playerStats.gameplayTutorials[request.tutorialType] = request.tutorialState

    session.sendResponse(ChangeGameplayTutorialStateResponse().flatten(reaction))
}