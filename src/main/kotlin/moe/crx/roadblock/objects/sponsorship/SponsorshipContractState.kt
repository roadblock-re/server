package moe.crx.roadblock.objects.sponsorship

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.SponsorshipContractId

class SponsorshipContractState : RObject {

    var contractId: SponsorshipContractId = 0
    var loginCount: Int = 0
    var startTimestamp: Instant = now()
    var nextDailyLoginTimestamp: Instant = now()

    override fun read(sink: InputSink) {
        contractId = sink.readShort()
        loginCount = sink.readInt()
        startTimestamp = sink.readInstant()
        nextDailyLoginTimestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(contractId)
        sink.writeInt(loginCount)
        sink.writeInstant(startTimestamp)
        sink.writeInstant(nextDailyLoginTimestamp)
    }
}