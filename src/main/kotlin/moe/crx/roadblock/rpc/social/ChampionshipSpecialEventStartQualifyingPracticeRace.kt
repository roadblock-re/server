package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.*
import moe.crx.roadblock.objects.settings.ControlSchemeType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class ChampionshipSpecialEventStartQualifyingPracticeRaceRequest(
    var eventId: CalendarEventId,
    var carId: CarId,
    var controlSchemeType: ControlSchemeType,
) : RequestPacket()

@Serializable
data class ChampionshipSpecialEventStartQualifyingPracticeRaceResponse(
    var raceToken: RaceToken = 0u,
    var requiredPlaybackDetailLevel: RequiredPlaybackDetailLevel = RequiredPlaybackDetailLevel.OnlyPlayer,
    var requiredPlaybackCondition: RequiredPlaybackCondition = RequiredPlaybackCondition.Never,
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleChampionshipSpecialEventStartQualifyingPracticeRace(
    session: GameConnection,
    request: ChampionshipSpecialEventStartQualifyingPracticeRaceRequest
) {
    session.sendResponse(ChampionshipSpecialEventStartQualifyingPracticeRaceResponse())
}