package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.PartyRoomAccessCode
import moe.crx.roadblock.objects.social.PlatformCredentials
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class PartyFindRoomByAccessCodeRequest(
    var roomAccessCode: PartyRoomAccessCode,
) : RequestPacket()

@Serializable
data class PartyFindRoomByAccessCodeResponse(
    @FromVersion("47.1.0")
    var ownerPlatformCredentials: PlatformCredentials? = null,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handlePartyFindRoomByAccessCode(
    session: GameConnection,
    request: PartyFindRoomByAccessCodeRequest
) {
    session.sendResponse(PartyFindRoomByAccessCodeResponse())
}