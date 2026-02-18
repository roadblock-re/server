package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.io.VariantIO.readVariant
import moe.crx.roadblock.game.io.VariantIO.writeVariant
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.base.RVoid
import moe.crx.roadblock.objects.game.AsphaltProductID
import moe.crx.roadblock.objects.game.IAPPriceData
import moe.crx.roadblock.objects.game.ItemToPurchase
import moe.crx.roadblock.objects.game.PriceComponent
import moe.crx.roadblock.rpc.base.RequestPacket

class PurchaseOfflineProductRequest : RequestPacket() {

    var productId: AsphaltProductID = ""
    var priceInfo: RObject = RVoid()
    var items: List<ItemToPurchase> = listOf()
    var eventId: RString? = null //CalendarEventId

    override fun read(sink: InputSink) {
        super.read(sink)
        productId = sink.readString()
        priceInfo = sink.readVariant(
            PriceComponent::class,
            IAPPriceData::class
        )
        items = sink.readList()
        eventId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(productId)
        sink.writeVariant(
            priceInfo,
            PriceComponent::class,
            IAPPriceData::class
        )
        sink.writeList(items)
        sink.writeOptional(eventId)
    }
}