package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.ClubId
import moe.crx.roadblock.objects.game.ClubRequestId
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.objects.game.RejectRequestMode
import moe.crx.roadblock.rpc.base.RequestPacket

class RejectClubRequestRequest : RequestPacket() {

    var clubId: ClubId = ""
    var requestId: ClubRequestId = ""
    var requesterCredentials: Credentials = Credentials()
    var requester: String = ""
    var rejectionMode: RejectRequestMode = RejectRequestMode.OnlyOnce

    override fun read(sink: InputSink) {
        super.read(sink)
        clubId = sink.readString()
        requestId = sink.readString()
        requesterCredentials = sink.readObject()
        requester = sink.readString()
        rejectionMode = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(clubId)
        sink.writeString(requestId)
        sink.writeObject(requesterCredentials)
        sink.writeString(requester)
        sink.writeEnum(rejectionMode)
    }
}