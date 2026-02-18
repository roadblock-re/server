package moe.crx.roadblock.updates.tle

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.TLETicket

class TLEventsSystemTicketBalanceChanged : RObject {

    var oldTicketBalance: TLETicket = 0
    var newTicketBalance: TLETicket = 0
    var lastRefilledTicketTime: Instant = now()
    var maxTLETickets: TLETicket = 0

    override fun read(sink: InputSink) {
        oldTicketBalance = sink.readInt()
        newTicketBalance = sink.readInt()
        lastRefilledTicketTime = sink.readInstant()
        maxTLETickets = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(oldTicketBalance)
        sink.writeInt(newTicketBalance)
        sink.writeInstant(lastRefilledTicketTime)
        sink.writeInt(maxTLETickets)
    }
}