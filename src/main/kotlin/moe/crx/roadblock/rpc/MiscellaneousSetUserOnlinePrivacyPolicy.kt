package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.miscellaneous.GDPRCompliancy
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse
import moe.crx.roadblock.updates.MiscellaneousUserGPDRComplianceChanged

@Serializable
data class MiscellaneousSetUserOnlinePrivacyPolicyRequest(
    @UntilVersion("24.6.0")
    var isGDPRCompliant: Boolean? = null,
    @FromVersion("24.6.0")
    var privacyPolicy: GDPRCompliancy = GDPRCompliancy.UnknownValue0,
) : RequestPacket()

@Serializable
class MiscellaneousSetUserOnlinePrivacyPolicyResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousSetUserOnlinePrivacyPolicy(
    session: GameConnection,
    request: MiscellaneousSetUserOnlinePrivacyPolicyRequest
) {
    val reaction = if (request.isGDPRCompliant != null) {
        MiscellaneousUserGPDRComplianceChanged(
            oldIsGDPRCompliant = session.gameState.miscellaneous.isGDPRCompliant,
            newIsGDPRCompliant = request.isGDPRCompliant,
        )
    } else {
        MiscellaneousUserGPDRComplianceChanged(
            oldPrivacyPolicy = session.gameState.miscellaneous.privacyPolicy,
            newPrivacyPolicy = request.privacyPolicy,
        )
    }

    if (request.isGDPRCompliant != null) {
        session.gameState.miscellaneous.isGDPRCompliant = request.isGDPRCompliant
    } else {
        session.gameState.miscellaneous.privacyPolicy = request.privacyPolicy
    }

    session.sendResponse(
        MiscellaneousSetUserOnlinePrivacyPolicyResponse().flatten(reaction)
    )
}