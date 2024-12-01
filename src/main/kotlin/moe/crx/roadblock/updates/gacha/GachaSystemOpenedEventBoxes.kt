package moe.crx.roadblock.updates.gacha

import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.GachaId

class GachaSystemOpenedEventBoxes : RObject {

    var eventId: CalendarEventId = ""
    var gachaId: GachaId = 0
    var oldOpenedCount: Int = 0
    var newOpenedCount: Int = 0
    var hasFeaturedReward: Boolean = false

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        gachaId = sink.readShort()
        oldOpenedCount = sink.readInt()
        newOpenedCount = sink.readInt()
        hasFeaturedReward = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeShort(gachaId)
        sink.writeInt(oldOpenedCount)
        sink.writeInt(newOpenedCount)
        sink.writeBoolean(hasFeaturedReward)
    }
}