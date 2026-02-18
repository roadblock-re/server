package moe.crx.roadblock.objects.game

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class UserCustomizableBundleEvent : RObject {

    var purchasedBundles: List<RString> = listOf()
    var expirationDate: Instant = now()

    override fun read(sink: InputSink) {
        purchasedBundles = sink.readList()
        expirationDate = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(purchasedBundles)
        sink.writeInstant(expirationDate)
    }

}
