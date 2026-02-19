package moe.crx.roadblock.objects.customization

import kotlinx.serialization.Serializable

@Serializable
data class TRGBColor(
    var r: Float,
    var g: Float,
    var b: Float,
)