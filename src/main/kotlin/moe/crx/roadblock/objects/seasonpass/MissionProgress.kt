package moe.crx.roadblock.objects.seasonpass

import kotlinx.serialization.Serializable


// TODO Replace this structure with proper variant implementation
@Serializable
data class MissionProgress(
    var variant: Byte,
    var progress: UInt,
)