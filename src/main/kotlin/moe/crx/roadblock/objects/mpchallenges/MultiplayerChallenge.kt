package moe.crx.roadblock.objects.mpchallenges

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.MultiplayerChallengesSponsorId
import moe.crx.roadblock.objects.account.MultiplayerChallengesStageId

@Serializable
data class MultiplayerChallenge(
    var victories: UByte,
    var defeats: UByte,
    var revives: UByte,
    var participationState: UInt,
    var seasonPassFreeEntryConsumed: Boolean,
    var revealedSponsorsStep: MultiplayerChallengesStageId,
    var selectedSponsor: MultiplayerChallengesSponsorId,
    var sponsorsSeed: UInt,
    var cooldownEnd: Instant,
    var victoriesWhenRevived: UByte,
    var forceQuarantine: Boolean,
)