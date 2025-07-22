package moe.crx.roadblock.objects.club

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class ClubInvitation : RObject {

    var ids: List<RString> = listOf() // TODO List of what exactly?
    var club: ClubData = ClubData()
    var timestamp: Instant = now()
    var senderCredentials: List<RString> = listOf() // TODO List of what exactly?
    var senderRank: Int = 0

    override fun read(sink: InputSink) {
        ids = sink.readList()
        club = sink.readObject()
        timestamp = sink.readInstant()
        senderCredentials = sink.readList()
        senderRank = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(ids)
        sink.writeObject(club)
        sink.writeInstant(timestamp)
        sink.writeList(senderCredentials)
        sink.writeInt(senderRank)
    }

}
