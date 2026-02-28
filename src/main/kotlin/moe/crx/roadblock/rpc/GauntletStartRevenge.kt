package moe.crx.roadblock.rpc

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.GauntletPosition
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletStartRevengeRequest(
    var eventId: CalendarEventId,
    var opCredentials: Credentials,
    var timestamp: Instant,
    var myPosition: GauntletPosition,
    var opPosition: GauntletPosition,
) : RequestPacket()

@Serializable
class GauntletStartRevengeResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletStartRevenge(
    session: GameConnection,
    request: GauntletStartRevengeRequest
) {
    session.sendResponse(GauntletStartRevengeResponse())
}