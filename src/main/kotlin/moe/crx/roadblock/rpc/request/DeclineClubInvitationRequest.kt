package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.rpc.base.RequestPacket

class DeclineClubInvitationRequest : RequestPacket() {

    var invitationIds: List<RString> = listOf()

    override fun read(sink: InputSink) {
        super.read(sink)
        invitationIds = sink.readList()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeList(invitationIds)
    }
}