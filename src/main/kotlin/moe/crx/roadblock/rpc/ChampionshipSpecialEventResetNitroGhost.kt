package moe.crx.roadblock.rpc

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.ChampionshipRoundId
import moe.crx.roadblock.objects.EventTrackDefId
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.championship.ChampionshipStageType
import moe.crx.roadblock.objects.inventory.CurrencyType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ChampionshipSpecialEventResetNitroGhostRequest(
    var eventId: CalendarEventId,
    var stageType: ChampionshipStageType,
    var roundId: ChampionshipRoundId,
    var currencyType: CurrencyType,
    var cost: Money,
    var trackDefId: EventTrackDefId,
    var debugSuffix: String,
) : RequestPacket()

@Serializable
class ChampionshipSpecialEventResetNitroGhostResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleChampionshipSpecialEventResetNitroGhost(
    session: GameConnection,
    request: ChampionshipSpecialEventResetNitroGhostRequest
) {
    session.sendResponse(ChampionshipSpecialEventResetNitroGhostResponse())
}