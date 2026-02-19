package moe.crx.roadblock.objects.customization

import kotlinx.serialization.Serializable

@Serializable
data class RimsConfig(
    var materialType: CarVisualMaterialType,
    var color: TRGBColor,
)