package moe.crx.roadblock.objects.social

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.ClubId
import moe.crx.roadblock.objects.CollectorStage
import moe.crx.roadblock.objects.GarageLevel
import moe.crx.roadblock.objects.GarageValue
import moe.crx.roadblock.objects.PlayerElo
import moe.crx.roadblock.objects.ReputationLevel
import moe.crx.roadblock.objects.club.ClubMemberRank
import moe.crx.roadblock.objects.multiplayer.MultiplayerSeriesTierInfo

@Serializable
data class OnlineUserData(
    var federationCredential: Credentials,
    var timestamp: Instant?,
    var joinedTimestamp: Instant?,
    var name: String?,
    var alias: String?,
    var reputationLevel: ReputationLevel?,
    var garageLevel: GarageLevel?,
    var multiplayerWorldEventId: CalendarEventId?,
    var multiplayerWorldTierInfo: MultiplayerSeriesTierInfo?,
    var multiplayerPlayerElo: PlayerElo?,
    var clubId: ClubId?,
    var clubRank: ClubMemberRank?,
    var isUnderAge: Boolean?,
    var garageValue: GarageValue?,
    var platform: PlatformType?,
    var platformUsername: String?,
    var allCredentials: List<Credentials>?,
    var isOnline: Boolean?,
    @FromVersion("24.0.0") // TODO or 24.1.0?
    var allowsSocialFeatures: Boolean? = null,
    @FromVersion("24.0.0") // TODO or 24.1.0?
    var collectorStage: CollectorStage? = null,
)