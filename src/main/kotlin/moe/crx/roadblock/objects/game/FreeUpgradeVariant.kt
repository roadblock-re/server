package moe.crx.roadblock.objects.game

import moe.crx.roadblock.objects.base.RVariant

class FreeUpgradeVariant : RVariant(
    CarSpecificFreeUpgrade::class,
    ClassSpecificFreeUpgrade::class,
    ClassAndUnlockedTierSpecificFreeUpgrade::class,
)