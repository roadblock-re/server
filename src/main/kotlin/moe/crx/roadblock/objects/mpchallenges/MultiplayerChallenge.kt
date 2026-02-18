package moe.crx.roadblock.objects.mpchallenges

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MultiplayerChallenge : RObject {

    var victories: Byte = 0
    var defeats: Byte = 0
    var revives: Byte = 0
    var participationState: Int = 0
    var seasonPassFreeEntryConsumed: Boolean = false
    var revealedSponsorsStep: Byte = 0
    var selectedSponsor: Int = 0
    var sponsorsSeed: Int = 0
    var cooldownEnd: Instant = now()
    var victoriesWhenRevived: Byte = 0
    var forceQuarantine: Boolean = false

    override fun read(sink: InputSink) {
        victories = sink.readByte()
        defeats = sink.readByte()
        revives = sink.readByte()
        participationState = sink.readInt()
        seasonPassFreeEntryConsumed = sink.readBoolean()
        revealedSponsorsStep = sink.readByte()
        selectedSponsor = sink.readInt()
        sponsorsSeed = sink.readInt()
        cooldownEnd = sink.readInstant()
        victoriesWhenRevived = sink.readByte()
        forceQuarantine = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(victories)
        sink.writeByte(defeats)
        sink.writeByte(revives)
        sink.writeInt(participationState)
        sink.writeBoolean(seasonPassFreeEntryConsumed)
        sink.writeByte(revealedSponsorsStep)
        sink.writeInt(selectedSponsor)
        sink.writeInt(sponsorsSeed)
        sink.writeInstant(cooldownEnd)
        sink.writeByte(victoriesWhenRevived)
        sink.writeBoolean(forceQuarantine)
    }
}