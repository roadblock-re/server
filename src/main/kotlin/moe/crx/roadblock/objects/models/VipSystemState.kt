package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject

class VipSystemState : RObject {

    var vipExperience: Int = 0
    var vipBlackMarketState: VipBlackMarketState = VipBlackMarketState()
    var purchasedVIPBundleAtVIPLevel: List<RByte> = listOf()
    var nextDailyGiftRestore: Instant = now()

    override fun read(sink: InputSink) {
        vipExperience = sink.readInt()
        vipBlackMarketState = sink.readObject()
        purchasedVIPBundleAtVIPLevel = sink.readList()
        nextDailyGiftRestore = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(vipExperience)
        sink.writeObject(vipBlackMarketState)
        sink.writeList(purchasedVIPBundleAtVIPLevel)
        sink.writeInstant(nextDailyGiftRestore)
    }
}
