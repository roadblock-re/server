package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.GiftId
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ClaimGiftRequest(
    var giftId: GiftId,
) : RequestPacket()

@Serializable
data class ClaimGiftResponse(
    var doesResetProfile: Boolean = false,
    var doesResetCar: Boolean = false,
    var doesResetAge: Boolean = false,
    var doesResetAlias: Boolean = false,
    var doesResetCompliancyCountry: Boolean = false,
    var doesUnlockLegendFundTier: Boolean = false,
    var resetCurrencyType: CurrencyType? = null,
    var isSilent: Boolean = false
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleClaimGift(
    session: GameConnection,
    request: ClaimGiftRequest
) {
    session.sendResponse(ClaimGiftResponse())
}