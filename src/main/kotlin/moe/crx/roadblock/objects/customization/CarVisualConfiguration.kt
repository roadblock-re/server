package moe.crx.roadblock.objects.customization

import kotlinx.serialization.Serializable

@Serializable
data class CarVisualConfiguration(
    var configuration: CarVisualConfigurationOption = CarVisualConfigurationOption.CarOfficialVisual(0u),
    var topConfig: ConvertibleCarTopPosition? = null,
    var customParts: CustomParts? = null,
    var extraCustomizationParameters: ExtraCustomizationParameters = ExtraCustomizationParameters(),
)