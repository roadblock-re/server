package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.ClubId
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket

class LeaveClubRequest : RequestPacket() {

    var clubId: ClubId = ""
    var newManagerCredential: Credentials? = null
    var newManagerName: String = ""
    var newManagerPreviousRank: Int = 0
    var debugSuffix: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        clubId = sink.readString()
        newManagerCredential = sink.readOptional()
        newManagerName = sink.readString()
        newManagerPreviousRank = sink.readInt()
        debugSuffix = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(clubId)
        sink.writeOptional(newManagerCredential)
        sink.writeString(newManagerName)
        sink.writeInt(newManagerPreviousRank)
        sink.writeString(debugSuffix)
    }
}