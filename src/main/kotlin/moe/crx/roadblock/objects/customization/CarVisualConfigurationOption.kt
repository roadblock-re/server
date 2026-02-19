package moe.crx.roadblock.objects.customization

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.account.CarDecalVisualId
import moe.crx.roadblock.objects.account.CarOfficialVisualIndex

@Serializable
sealed class CarVisualConfigurationOption {
    companion object : Variant<CarVisualConfigurationOption> {
        override fun variants(version: SerializationVersion) = buildList {
            add(CarOfficialVisual::class)
            add(CarCustomization::class)
            add(CarDecalVisual::class)
        }
    }

    @Serializable
    data class CarOfficialVisual(var visualId: CarOfficialVisualIndex) : CarVisualConfigurationOption()

    @Serializable
    data class CarCustomization(
        var materialType: CarVisualMaterialType,
        var color1: TRGBColor,
        var color2: TRGBColor?
    ) : CarVisualConfigurationOption()

    @Serializable
    data class CarDecalVisual(var decalId: CarDecalVisualId) : CarVisualConfigurationOption()
}