package moe.crx.roadblock.objects.seasonpass

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.CalendarEventId

class SeasonPassPersistentState : RObject {

    var eventId: CalendarEventId = ""
    var id: Int = 0
    var currentExperience: Int = 0
    var activeLegendPassType: RByte? = null
    var discountForNextSeason: Byte = 0
    var transactionId: RString? = null

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        id = sink.readInt()
        currentExperience = sink.readInt()
        activeLegendPassType = sink.readOptional()
        discountForNextSeason = sink.readByte()
        if (sink newer "24.0.0") {
            transactionId = sink.readOptional()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeInt(id)
        sink.writeInt(currentExperience)
        sink.writeOptional(activeLegendPassType)
        sink.writeByte(discountForNextSeason)
        if (sink newer "24.0.0") {
            sink.writeOptional(transactionId)
        }
    }

}