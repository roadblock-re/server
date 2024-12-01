package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.miscellaneous.*

class MiscellaneousStatusUpdateGroup : RVariant(
    MiscellaneousUserNameChanged::class,
    MiscellaneousUnderageDisclaimerShownChanged::class,
    MiscellaneousUserAgeAndGenderChanged::class,
    MiscellaneousUserGPDRComplianceChanged::class,
    MiscellaneousUserDeviceCountryChanged::class,
    MiscellaneousRegionChangeCountChanged::class,
    MiscellaneousGameSettingsChanged::class,
    MiscellaneousClaimedSystemNotificationRewardChanged::class,
    MiscellaneousXboxLiveOnlyEnableChanged::class,
    MiscellaneousEndRaceOfferHidden::class,
)