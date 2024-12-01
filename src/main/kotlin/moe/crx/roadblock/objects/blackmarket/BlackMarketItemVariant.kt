package moe.crx.roadblock.objects.blackmarket

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.objects.item.*

class BlackMarketItemVariant : RVariant(
    Blueprint::class,
    CarUnlockItem::class,
    Currency::class,
    CustomizationUnlockReward::class,
    EmojiItem::class,
    UpgradeItem::class,
    VanityBadge::class,
    WildcardBlueprint::class,
    OverclockChip::class
)