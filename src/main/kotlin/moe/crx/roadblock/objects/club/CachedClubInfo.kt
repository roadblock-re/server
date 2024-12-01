package moe.crx.roadblock.objects.club

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class CachedClubInfo : RObject {

    var creationTimestamp: Instant = now()
    var logo: ClubLogo = ClubLogo()
    var name: String = ""
    var membersCount: Int = 0
    var membershipType: Int = 0
    var memberRank: Int = 0
    var motto: String = ""
    //var regionId: Short = 0
    //var isUGCValidated: Boolean = false

    override fun read(sink: InputSink) {
        creationTimestamp = sink.readInstant()
        logo = sink.readObject()
        name = sink.readString()
        membersCount = sink.readInt()
        membershipType = sink.readInt()
        memberRank = sink.readInt()
        motto = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(creationTimestamp)
        sink.writeObject(logo)
        sink.writeString(name)
        sink.writeInt(membersCount)
        sink.writeInt(membershipType)
        sink.writeInt(memberRank)
        sink.writeString(motto)
    }
}