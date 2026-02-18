package moe.crx.roadblock.objects.mpchallenges

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CurrencyType
import moe.crx.roadblock.objects.game.Money

class MultiplayerChallengeFee : RObject {

    var currencyType: CurrencyType = CurrencyType.Credits
    var value: Money = 0

    override fun read(sink: InputSink) {
        currencyType = sink.readEnum()
        value = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(currencyType)
        sink.writeInt(value)
    }
}