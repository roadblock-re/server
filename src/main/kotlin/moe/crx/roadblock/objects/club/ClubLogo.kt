package moe.crx.roadblock.objects.club

import kotlinx.serialization.Serializable

@Serializable
data class ClubLogo(
    var shapeIndex: UShort,
    var colorIndex: UByte,
    var iconOrFlagIndex: UShort,
    var isFlag: Boolean,
)