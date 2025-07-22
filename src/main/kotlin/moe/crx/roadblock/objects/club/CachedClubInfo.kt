package moe.crx.roadblock.objects.club

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.ClubMemberRank

class CachedClubInfo : RObject {

    var creationTimestamp: Instant = now()
    var logo: ClubLogo = ClubLogo()
    var name: String = ""
    var membersCount: Int = 0
    var membershipType: ClubMembershipType = ClubMembershipType.Open
    var memberRank: ClubMemberRank = ClubMemberRank.Manager
    var motto: String = ""
    var isUGCValidated: Boolean = false
    var lastEditor: ClubLastEditorData? = null

    override fun read(sink: InputSink) {
        creationTimestamp = sink.readInstant()
        logo = sink.readObject()
        name = sink.readString()
        membersCount = sink.readInt()
        membershipType = sink.readEnum()
        memberRank = sink.readEnum()
        motto = sink.readString()
        if (sink newer "24.0.0" && sink older "45.0.0") {
            isUGCValidated = sink.readBoolean()
        }
        if (sink newer "45.0.0") {
            lastEditor = sink.readOptional()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(creationTimestamp)
        sink.writeObject(logo)
        sink.writeString(name)
        sink.writeInt(membersCount)
        sink.writeEnum(membershipType)
        sink.writeEnum(memberRank)
        sink.writeString(motto)
        if (sink newer "24.0.0" && sink older "45.0.0") {
            sink.writeBoolean(isUGCValidated)
        }
        if (sink newer "45.0.0") {
            sink.writeOptional(lastEditor)
        }
    }
}