package moe.crx.roadblock.objects.clubwars

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.social.Credentials

@Serializable
data class ClubWarsNodeStatusUpdate(
    var defenseMemberCredential: Credentials,
    var defenseCar: ClubWarsCarStatusUpdate?,
    var defenseRaceTime: UInt?,
    var attackAttemptCount: UInt?,
    var attackMemberCredential: Credentials?,
    var attackRace: ClubWarsRaceStatusUpdate?,
    var attackHelpingMemberCredential: Credentials?,
    var isConquered: Boolean?,
    var attackLockMemberCredential: Credentials?,
    var attackLockTimestamp: Instant?,
)