package moe.crx.roadblock.objects.seasonpass

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnum

@Serializable
data class MissionData(
    var quantity: MissionProgress,
    @ByteEnum
    var state: SeasonPassMissionState,
)