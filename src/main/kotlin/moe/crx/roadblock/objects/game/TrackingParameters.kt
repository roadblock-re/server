package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class TrackingParameters : RObject {

    var vendorId: String = ""
    var advertisingId: RString? = null
    var anonymousId: RString? = null
    var gdId: RString? = null
    var gameId: Int = 0
    var gameVersion: String = ""
    var platform: String = ""

    override fun read(sink: InputSink) {
        vendorId = sink.readString()
        advertisingId = sink.readOptional()
        anonymousId = sink.readOptional()
        gdId = sink.readOptional()
        gameId = sink.readInt()
        gameVersion = sink.readString()
        platform = sink.readString()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(vendorId)
        sink.writeOptional(advertisingId)
        sink.writeOptional(anonymousId)
        sink.writeOptional(gdId)
        sink.writeInt(gameId)
        sink.writeString(gameVersion)
        sink.writeString(platform)
    }
}