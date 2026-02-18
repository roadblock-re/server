package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.InboxMessageId
import moe.crx.roadblock.objects.game.InboxProviderType
import moe.crx.roadblock.rpc.base.RequestPacket

class InboxMarkAsReadRequest : RequestPacket() {

    var messageId: InboxMessageId = ""
    var providerType: InboxProviderType = InboxProviderType.FakeNews

    override fun read(sink: InputSink) {
        super.read(sink)
        messageId = sink.readString()
        providerType = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(messageId)
        sink.writeEnum(providerType)
    }
}