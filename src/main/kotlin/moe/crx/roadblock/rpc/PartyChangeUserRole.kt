package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.party.PartyReadyState
import moe.crx.roadblock.objects.party.UserRole
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartyChangeUserRoleRequest(
    var targetCredentials: Credentials,
    var newUserRole: UserRole,
    @FromVersion("47.1.0")
    var newPartyReadyState: PartyReadyState = PartyReadyState.NotReady,
) : RequestPacket()

@Serializable
class PartyChangeUserRoleResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyChangeUserRole(
    session: GameConnection,
    request: PartyChangeUserRoleRequest
) {
    session.sendResponse(PartyChangeUserRoleResponse())
}