package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
class ProcessSponsorshipDailyLoginRequest : RequestPacket()

@Serializable
class ProcessSponsorshipDailyLoginResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleProcessSponsorshipDailyLogin(
    session: GameConnection,
    request: ProcessSponsorshipDailyLoginRequest
) {
    session.sendResponse(ProcessSponsorshipDailyLoginResponse())
}