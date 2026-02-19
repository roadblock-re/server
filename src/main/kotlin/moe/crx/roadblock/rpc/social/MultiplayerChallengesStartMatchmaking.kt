package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.account.LatencySample
import moe.crx.roadblock.objects.account.MultiplayerChallengesSponsorId
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.objects.mpchallenges.MultiplayerChallengesStartMatchmakingDebugOptions
import moe.crx.roadblock.objects.settings.ControlSchemeType
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MultiplayerChallengesStartMatchmakingRequest(
    var debugOptions: MultiplayerChallengesStartMatchmakingDebugOptions,
    var eventId: CalendarEventId,
    var sponsorId: MultiplayerChallengesSponsorId,
    var snsCredential: Credentials?,
    var controlSchemeType: ControlSchemeType,
    var regionLatencyMap: Map<String, List<LatencySample>>?,
    var connectivityType: String,
) : RequestPacket()

@Serializable
data class MultiplayerChallengesStartMatchmakingResponse(
    var clubData: ClubData = ClubData(),
) : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMultiplayerChallengesStartMatchmaking(
    session: GameConnection,
    request: MultiplayerChallengesStartMatchmakingRequest
) {
    session.sendResponse(MultiplayerChallengesStartMatchmakingResponse())
}