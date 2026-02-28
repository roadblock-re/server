package moe.crx.roadblock.objects.party

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.EventTrackDefId
import moe.crx.roadblock.objects.inventory.CarClass

@Serializable
data class CustomizablePrivateRaceSettings(
    var trackId: EventTrackDefId,
    var laps: UInt,
    @FromVersion("24.0.0")
    var maxCarClass: CarClass = CarClass.S,
    @FromVersion("47.1.0")
    var gameMode: UInt = 0u,
    @FromVersion("47.1.0")
    var carContact: CarId = 0u,
    @FromVersion("47.1.0")
    var ghostTime: ULong? = null,
)