package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable

@Serializable
data class ClubWarsMatchmakingDebugOption(
    var force: Boolean,
)