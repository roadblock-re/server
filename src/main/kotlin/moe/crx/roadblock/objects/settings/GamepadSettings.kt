package moe.crx.roadblock.objects.settings

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion

@Serializable
data class GamepadSettings(
    var isAutoselectEnabled: Boolean = false,
    var tiltingSensitivity: Float = 0.5f,
    @FromVersion("24.6.0")
    var isHorizonTiltEnabled: Boolean = false,
    var selectedLayout: GamepadManualControlSchemeType = GamepadManualControlSchemeType.TiltToSteer,
    var touchDriveSensitivity: Float = 0.8f,
    var manualSensitivity: Float = 0.5f,
)