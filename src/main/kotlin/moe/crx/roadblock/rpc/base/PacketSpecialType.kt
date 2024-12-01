package moe.crx.roadblock.rpc.base

enum class PacketSpecialType(val byteValue: Byte) {
    NIL(0x00),
    ONE(0x01),
    FIVE(0x05),
    SIX(0x06),
    SEVEN(0x07),
    NINE(0x09),
    TEN(0x0A);

    companion object {
        fun Byte.toPacketSpecialType(): PacketSpecialType? =
            PacketSpecialType.entries.firstOrNull { it.byteValue == this }
    }
}