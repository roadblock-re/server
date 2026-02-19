package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.GDPRCompliancy
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MiscellaneousSetUserOnlinePrivacyPolicyRequest(
    @UntilVersion("24.6.0")
    var legacyPrivacyPolicy: Boolean? = null,
    @FromVersion("24.6.0")
    var isGDPRCompliant: GDPRCompliancy = GDPRCompliancy.UnknownValue0,
) : RequestPacket()

@Serializable
class MiscellaneousSetUserOnlinePrivacyPolicyResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousSetUserOnlinePrivacyPolicy(
    session: GameConnection,
    request: MiscellaneousSetUserOnlinePrivacyPolicyRequest
) {
    session.sendResponse(MiscellaneousSetUserOnlinePrivacyPolicyResponse())
}