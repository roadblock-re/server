package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.SeasonId
import moe.crx.roadblock.rpc.base.RequestPacket

class CompleteCareerSeasonCheatRequest : RequestPacket() {

    var seasonId: SeasonId = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        seasonId = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(seasonId)
    }
}