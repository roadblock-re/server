package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class RefreshClubStateResponse : UpdatesQueueWithRootReactionsResponse() {

    var clubData: ClubData? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        clubData = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeOptional(clubData)
    }
}