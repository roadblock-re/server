package moe.crx.roadblock.objects.customization

import kotlinx.serialization.Serializable

@Serializable
data class ExtraCustomizationParameters(
    var caliperColor: TRGBColor? = null,
    var neonColor: TRGBColor? = null,
    var rimsConfig: RimsConfig? = null,
)