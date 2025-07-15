package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.*
import moe.crx.roadblock.objects.game.CrossplayPlatformFilter
import moe.crx.roadblock.objects.game.GameSettings
import moe.crx.roadblock.objects.game.Gender

class MiscellaneousState : RObject {

    var username: String = ""
    var gameSettings: GameSettings = GameSettings()
    var regionChangeCount: Int = 0
    var userAge: Byte = 0
    var userAgeTimeBase: Instant = now()
    var userGender: Gender = Gender.Unknown
    var alias: RString? = null
    var deviceCountry: RString? = null
    var claimedEnableSystemNotificationsReward: Boolean = false
    var channelName: RString? = null
    var privacyPolicy: RByte? = null
    var platform: RInt? = null // PlatformType
    var xboxLiveOnlyEnabled: RBoolean? = null
    var uniqueUserNameChangeCount: RInt? = null
    var hiddenEndRaceAdsOfferIds: List<RInt> = listOf()
    var lastLoginTimestamp: Instant = now()
    var lastAdWatchedTimestamp: Instant = now()
    var underageDisclaimerShown: Boolean = false
    var xboxCrossplayPlatformFilter: CrossplayPlatformFilter = CrossplayPlatformFilter.CrossPlay
    var psCrossplayPlatformFilter: CrossplayPlatformFilter = CrossplayPlatformFilter.CrossPlay
    var claimedDLCs: List<RString> = listOf()
    var hasUserChangedName: Boolean = false
    var isUserNameForced: Boolean = false
    var offlinePurchasedAmounts: Map<RString, RInt> = mapOf()
    var adsReplacementRemaining: Map<RInt, RInt> = mapOf()
    var resetAdsReplacementTimepoint: Instant = now()

    override fun read(sink: InputSink) {
        username = sink.readString()
        gameSettings = sink.readObject()
        regionChangeCount = sink.readInt()
        userAge = sink.readByte()
        userAgeTimeBase = sink.readInstant()
        userGender = sink.readEnum()
        alias = sink.readOptional()
        deviceCountry = sink.readOptional()
        claimedEnableSystemNotificationsReward = sink.readBoolean()
        channelName = sink.readOptional()
        privacyPolicy = if (sink older "24.6.0") {
            sink.readOptional()
        } else {
            RByte(sink.readByte())
        }
        if (sink older "24.0.0") {
            underageDisclaimerShown = sink.readBoolean()
        }
        platform = if (sink older "24.0.0") {
            sink.readOptional()
        } else {
            sink.readObject()
        }
        if (sink older "24.6.0") {
            xboxLiveOnlyEnabled = sink.readOptional()
        }
        if (sink older "24.0.0") {
            uniqueUserNameChangeCount = sink.readOptional()
        }
        if (sink newer "24.0.0") {
            hiddenEndRaceAdsOfferIds = sink.readList()
            lastLoginTimestamp = sink.readInstant()
            lastAdWatchedTimestamp = sink.readInstant()
            underageDisclaimerShown = sink.readBoolean()
            xboxCrossplayPlatformFilter = sink.readEnum()
            psCrossplayPlatformFilter = sink.readEnum()
            claimedDLCs = sink.readList()
            hasUserChangedName = sink.readBoolean()
            isUserNameForced = sink.readBoolean()
            offlinePurchasedAmounts = sink.readMap()
        }
        if (sink newer "24.6.0") {
            adsReplacementRemaining = sink.readMap()
            resetAdsReplacementTimepoint = sink.readInstant()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeString(username)
        sink.writeObject(gameSettings)
        sink.writeInt(regionChangeCount)
        sink.writeByte(userAge)
        sink.writeInstant(userAgeTimeBase)
        sink.writeEnum(userGender)
        sink.writeOptional(alias)
        sink.writeOptional(deviceCountry)
        sink.writeBoolean(claimedEnableSystemNotificationsReward)
        sink.writeOptional(channelName)
        if (sink older "24.6.0") {
            sink.writeOptional(privacyPolicy)
        } else {
            sink.writeByte(privacyPolicy?.value ?: 0)
        }
        if (sink older "24.0.0") {
            sink.writeBoolean(underageDisclaimerShown)
        }
        if (sink older "24.0.0") {
            sink.writeOptional(platform)
        } else {
            sink.writeObject(platform ?: RInt())
        }
        if (sink older "24.6.0") {
            sink.writeOptional(xboxLiveOnlyEnabled)
        }
        if (sink older "24.0.0") {
            sink.writeOptional(uniqueUserNameChangeCount)
        }
        if (sink newer "24.0.0") {
            sink.writeList(hiddenEndRaceAdsOfferIds)
            sink.writeInstant(lastLoginTimestamp)
            sink.writeInstant(lastAdWatchedTimestamp)
            sink.writeBoolean(underageDisclaimerShown)
            sink.writeEnum(xboxCrossplayPlatformFilter)
            sink.writeEnum(psCrossplayPlatformFilter)
            sink.writeList(claimedDLCs)
            sink.writeBoolean(hasUserChangedName)
            sink.writeBoolean(isUserNameForced)
            sink.writeMap(offlinePurchasedAmounts)
        }
        if (sink newer "24.6.0") {
            sink.writeMap(adsReplacementRemaining)
            sink.writeInstant(resetAdsReplacementTimepoint)
        }
    }
}