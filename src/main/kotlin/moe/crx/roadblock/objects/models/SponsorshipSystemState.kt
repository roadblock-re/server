package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RShort
import moe.crx.roadblock.objects.sponsorship.SponsorshipContractState

class SponsorshipSystemState : RObject {

    var optActiveContract: SponsorshipContractState? = null
    var completedContractIds: Map<RShort, RInt> = mapOf()

    override fun read(sink: InputSink) {
        optActiveContract = sink.readOptional()
        completedContractIds = sink.readMap()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(optActiveContract)
        sink.writeMap(completedContractIds)
    }
}