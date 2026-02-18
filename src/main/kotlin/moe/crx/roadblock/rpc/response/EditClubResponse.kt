package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.club.ClubData
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class EditClubResponse : UpdatesQueueWithRootReactionsResponse() {

    var clubData: ClubData = ClubData()

    override fun read(sink: InputSink) {
        super.read(sink)
        clubData = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(clubData)
    }
}