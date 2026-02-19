package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.CarId

@Serializable
data class EventCarInfo(
    var carId: CarId,
    var freeTry: FreeTryInfo?,
    var carPreset: CarPreset?,
)