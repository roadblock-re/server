package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.PlayerElo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class GauntletSetEloCheatRequest(
    var eventId: CalendarEventId,
    var elo: PlayerElo,
) : RequestPacket()

@Serializable
class GauntletSetEloCheatResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleGauntletSetEloCheat(
    session: GameConnection,
    request: GauntletSetEloCheatRequest
) {
    session.sendResponse(GauntletSetEloCheatResponse())
}