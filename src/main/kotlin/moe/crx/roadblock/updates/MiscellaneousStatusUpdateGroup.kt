package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.Age
import moe.crx.roadblock.objects.EndRaceAdsOfferId
import moe.crx.roadblock.objects.miscellaneous.Gender
import moe.crx.roadblock.objects.settings.GameSettings

@Serializable
sealed class MiscellaneousStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<MiscellaneousStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(MiscellaneousUserNameChanged::class)
            add(MiscellaneousUnderageDisclaimerShownChanged::class)
            add(MiscellaneousUserAgeAndGenderChanged::class)
            add(MiscellaneousUserGPDRComplianceChanged::class)
            add(MiscellaneousUserDeviceCountryChanged::class)
            add(MiscellaneousRegionChangeCountChanged::class)
            add(MiscellaneousGameSettingsChanged::class)
            add(MiscellaneousClaimedSystemNotificationRewardChanged::class)
            add(MiscellaneousXboxLiveOnlyEnableChanged::class)
            add(MiscellaneousEndRaceOfferHidden::class)
        }
    }
}

@Serializable
data class MiscellaneousClaimedSystemNotificationRewardChanged(
    var hasClaimed: Boolean
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousEndRaceOfferHidden(
    var newValue: EndRaceAdsOfferId,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousGameSettingsChanged(
    var oldSettings: GameSettings,
    var newSettings: GameSettings,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousRegionChangeCountChanged(
    var newValue: UInt
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
data class MiscellaneousUserDeviceCountryChanged(
    var oldCountryStr: String,
    var newCountryStr: String,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousUserGPDRComplianceChanged(
    var oldGdprCompliance: Boolean?,
    var newGdprCompliance: Boolean?,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousUserNameChanged(
    var oldUsername: String,
    var newUsername: String,
) : MiscellaneousStatusUpdateGroup()

@Serializable
data class MiscellaneousXboxLiveOnlyEnableChanged(
    var oldEnable: Boolean?,
    var newEnable: Boolean?,
) : MiscellaneousStatusUpdateGroup()