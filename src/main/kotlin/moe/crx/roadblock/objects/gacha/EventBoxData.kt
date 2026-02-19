package moe.crx.roadblock.objects.gacha

import kotlinx.serialization.Serializable

@Serializable
data class EventBoxData(
    var gachaId: GachaId,
    var openedCount: UInt,
    var openedWithoutFeatureRewardCount: UInt,
)