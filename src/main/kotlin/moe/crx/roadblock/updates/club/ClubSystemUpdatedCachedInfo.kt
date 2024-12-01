package moe.crx.roadblock.updates.club

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.club.CachedClubInfo

class ClubSystemUpdatedCachedInfo : RObject {

    var cachedClubInfo: CachedClubInfo = CachedClubInfo()

    override fun read(sink: InputSink) {
        cachedClubInfo = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(cachedClubInfo)
    }
}