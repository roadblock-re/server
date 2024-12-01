package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.gacha.*

class GachaSystemStatusUpdateGroup : RVariant(
    GachaSystemLockedStateChanged::class,
    GachaSystemNextBoxIsCriticalChanged::class,
    GachaSystemRetentionBoxReadyTimeChanged::class,
    GachaSystemOpenedEventBoxes::class,
    GachaSystemRemoveEvents::class,
    GachaSystemOpenedBoxes::class,
    OpenedGachaBoxContainer::class,
)