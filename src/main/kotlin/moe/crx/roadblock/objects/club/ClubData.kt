package moe.crx.roadblock.objects.club

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RShort
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.ClubId
import moe.crx.roadblock.objects.game.Credentials

class ClubData : RObject {

    var id: ClubId = ""
    var tag: RString? = null
    var name: RString? = null
    var motto: RString? = null
    var logo: ClubLogo? = null
    var regionId: RShort? = null
    var membershipType: RInt? = null
    var memberCount: RInt? = null
    var managerCredential: Credentials? = null
    var clubSeasonEventReputations: Map<RString, RInt> = mapOf()
    var recommendationFilter: RString? = null
    var clubWarsEventParticipations: Map<RString, ClubWarsEventParticipation> = mapOf()

    override fun read(sink: InputSink) {
        id = sink.readString()
        tag = sink.readOptional()
        name = sink.readOptional()
        motto = sink.readOptional()
        logo = sink.readOptional()
        tag = sink.readOptional()
        regionId = sink.readOptional()
        membershipType = sink.readOptional()
        memberCount = sink.readOptional()
        managerCredential = sink.readOptional()
        clubSeasonEventReputations = sink.readMap()
        recommendationFilter = sink.readOptional()
        clubWarsEventParticipations = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(id)
        sink.writeOptional(tag)
        sink.writeOptional(name)
        sink.writeOptional(motto)
        sink.writeOptional(logo)
        sink.writeOptional(tag)
        sink.writeOptional(regionId)
        sink.writeOptional(membershipType)
        sink.writeOptional(memberCount)
        sink.writeOptional(managerCredential)
        sink.writeMap(clubSeasonEventReputations)
        sink.writeOptional(recommendationFilter)
        sink.writeMap(clubWarsEventParticipations)
    }
}