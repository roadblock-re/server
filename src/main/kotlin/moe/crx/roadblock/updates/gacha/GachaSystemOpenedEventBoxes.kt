package moe.crx.roadblock.updates.gacha

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.gacha.GachaId
import moe.crx.roadblock.objects.game.CalendarEventId

class GachaSystemOpenedEventBoxes : RObject {

    var eventId: CalendarEventId = ""
    var gachaId: GachaId = GachaId()
    var oldOpenedCount: Int = 0
    var newOpenedCount: Int = 0
    var hasFeaturedReward: Boolean = false

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        gachaId = sink.readObject()
        oldOpenedCount = sink.readInt()
        newOpenedCount = sink.readInt()
        hasFeaturedReward = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeObject(gachaId)
        sink.writeInt(oldOpenedCount)
        sink.writeInt(newOpenedCount)
        sink.writeBoolean(hasFeaturedReward)
    }
}