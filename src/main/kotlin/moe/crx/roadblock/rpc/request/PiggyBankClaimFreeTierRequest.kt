package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.PiggyBankEventId
import moe.crx.roadblock.objects.game.PiggyBankTierId
import moe.crx.roadblock.rpc.base.RequestPacket

class PiggyBankClaimFreeTierRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var piggyBankEventId: PiggyBankEventId = 0
    var piggyBankTierId: PiggyBankTierId = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        piggyBankEventId = sink.readInt()
        piggyBankTierId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeInt(piggyBankEventId)
        sink.writeInt(piggyBankTierId)
    }
}