package moe.crx.roadblock.objects.item

import moe.crx.roadblock.objects.base.RVariant

class UpgradeItem : RVariant(
    UncommonUpgradeItem::class,
    RareUpgradeItem::class,
    EpicUpgradeItem::class,
)