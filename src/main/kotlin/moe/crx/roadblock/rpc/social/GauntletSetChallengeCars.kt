package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.CarId
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletSetChallengeCarsRequest(
    var eventId: CalendarEventId,
    var cars: List<CarId>,
) : RequestPacket()

@Serializable
class GauntletSetChallengeCarsResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletSetChallengeCars(
    session: GameConnection,
    request: GauntletSetChallengeCarsRequest
) {
    session.sendResponse(GauntletSetChallengeCarsResponse())
}