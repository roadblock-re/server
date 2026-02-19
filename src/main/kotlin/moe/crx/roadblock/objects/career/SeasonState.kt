package moe.crx.roadblock.objects.career

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.Flags
import moe.crx.roadblock.objects.account.ProgressState

@Serializable
data class SeasonState(
    var state: ProgressState = ProgressState.Locked,
    var flags: Flags = 0u,
)