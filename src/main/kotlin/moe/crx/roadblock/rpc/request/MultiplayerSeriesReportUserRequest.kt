package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.rpc.base.RequestPacket

class MultiplayerSeriesReportUserRequest : RequestPacket() {

    var raceToken: RaceToken = 0
    var reportedCredential: Credentials = Credentials()
    var reasons: Byte = 0
    var moreDetails: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        raceToken = sink.readInt()
        reportedCredential = sink.readObject()
        reasons = sink.readByte()
        moreDetails = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceToken)
        sink.writeObject(reportedCredential)
        sink.writeByte(reasons)
        sink.writeString(moreDetails)
    }
}