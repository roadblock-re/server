package moe.crx.roadblock.rpc.base

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.ServerError

@Serializable
open class PushMessagePacket(
    @FromVersion("24.0.0")
    var magic: UByte = MAGIC,
    @UntilVersion("24.0.0")
    var legacyMagic: UByte = LEGACY_MAGIC,
    @FromVersion("24.0.0")
    var modernType: UShort = 0u,
    @UntilVersion("24.0.0")
    var legacyType: UByte = 0u,
    var error: ServerError? = null
) {
    companion object {
        const val MAGIC: UByte = 10u
        const val LEGACY_MAGIC: UByte = 6u
    }

    init {
        check(magic == MAGIC)
        check(legacyMagic == LEGACY_MAGIC)
    }

    var type: UShort
        get() = if (modernType != 0u.toUShort()) {
            modernType
        } else {
            legacyType.toUShort()
        }
        set(value) {
            modernType = value
            legacyType = value.toUByte()
        }
}