package moe.crx.roadblock.objects.party

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.account.PlatformType
import moe.crx.roadblock.objects.account.PsnIssuerId
import moe.crx.roadblock.objects.account.RaceToken

@Serializable
data class PartyClientUserData(
    var alias: String?,
    var name: String,
    var racerData: PartyClientRacerData,
    var snsCredential: Credentials?,
    var psnIssuerId: PsnIssuerId?,
    var clubData: MultiplayerUserClubData?,
    var timestamp: Instant,
    var raceToken: RaceToken,
    var partyReadyState: PartyReadyState,
    var platform: PlatformType,
    var userRole: UserRole,
)