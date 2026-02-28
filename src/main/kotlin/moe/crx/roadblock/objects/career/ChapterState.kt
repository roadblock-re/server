package moe.crx.roadblock.objects.career

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.Flags

@Serializable
data class ChapterState(
    var state: ProgressState = ProgressState.Locked,
    var flags: Flags = 0u,
)