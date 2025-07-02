package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum8
import moe.crx.roadblock.io.EnumIO.writeEnum8
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.game.AccountLinkingRequestOrigin
import moe.crx.roadblock.objects.game.Credentials
import moe.crx.roadblock.rpc.base.RequestPacket

class LinkAccountWithCredentialRequest : RequestPacket() {

    var targetAccountCredential: Credentials = Credentials()
    var ignoreLinkingIfAuthorityTypesExist: List<RInt> = listOf() // CredentialAuthority
    var requestOrigin: AccountLinkingRequestOrigin = AccountLinkingRequestOrigin.InitialLogin

    override fun read(sink: InputSink) {
        super.read(sink)
        targetAccountCredential = sink.readObject()
        ignoreLinkingIfAuthorityTypesExist = sink.readList()
        requestOrigin = sink.readEnum8()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(targetAccountCredential)
        sink.writeList(ignoreLinkingIfAuthorityTypesExist)
        sink.writeEnum8(requestOrigin)
    }
}