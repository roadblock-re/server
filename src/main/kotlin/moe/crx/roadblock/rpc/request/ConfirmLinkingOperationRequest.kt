package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum8
import moe.crx.roadblock.io.EnumIO.writeEnum8
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.AccountLinkingRequestOrigin
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket

class ConfirmLinkingOperationRequest : RequestPacket() {

    var accountToLinkCredential: Credentials = Credentials()
    var keepCurrentAccountProgress: Boolean = false
    var requestOrigin: AccountLinkingRequestOrigin = AccountLinkingRequestOrigin.InitialLogin

    override fun read(sink: InputSink) {
        super.read(sink)
        accountToLinkCredential = sink.readObject()
        keepCurrentAccountProgress = sink.readBoolean()
        requestOrigin = sink.readEnum8()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(accountToLinkCredential)
        sink.writeBoolean(keepCurrentAccountProgress)
        sink.writeEnum8(requestOrigin)
    }
}