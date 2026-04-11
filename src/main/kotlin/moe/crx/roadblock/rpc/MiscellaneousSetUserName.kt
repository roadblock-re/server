package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse
import moe.crx.roadblock.rpc.base.flatten
import moe.crx.roadblock.updates.MiscellaneousUserNameChanged

@Serializable
data class MiscellaneousSetUserNameRequest(
    var username: String,
) : RequestPacket()

@Serializable
class MiscellaneousSetUserNameResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousSetUserName(
    session: GameConnection,
    request: MiscellaneousSetUserNameRequest
) {
    val reaction = MiscellaneousUserNameChanged(
        oldUsername = session.gameState.miscellaneous.username,
        newUsername = request.username,
        isForcedChange = false,
    )

    session.gameState.miscellaneous.apply {
        username = request.username
        hasUserChangedName = true
        isUserNameForced = false
        uniqueUserNameChangeCount = ((uniqueUserNameChangeCount ?: 0.toUInt()) + 1.toUInt())
    }

    session.sendResponse(MiscellaneousSetUserNameResponse().flatten(reaction))
}