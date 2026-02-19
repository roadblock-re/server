package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CredentialAuthority
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.ResponsePacket

@Serializable
data class GetPlatformIdsRequest(
    var federationIds: List<String>,
    var credentialType: CredentialAuthority,
) : RequestPacket()

@Serializable
data class GetPlatformIdsResponse(
    var platformIds: Map<String, String> = mapOf(),
) : ResponsePacket()

suspend fun handleGetPlatformIds(
    session: GameConnection,
    request: GetPlatformIdsRequest
) {
    session.sendResponse(GetPlatformIdsResponse())
}