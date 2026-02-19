package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable

@Serializable
data class ClubWarsRaceStatusUpdate(
    var car: ClubWarsCarStatusUpdate,
    var time: UInt,
)