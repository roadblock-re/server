package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.SNSUserConflictData
import moe.crx.roadblock.rpc.base.ResponsePacket

class GetRemoteAccountConflictDataResponse : ResponsePacket() {

    var conflictData: SNSUserConflictData = SNSUserConflictData()

    override fun read(sink: InputSink) {
        super.read(sink)
        conflictData = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(conflictData)
    }
}