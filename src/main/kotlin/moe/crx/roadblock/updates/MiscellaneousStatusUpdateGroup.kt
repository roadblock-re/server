package moe.crx.roadblock.updates

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.Age
import moe.crx.roadblock.objects.EndRaceAdsOfferId
import moe.crx.roadblock.objects.LimitRulesID
import moe.crx.roadblock.objects.miscellaneous.GDPRCompliancy
import moe.crx.roadblock.objects.miscellaneous.Gender
import moe.crx.roadblock.objects.settings.GameSettings
import moe.crx.roadblock.objects.social.CrossplayPlatformFilter
import moe.crx.roadblock.objects.social.PlatformType

@Serializable
sealed class MiscellaneousStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<MiscellaneousStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            if (version newer "24.0.0") {
                add(MiscellaneousAliasChanged::class)
            }
            add(MiscellaneousUserNameChanged::class)
            add(MiscellaneousUnderageDisclaimerShownChanged::class)
            add(MiscellaneousUserAgeAndGenderChanged::class)
            add(MiscellaneousUserGPDRComplianceChanged::class)
            add(MiscellaneousUserDeviceCountryChanged::class)
            add(MiscellaneousRegionChangeCountChanged::class)
            add(MiscellaneousGameSettingsChanged::class)
            add(MiscellaneousClaimedSystemNotificationRewardChanged::class)
            if (version older "24.0.0") { // TODO find exact version
                add(MiscellaneousXboxLiveOnlyEnableChanged::class)
            }
            add(MiscellaneousEndRaceOfferHidden::class)
            add(MiscellaneousStatusUpdateGroup10::class)
            add(MiscellaneousStatusUpdateGroup11::class)
            add(MiscellaneousCurrentPlatformChanged::class)
            add(MiscellaneousStatusUpdateGroup13::class)
            add(MiscellaneousStatusUpdateGroup14::class)
            add(MiscellaneousStatusUpdateGroup15::class)
            add(MiscellaneousStatusUpdateGroup16::class)
        }
    }
}

@Serializable
data class MiscellaneousAliasChanged(
    var oldAlias: String,
    var newAlias: String,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousUserNameChanged(
    var oldUsername: String,
    var newUsername: String,
    @FromVersion("24.0.0")
    var isForcedChange: Boolean,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousUnderageDisclaimerShownChanged(
    var oldShown: Boolean,
    var newShown: Boolean,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousUserAgeAndGenderChanged(
    var oldUserAge: Age,
    var newUserAge: Age,
    var oldUserGender: Gender,
    var newUserGender: Gender,
    var oldAgeBaseSecondsFromEpoch: Instant,
    var newAgeBaseSecondsFromEpoch: Instant,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousUserGPDRComplianceChanged(
    @UntilVersion("24.6.0")
    var oldIsGDPRCompliant: Boolean? = null,
    @UntilVersion("24.6.0")
    var newIsGDPRCompliant: Boolean? = null,
    @FromVersion("24.6.0")
    var oldPrivacyPolicy: GDPRCompliancy = GDPRCompliancy.UnknownValue0,
    @FromVersion("24.6.0")
    var newPrivacyPolicy: GDPRCompliancy = GDPRCompliancy.UnknownValue0,
    @FromVersion("24.0.0")
    var changedTime: Instant = now(),
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousUserDeviceCountryChanged(
    var oldCountryStr: String,
    var newCountryStr: String,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousRegionChangeCountChanged(
    var newValue: UInt
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousGameSettingsChanged(
    var oldSettings: GameSettings,
    var newSettings: GameSettings,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousClaimedSystemNotificationRewardChanged(
    var hasClaimed: Boolean
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousXboxLiveOnlyEnableChanged(
    var oldEnable: Boolean?,
    var newEnable: Boolean?,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousEndRaceOfferHidden(
    var newValue: EndRaceAdsOfferId,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousStatusUpdateGroup10(
    var timestamp: Instant,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousStatusUpdateGroup11(
    var crossplayPlatformFilter: CrossplayPlatformFilter,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousCurrentPlatformChanged(
    var currentPlatform: PlatformType,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousStatusUpdateGroup13(
    var limitRulesID: LimitRulesID,
    var amount: UInt,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousStatusUpdateGroup14(
    var type: UInt,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousStatusUpdateGroup15(
    var nextResetTime: Instant,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousStatusUpdateGroup16(
    var hasPlayed: Boolean,
) : MiscellaneousStatusUpdateGroup()