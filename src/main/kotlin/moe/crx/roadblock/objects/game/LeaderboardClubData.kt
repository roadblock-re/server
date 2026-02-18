package moe.crx.roadblock.objects.game

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.club.ClubLogo

class LeaderboardClubData : RObject {

    var id: ClubId = ""
    var timestamp: Instant = now()
    var name: String = ""
    var logo: ClubLogo = ClubLogo()

    //var isUgcValidated: RBoolean? = null
    var lastEditor: LastEditorData? = null

    override fun read(sink: InputSink) {
        id = sink.readString()
        timestamp = sink.readInstant()
        name = sink.readString()
        logo = sink.readObject()
        lastEditor = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(id)
        sink.writeInstant(timestamp)
        sink.writeString(name)
        sink.writeObject(logo)
        sink.writeOptional(lastEditor)
    }
}