package moe.crx.roadblock.updates.tle

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.tle.RankTLEventClaimState
import moe.crx.roadblock.objects.tle.TLEventId

class TLEventsSystemClaimRankDataChanged : RObject {

    var eventId: TLEventId = TLEventId()
    var state: RankTLEventClaimState = RankTLEventClaimState.Unknown
    var rankRewardIdx: Byte = 0

    override fun read(sink: InputSink) {
        eventId = sink.readObject()
        state = sink.readEnum()
        rankRewardIdx = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(eventId)
        sink.writeEnum(state)
        sink.writeByte(rankRewardIdx)
    }
}