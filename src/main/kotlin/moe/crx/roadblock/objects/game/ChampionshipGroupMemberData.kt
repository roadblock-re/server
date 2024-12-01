package moe.crx.roadblock.objects.game

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class ChampionshipGroupMemberData : RObject {

    var federationCredential: Credentials = Credentials()
    var name: RString? = null
    var country: RInt? = null
    var timestamp: Instant = now()
    var clubData: LeaderboardClubData? = null

    override fun read(sink: InputSink) {
        federationCredential = sink.readObject()
        name = sink.readOptional()
        country = sink.readOptional()
        timestamp = sink.readInstant()
        clubData = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(federationCredential)
        sink.writeOptional(name)
        sink.writeOptional(country)
        sink.writeInstant(timestamp)
        sink.writeOptional(clubData)
    }
}