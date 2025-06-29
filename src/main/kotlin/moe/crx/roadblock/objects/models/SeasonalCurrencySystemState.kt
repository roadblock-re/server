package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RFloat
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.seasonalcurrency.SeasonalCurrencyEventData

class SeasonalCurrencySystemState : RObject {

    var optCurrentEventData: SeasonalCurrencyEventData? = null
    var convertedEvents: List<RString> = listOf()
    var optConversionRateBoost: RFloat? = null

    override fun read(sink: InputSink) {
        optCurrentEventData = sink.readOptional()
        convertedEvents = sink.readList()
        optConversionRateBoost = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(optCurrentEventData)
        sink.writeList(convertedEvents)
        sink.writeOptional(optConversionRateBoost)
    }
}