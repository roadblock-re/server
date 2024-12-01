package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class ClaimGiftResponse : UpdatesQueueWithRootReactionsResponse() {

    var doesResetProfile: Boolean = false
    var doesResetCar: Boolean = false
    var doesResetAge: Boolean = false
    var doesResetAlias: Boolean = false
    var doesResetCompliancyCountry: Boolean = false
    var doesUnlockLegendFundTier: Boolean = false
    var resetCurrencyType: RInt? = null // CurrencyType
    var isSilent: Boolean = false

    override fun read(sink: InputSink) {
        super.read(sink)
        doesResetProfile = sink.readBoolean()
        doesResetCar = sink.readBoolean()
        doesResetAge = sink.readBoolean()
        doesResetAlias = sink.readBoolean()
        doesResetCompliancyCountry = sink.readBoolean()
        doesUnlockLegendFundTier = sink.readBoolean()
        resetCurrencyType = sink.readOptional()
        isSilent = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeBoolean(doesResetProfile)
        sink.writeBoolean(doesResetCar)
        sink.writeBoolean(doesResetAge)
        sink.writeBoolean(doesResetAlias)
        sink.writeBoolean(doesResetCompliancyCountry)
        sink.writeBoolean(doesUnlockLegendFundTier)
        sink.writeOptional(resetCurrencyType)
        sink.writeBoolean(isSilent)
    }
}