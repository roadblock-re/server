package moe.crx.roadblock.objects.uber

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.UberMissionId

@Serializable
data class UberPoolMissionId(
    var poolType: UberPoolType,
    var missionId: UberMissionId,
)