package moe.crx.roadblock.objects.settings

import kotlinx.serialization.Serializable

@Serializable
data class TouchScreenSettings(
    //TouchScreenSmartDriveSetting
    var touchDriveSensitivity: Float = 0.85f,
    //TouchScreenTapToSteerSetting
    var tappingSensitivity: Float = 0.5f,
    var iconsScale: Float = 1.0f,
    var leftNitroOffset: Vector2f = Vector2f(),
    var leftDriftOffset: Vector2f = Vector2f(),
    var rightNitroOffset: Vector2f = Vector2f(),
    var rightDriftOffset: Vector2f = Vector2f(),
    // TouchScreenTiltToSteerSetting
    var tiltingSensitivity: Float = 0.5f,
    var isHorizonTiltEnabled: Boolean = true,
    var preferredManualControlSchemeType: TouchScreenManualControlSchemeType = TouchScreenManualControlSchemeType.TiltToSteer,
    var isAutoselectEnabled: Boolean = false,
)