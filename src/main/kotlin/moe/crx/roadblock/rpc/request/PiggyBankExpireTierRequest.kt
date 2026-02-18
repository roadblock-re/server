package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.PiggyBankTierId
import moe.crx.roadblock.rpc.base.RequestPacket

class PiggyBankExpireTierRequest : RequestPacket() {

    var eventId: CalendarEventId = ""
    var piggyBankTierId: PiggyBankTierId = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        eventId = sink.readString()
        piggyBankTierId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(eventId)
        sink.writeInt(piggyBankTierId)
    }
}