package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class ActivationEventData : RObject {

    var activationExpirationDate: Instant = now()
    var currency: Int = 0
    var activationBlackMarketState: ActivationBlackMarketState = ActivationBlackMarketState()
    var seenLinkedEvents: List<RString> = listOf()

    override fun read(sink: InputSink) {
        activationExpirationDate = sink.readInstant()
        currency = sink.readInt()
        activationBlackMarketState = sink.readObject()
        seenLinkedEvents = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeInstant(activationExpirationDate)
        sink.writeInt(currency)
        sink.writeObject(activationBlackMarketState)
        sink.writeList(seenLinkedEvents)
    }

}
