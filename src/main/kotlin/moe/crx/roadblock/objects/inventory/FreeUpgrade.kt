package moe.crx.roadblock.objects.inventory

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.CarUpgradeTier

@Serializable
sealed class FreeUpgrade {
    companion object : Variant<FreeUpgrade> {
        override fun variants(version: SerializationVersion) = buildList {
            add(CarSpecificFreeUpgrade::class)
            add(ClassSpecificFreeUpgrade::class)
            add(ClassAndUnlockedTierSpecificFreeUpgrade::class)
        }
    }
}

@Serializable
data class CarSpecificFreeUpgrade(var carId: CarId) : FreeUpgrade()

@Serializable
data class ClassSpecificFreeUpgrade(var carClass: CarClass) : FreeUpgrade()

@Serializable
data class ClassAndUnlockedTierSpecificFreeUpgrade(var carClass: CarClass, var tier: CarUpgradeTier) : FreeUpgrade()