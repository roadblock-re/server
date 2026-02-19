package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant

// TODO
@Serializable
sealed class MessageItem {
    companion object : Variant<MessageItem> {
        override fun variants(version: SerializationVersion) = buildList {
            add(MessageItem0::class)
            add(MessageItem1::class)
            add(MessageItem2::class)
            add(MessageItem3::class)
            add(MessageItem4::class)
            add(MessageItem5::class)
            add(MessageItem6::class)
            add(MessageItem7::class)
            add(MessageItem8::class)
            add(MessageItem9::class)
            add(MessageItem10::class)
            add(MessageItem11::class)
            add(MessageItem12::class)
            add(MessageItem13::class)
            add(MessageItem14::class)
            add(MessageItem15::class)
            add(MessageItem16::class)
            add(MessageItem17::class)
            add(MessageItem18::class)
            add(MessageItem19::class)
            add(MessageItem20::class)
            add(MessageItem21::class)
            add(MessageItem22::class)
            add(MessageItem23::class)
            add(MessageItem24::class)
            add(MessageItem25::class)
        }
    }

    @Serializable
    class MessageItem0 : MessageItem()

    @Serializable
    class MessageItem1 : MessageItem()

    @Serializable
    class MessageItem2 : MessageItem()

    @Serializable
    class MessageItem3 : MessageItem()

    @Serializable
    class MessageItem4 : MessageItem()

    @Serializable
    class MessageItem5 : MessageItem()

    @Serializable
    class MessageItem6 : MessageItem()

    @Serializable
    class MessageItem7 : MessageItem()

    @Serializable
    class MessageItem8 : MessageItem()

    @Serializable
    class MessageItem9 : MessageItem()

    @Serializable
    class MessageItem10 : MessageItem()

    @Serializable
    class MessageItem11 : MessageItem()

    @Serializable
    class MessageItem12 : MessageItem()

    @Serializable
    class MessageItem13 : MessageItem()

    @Serializable
    class MessageItem14 : MessageItem()

    @Serializable
    class MessageItem15 : MessageItem()

    @Serializable
    class MessageItem16 : MessageItem()

    @Serializable
    class MessageItem17 : MessageItem()

    @Serializable
    class MessageItem18 : MessageItem()

    @Serializable
    class MessageItem19 : MessageItem()

    @Serializable
    class MessageItem20 : MessageItem()

    @Serializable
    class MessageItem21 : MessageItem()

    @Serializable
    class MessageItem22 : MessageItem()

    @Serializable
    class MessageItem23 : MessageItem()

    @Serializable
    class MessageItem24 : MessageItem()

    @Serializable
    class MessageItem25 : MessageItem()

    @Serializable
    class MessageItem26 : MessageItem()
}