package moe.crx.roadblock.objects.seasonpass

import moe.crx.roadblock.io.EnumIO.readEnum8
import moe.crx.roadblock.io.EnumIO.writeEnum8
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class MissionData : RObject {

    var progress: MissionProgress = MissionProgress()
    var state: SeasonPassMissionState = SeasonPassMissionState.Ready

    override fun read(sink: InputSink) {
        progress = sink.readObject()
        state = sink.readEnum8()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(progress)
        sink.writeEnum8(state)
    }
}