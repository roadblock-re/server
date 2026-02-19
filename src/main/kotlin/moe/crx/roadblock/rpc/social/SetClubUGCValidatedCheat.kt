package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class SetClubUGCValidatedCheatRequest(
    var isClubUGCValidated: Boolean,
) : RequestPacket()

@Serializable
data class SetClubUGCValidatedCheatResponse(
    var clubData: ClubData = ClubData(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleSetClubUGCValidatedCheat(
    session: GameConnection,
    request: SetClubUGCValidatedCheatRequest
) {
    session.sendResponse(SetClubUGCValidatedCheatResponse())
}