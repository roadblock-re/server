package moe.crx.roadblock.objects.party

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.EnumList
import moe.crx.roadblock.objects.inventory.CarStatType

@Serializable
data class CarProgression(
    var progressionForStats: EnumList<Float, CarStatType>,
)