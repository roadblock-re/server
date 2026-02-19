package moe.crx.roadblock.objects.inventory

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.EnumList
import moe.crx.roadblock.game.serialization.enumListOf

@Serializable
data class CarTuningState(
    var stats: EnumList<CarStat, CarStatType> = enumListOf { CarStat() }
)