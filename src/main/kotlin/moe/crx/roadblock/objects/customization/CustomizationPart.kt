package moe.crx.roadblock.objects.customization

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CarCustomPartId
import moe.crx.roadblock.objects.CarDecalVisualId

@Serializable
sealed class CustomizationPart {
    companion object : Variant<CustomizationPart> {
        override fun variants(version: SerializationVersion) = buildList {
            add(CarDecalVisualPart::class)
            add(CarCustomPart::class)
            add(CustomizationPart2::class)
            add(CustomizationPart3::class)
        }
    }
}

@Serializable
data class CarDecalVisualPart(var visualId: CarDecalVisualId) : CustomizationPart()

@Serializable
data class CarCustomPart(var partId: CarCustomPartId) : CustomizationPart()

@Serializable
data class CustomizationPart2(var intValue: UInt) : CustomizationPart()

@Serializable
data class CustomizationPart3(var intValue: UInt) : CustomizationPart()