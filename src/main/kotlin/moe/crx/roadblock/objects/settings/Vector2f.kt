package moe.crx.roadblock.objects.settings

import kotlinx.serialization.Serializable

@Serializable
data class Vector2f(
    var x: Float = 0f,
    var y: Float = 0f,
)