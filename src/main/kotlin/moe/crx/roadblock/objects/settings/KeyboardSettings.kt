package moe.crx.roadblock.objects.settings

import kotlinx.serialization.Serializable

@Serializable
data class KeyboardSettings(
    var isAutoSelectEnabled: Boolean = true,
    var steeringSensitivity: Float = 0.5f,
    var layout: KeyboardLayout = KeyboardLayout.Qwerty,
)