package moe.crx.roadblock.objects.settings

import kotlinx.serialization.Serializable

@Serializable
data class KeyboardSettings(
    var isAutoselectEnabled: Boolean = true,
    var manualSensitivity: Float = 0.5f,
    var isKeyboardAzerty: KeyboardLayout = KeyboardLayout.Qwerty,
)