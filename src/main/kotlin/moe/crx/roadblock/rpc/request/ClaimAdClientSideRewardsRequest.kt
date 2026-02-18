package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.rpc.base.RequestPacket

class ClaimAdClientSideRewardsRequest : RequestPacket() {

    var carIdForRefill: RInt? = null // CarId
    var specialCalendarEventId: RString? = null // CalendarEventId
    var relayOfferTierId: RInt? = null // RelayOfferTierId
    var rewardName: String = ""
    var rewardAmount: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        carIdForRefill = sink.readOptional()
        specialCalendarEventId = sink.readOptional()
        relayOfferTierId = sink.readOptional()
        rewardName = sink.readString()
        rewardAmount = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeOptional(carIdForRefill)
        sink.writeOptional(specialCalendarEventId)
        sink.writeOptional(relayOfferTierId)
        sink.writeString(rewardName)
        sink.writeInt(rewardAmount)
    }
}