package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.*
import moe.crx.roadblock.objects.game.GameSettings

class MiscellaneousState : RObject {

    var username: String = ""
    var gameSettings: GameSettings = GameSettings()
    var regionChangeCount: Int = 0
    var userAge: Byte = 0
    var userAgeTimeBase: Instant = now()
    var userGender: Int = 0
    var alias: RString? = null
    var deviceCountry: RString? = null
    var claimedEnableSystemNotificationsReward: Boolean = false
    var channelName: RString? = null
    var isGDPRCompliant: RBoolean? = null
    var consentNoticeShown: Boolean = false
    var platform: RByte? = null // TODO Is it RInt?
    var xboxLiveOnlyEnabled: RBoolean? = null
    var uniqueUserNameChangeCount: RInt? = null

    override fun read(sink: InputSink) {
        username = sink.readString()
        gameSettings = sink.readObject()
        regionChangeCount = sink.readInt()
        userAge = sink.readByte()
        userAgeTimeBase = sink.readInstant()
        userGender = sink.readInt()
        alias = sink.readOptional()
        deviceCountry = sink.readOptional()
        claimedEnableSystemNotificationsReward = sink.readBoolean()
        channelName = sink.readOptional()
        isGDPRCompliant = sink.readOptional()
        consentNoticeShown = sink.readBoolean()
        platform = sink.readOptional()
        xboxLiveOnlyEnabled = sink.readOptional()
        uniqueUserNameChangeCount = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(username)
        sink.writeObject(gameSettings)
        sink.writeInt(regionChangeCount)
        sink.writeByte(userAge)
        sink.writeInstant(userAgeTimeBase)
        sink.writeInt(userGender)
        sink.writeOptional(alias)
        sink.writeOptional(deviceCountry)
        sink.writeBoolean(claimedEnableSystemNotificationsReward)
        sink.writeOptional(channelName)
        sink.writeOptional(isGDPRCompliant)
        sink.writeBoolean(consentNoticeShown)
        sink.writeOptional(platform)
        sink.writeOptional(xboxLiveOnlyEnabled)
        sink.writeOptional(uniqueUserNameChangeCount)
    }
}