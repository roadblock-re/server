package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.tle.TLEventId
import moe.crx.roadblock.rpc.base.RequestPacket

class TLEventClaimClubRewardRequest : RequestPacket() {

    var tlEventId: TLEventId = TLEventId()
    var rewardIdx: Byte = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        tlEventId = sink.readObject()
        rewardIdx = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(tlEventId)
        sink.writeByte(rewardIdx)
    }
}