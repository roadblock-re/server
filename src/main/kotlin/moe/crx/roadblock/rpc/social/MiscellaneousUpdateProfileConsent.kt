package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.ConsentSource
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MiscellaneousUpdateProfileConsentRequest(
    @UntilVersion("47.1.0")
    var purposeStatus: Map<String, Boolean> = mapOf(),
    @FromVersion("47.1.0")
    var hasUserConsent: Boolean = false,
    var source: ConsentSource,
) : RequestPacket()

@Serializable
class MiscellaneousUpdateProfileConsentResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousUpdateProfileConsent(
    session: GameConnection,
    request: MiscellaneousUpdateProfileConsentRequest
) {
    session.sendResponse(MiscellaneousUpdateProfileConsentResponse())
}