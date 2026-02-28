package moe.crx.roadblock.objects.club

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ClubId
import moe.crx.roadblock.objects.ClubSeasonMilestoneId
import moe.crx.roadblock.objects.ReputationPoints

@Serializable
data class ClubSeasonEvent(
    var baseReputation: ReputationPoints,
    var clubReputation: ReputationPoints,
    var contributedReputation: ReputationPoints,
    var claimedMilestones: List<ClubSeasonMilestoneId>,
    var claimableAfterFinishedByClub: ClubId,
)