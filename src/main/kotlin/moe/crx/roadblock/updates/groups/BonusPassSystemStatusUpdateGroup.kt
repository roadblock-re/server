package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.bonuspass.*

class BonusPassSystemStatusUpdateGroup : RVariant(
    BonusPassSystemBonusPassStarted::class,
    BonusPassSystemBonusPassFinished::class,
    BonusPassSystemBonusPassDurationModified::class,
    BonusPassSystemBonusPassEventIdModified::class,
    BonusPassSystemRemoveEvents::class,
    BonusPassSystemBenefitFuelRefillsAmountChanged::class,
    BonusPassSystemBenefitFuelRefillsRestored::class,
    BonusPassSystemBenefitTLETicketsRefillsAmountChanged::class,
    BonusPassSystemBenefitTLETicketsRefillsRestored::class,
    BonusPassSystemNextTLETicketsRefillTimeChanged::class,
)