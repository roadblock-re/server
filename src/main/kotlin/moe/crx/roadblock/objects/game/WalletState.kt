package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class WalletState : RObject {

    // TODO FIXME Review this class in all known game versions

    var currentBalance: Int = 0
    var currentType: Int = 0
    var eventId: RString? = null // 3.9+ only (also maybe 3.8)

    override fun read(sink: InputSink) {
        if (sink older "45.0.0") {
            currentBalance = sink.readInt()
            currentType = sink.readInt()
        } else {
            currentType = sink.readInt()
            currentBalance = sink.readInt()
        }
        if (sink older "24.6.0") {
            eventId = sink.readOptional()
        }
    }

    override fun write(sink: OutputSink) {
        if (sink older "45.0.0") {
            sink.writeInt(currentBalance)
            sink.writeInt(currentType)
        } else {
            sink.writeInt(currentType)
            sink.writeInt(currentBalance)
        }
        if (sink older "24.6.0") {
            sink.writeOptional(eventId)
        }
    }
}