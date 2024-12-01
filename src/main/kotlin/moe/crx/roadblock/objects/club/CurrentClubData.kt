package moe.crx.roadblock.objects.club

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class CurrentClubData : RObject {

    var id: String = ""
    var joinedEventId: String = ""
    var originalReputation: Int = 0
    var cachedClubInfo: CachedClubInfo = CachedClubInfo()

    override fun read(sink: InputSink) {
        id = sink.readString()
        joinedEventId = sink.readString()
        originalReputation = sink.readInt()
        cachedClubInfo = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(id)
        sink.writeString(joinedEventId)
        sink.writeInt(originalReputation)
        sink.writeObject(cachedClubInfo)
    }

}