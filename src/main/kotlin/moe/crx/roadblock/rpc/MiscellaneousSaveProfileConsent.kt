package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.miscellaneous.ConsentSource
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MiscellaneousSaveProfileConsentRequest(
    var hasUserConsent: Boolean,
    var source: ConsentSource,
) : RequestPacket()

@Serializable
class MiscellaneousSaveProfileConsentResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousSaveProfileConsent(
    session: GameConnection,
    request: MiscellaneousSaveProfileConsentRequest
) {
    session.sendResponse(MiscellaneousSaveProfileConsentResponse())
}