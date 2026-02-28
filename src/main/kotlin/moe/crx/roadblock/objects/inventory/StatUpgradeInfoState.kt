package moe.crx.roadblock.objects.inventory

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.EnumList
import moe.crx.roadblock.game.serialization.enumListOf
import moe.crx.roadblock.objects.UpgradeItems

@Serializable
data class StatUpgradeInfoState(
    var uncommonItems: UpgradeItems = 0u,
    var classInfo: EnumList<StatClassUpgradeInfoState, CarClass> = enumListOf { StatClassUpgradeInfoState() },
)