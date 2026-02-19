package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.DateTimeUnit.Companion.HOUR
import kotlinx.datetime.Instant
import kotlinx.datetime.plus
import kotlinx.serialization.Serializable
import moe.crx.roadblock.core.utils.midnight
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.*
import moe.crx.roadblock.objects.settings.GameSettings

@Serializable
data class MiscellaneousState(
    var username: String = "Driver",
    var gameSettings: GameSettings = GameSettings(),
    var regionChangeCount: UInt = 0u,
    var userAge: Age = 99,
    var userAgeBaseTimePoint: Instant = now(),
    var userGender: Gender = Gender.Unknown,
    var alias: String? = "roadblock",
    var deviceCountry: String? = "US",
    var claimedEnableSystemNotificationsReward: Boolean = false,
    var channelName: String? = null,
    @FromVersion("24.6.0") @ByteEnum
    var isGDPRCompliant: GDPRCompliancy = GDPRCompliancy.UnknownValue0,
    @UntilVersion("24.6.0")
    var legacyIsGDPRCompliant: Boolean? = null,
    @UntilVersion("24.0.0")
    var consentNoticeShown: Boolean = false,
    @UntilVersion("24.0.0")
    var legacyPlatform: PlatformType? = null,
    @FromVersion("24.0.0")
    var platform: PlatformType = PlatformType.Unknown,
    @UntilVersion("24.6.0")
    var xboxLiveOnlyEnabled: Boolean? = null,
    @UntilVersion("24.0.0")
    var uniqueUserNameChangeCount: UInt? = null,
    @FromVersion("47.1.0")
    var hasPlayedOnAdsPlatform: Boolean = false,
    @FromVersion("24.0.0")
    var hiddenEndRaceAdsOfferIds: List<EndRaceAdsOfferId> = listOf(),
    @FromVersion("24.0.0")
    var lastLoginTimestamp: Instant = now(),
    @FromVersion("24.0.0")
    var lastAdWatchedTimestamp: Instant = now(),
    @FromVersion("24.0.0")
    var underageDisclaimerShown: Boolean = false,
    @FromVersion("24.0.0")
    var xboxCrossplayPlatformFilter: CrossplayPlatformFilter = CrossplayPlatformFilter.CrossPlay,
    @FromVersion("24.0.0")
    var psCrossplayPlatformFilter: CrossplayPlatformFilter = CrossplayPlatformFilter.CrossPlay,
    @FromVersion("24.0.0")
    var claimedDLCs: List<String> = listOf(),
    @FromVersion("24.0.0")
    var hasUserChangedName: Boolean = false,
    @FromVersion("24.0.0")
    var isUserNameForced: Boolean = false,
    @FromVersion("24.0.0")
    var offlinePurchasedAmounts: Map<LimitRulesID, UInt> = mapOf(),
    @FromVersion("24.6.0")
    var adsReplacementRemaining: Map<Int, Int> = mapOf(),
    @FromVersion("24.6.0")
    var resetAdsReplacementTimepoint: Instant = now().midnight().plus(24, HOUR),
)