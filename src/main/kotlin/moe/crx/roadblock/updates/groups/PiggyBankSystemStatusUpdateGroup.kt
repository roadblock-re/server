package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.piggybank.*

class PiggyBankSystemStatusUpdateGroup : RVariant(
    PiggyBankSystemPiggyBankStarted::class,
    PiggyBankSystemPiggyBankFinished::class,
    PiggyBankSystemRemoveEvents::class,
    PiggyBankSystemPiggyBankCurrentProgressChanged::class,
    PiggyBankSystemPiggyBankCurrentTierChanged::class,
    PiggyBankSystemPiggyBankFilledTimestampChanged::class,
    PiggyBankSystemPiggyBankNotifyTierClaimed::class,
    PiggyBankSystemPiggyBankTierAttemptsIncreased::class,
)