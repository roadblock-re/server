package moe.crx.roadblock.objects.inventory

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInstant
import moe.crx.roadblock.objects.base.RObject

class CarOverclockState : RObject {

    var optOverclockExpirationDateWithoutPass: RInstant? = null
    var optOverclockExpirationDate: RInstant? = null

    override fun read(sink: InputSink) {
        optOverclockExpirationDateWithoutPass = sink.readOptional()
        optOverclockExpirationDate = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(optOverclockExpirationDateWithoutPass)
        sink.writeOptional(optOverclockExpirationDate)
    }
}