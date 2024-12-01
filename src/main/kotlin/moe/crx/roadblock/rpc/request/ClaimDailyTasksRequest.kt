package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.rpc.base.RequestPacket

class ClaimDailyTasksRequest : RequestPacket() {

    var tasksToClaim: List<RByte> = listOf() //DailyTaskType
    var willClaimMainTask: Boolean = false

    override fun read(sink: InputSink) {
        super.read(sink)
        tasksToClaim = sink.readList()
        willClaimMainTask = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeList(tasksToClaim)
        sink.writeBoolean(willClaimMainTask)
    }
}