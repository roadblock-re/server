package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.social.SNSUserConflictData
import moe.crx.roadblock.objects.social.SNSUserLoginData
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GetRemoteAccountConflictDataRequest(
    var remoteUserLogin: SNSUserLoginData,
) : RequestPacket()

@Serializable
data class GetRemoteAccountConflictDataResponse(
    var userConflictData: SNSUserConflictData,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGetRemoteAccountConflictData(
    session: GameConnection,
    request: GetRemoteAccountConflictDataRequest
) {
    TODO()
}