package moe.crx.roadblock.objects.item

import moe.crx.roadblock.objects.base.RVariant

class TrashableItem : RVariant(
    Blueprint::class,
    UpgradeItem::class,
    CarUnlockItem::class,
    CarCustomPart::class,
    CarDecalVisual::class,
    EmojiItem::class,
    VanityBadge::class, // ALU doesn't have this
    WildcardBlueprint::class,
    OverclockChip::class,
)