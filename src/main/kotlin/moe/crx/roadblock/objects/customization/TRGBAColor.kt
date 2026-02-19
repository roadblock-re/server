package moe.crx.roadblock.objects.customization

import kotlinx.serialization.Serializable

@Serializable
data class TRGBAColor(
    var r: Float,
    var g: Float,
    var b: Float,
    var a: Float,
)