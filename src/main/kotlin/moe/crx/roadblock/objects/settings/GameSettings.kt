package moe.crx.roadblock.objects.settings

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.StringEnum

@Serializable
data class GameSettings(
    @StringEnum
    var cameraCarType: CameraCarType = CameraCarType.Close,
    var carSpeedUnit: CarSpeedUnit = CarSpeedUnit.Metric,
    var takedownEffectEnabled: Boolean = true,
    var gameLanguage: Localization = Localization(),
    var regionCode: RegionCode = RegionCode.US,
    var controlSettings: ControlSettings = ControlSettings(),
    @FromVersion("24.0.0")
    var promoScreensEnabled: Boolean = true,
)