package moe.crx.roadblock.objects.game

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.*

class OnlineUserData : RObject {

    var federationCredential: Credentials = Credentials()
    var timestamp: RInstant? = null
    var joinedTimestamp: RInstant? = null
    var name: RString? = null
    var alias: RString? = null
    var reputationLevel: RInt? = null
    var garageLevel: RShort? = null
    var multiplayerWorldEventId: RString? = null
    var multiplayerWorldTierInfo: MultiplayerSeriesTierInfo? = null
    var multiplayerPlayerElo: RFloat? = null
    var clubId: RString? = null
    var clubRank: RInt? = null //ClubMemberRank
    var isUnderAge: RBoolean? = null
    var garageValue: RInt? = null
    var platform: RByte? = null
    var platformUsername: RString? = null
    var allCredentials: CredentialsList? = null
    var isOnline: RBoolean? = null

    override fun read(sink: InputSink) {
        federationCredential = sink.readObject()
        timestamp = sink.readOptional()
        joinedTimestamp = sink.readOptional()
        name = sink.readOptional()
        alias = sink.readOptional()
        reputationLevel = sink.readOptional()
        garageLevel = sink.readOptional()
        multiplayerWorldEventId = sink.readOptional()
        multiplayerWorldTierInfo = sink.readOptional()
        multiplayerPlayerElo = sink.readOptional()
        clubId = sink.readOptional()
        clubRank = sink.readOptional()
        isUnderAge = sink.readOptional()
        garageValue = sink.readOptional()
        platform = sink.readOptional()
        platformUsername = sink.readOptional()
        allCredentials = sink.readOptional()
        isOnline = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(federationCredential)
        sink.writeOptional(timestamp)
        sink.writeOptional(joinedTimestamp)
        sink.writeOptional(name)
        sink.writeOptional(alias)
        sink.writeOptional(reputationLevel)
        sink.writeOptional(garageLevel)
        sink.writeOptional(multiplayerWorldEventId)
        sink.writeOptional(multiplayerWorldTierInfo)
        sink.writeOptional(multiplayerPlayerElo)
        sink.writeOptional(clubId)
        sink.writeOptional(clubRank)
        sink.writeOptional(isUnderAge)
        sink.writeOptional(garageValue)
        sink.writeOptional(platform)
        sink.writeOptional(platformUsername)
        sink.writeOptional(allCredentials)
        sink.writeOptional(isOnline)
    }
}