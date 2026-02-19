package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class TimeLimitedSpecialEventClaimProgressionRewardRequest(
    var eventId: CalendarEventId,
    @UntilVersion("47.1.0")
    var rewardIdx: UByte = 0u,
    @FromVersion("47.1.0")
    var rewardIdxs: List<UByte> = listOf(),
) : RequestPacket()

@Serializable
class TimeLimitedSpecialEventClaimProgressionRewardResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleTimeLimitedSpecialEventClaimProgressionReward(
    session: GameConnection,
    request: TimeLimitedSpecialEventClaimProgressionRewardRequest
) {
    session.sendResponse(TimeLimitedSpecialEventClaimProgressionRewardResponse())
}