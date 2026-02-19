package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable

@Serializable
data class ClubWarsRegionAttackNodeData(
    var isConquered: Boolean,
    var isSelectedEntryPoint: Boolean,
)