package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CarDecalVisualId
import moe.crx.roadblock.objects.CarOfficialVisualIndex

@Serializable
sealed class CarVisualVariant {
    companion object : Variant<CarVisualVariant> {
        override fun variants(version: SerializationVersion) = buildList {
            add(CarOfficialVisual::class)
            add(CarDecalVisual::class)
        }
    }
}

@Serializable
data class CarOfficialVisual(var visualId: CarOfficialVisualIndex) : CarVisualVariant()

@Serializable
data class CarDecalVisual(var decalId: CarDecalVisualId) : CarVisualVariant()