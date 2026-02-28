package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.MultiplayerChallengesSponsorId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerChallengesSelectSponsorRequest(
    var eventId: CalendarEventId,
    var sponsorId: MultiplayerChallengesSponsorId,
    var carId: CarId,
) : RequestPacket()

@Serializable
class MultiplayerChallengesSelectSponsorResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerChallengesSelectSponsor(
    session: GameConnection,
    request: MultiplayerChallengesSelectSponsorRequest
) {
    session.sendResponse(MultiplayerChallengesSelectSponsorResponse())
}