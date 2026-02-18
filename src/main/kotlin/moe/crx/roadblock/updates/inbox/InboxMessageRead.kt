package moe.crx.roadblock.updates.inbox

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.InboxMessageId
import moe.crx.roadblock.objects.game.InboxProviderType

class InboxMessageRead : RObject {

    var messageId: InboxMessageId = ""
    var providerType: InboxProviderType = InboxProviderType.FakeNews

    override fun read(sink: InputSink) {
        messageId = sink.readString()
        providerType = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(messageId)
        sink.writeEnum(providerType)
    }
}