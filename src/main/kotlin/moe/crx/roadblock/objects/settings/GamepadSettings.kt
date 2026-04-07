package moe.crx.roadblock.objects.settings

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion

@Serializable
data class GamepadSettings(
    var isAutoSelectEnabled: Boolean = false,
    var tiltingSensitivity: Float = 0.5f,
    @FromVersion("24.6.0")
    var horizonTiltEnabled: Boolean = false,
    var preferredManualControlSchemeType: GamepadManualControlSchemeType = GamepadManualControlSchemeType.A,
    var steeringSensitivityA: Float = 0.5f,
    var steeringSensitivityB: Float = 0.5f,
)