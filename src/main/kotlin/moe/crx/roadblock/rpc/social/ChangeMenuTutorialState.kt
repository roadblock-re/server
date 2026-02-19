package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.playerstats.MenuTutorialType
import moe.crx.roadblock.objects.playerstats.TutorialState
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

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
    session.sendResponse(ChangeMenuTutorialStateResponse())
}