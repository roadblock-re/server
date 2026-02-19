package moe.crx.roadblock.objects.settings

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.GamepadId

@Serializable
data class ControlSettings(
    var controlMode: ControlMode = ControlMode.Manual,
    var touchScreenSettings: TouchScreenSettings = TouchScreenSettings(),
    var gamepadsSettings: Map<GamepadId, GamepadSettings> = mapOf(),
    var keyboardSettings: KeyboardSettings = KeyboardSettings(),
    var isAutoAccelerationEnabled: Boolean = false,
    var isManualAccelerationTutorialNeeded: Boolean = false,
    @FromVersion("24.0.0")
    var isRumbleEnabled: Boolean = true,
)