package moe.crx.roadblock.rpc.base

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.ActionRequestHeader

@Serializable
open class RequestPacket(
    var magic: UByte = MAGIC,
    var header: ActionRequestHeader = ActionRequestHeader(),
    @FromVersion("24.0.0")
    var modernType: UShort = 0u,
    @UntilVersion("24.0.0")
    var legacyType: UByte = 0u,
) {
    companion object {
        const val MAGIC: UByte = 3u
    }

    init {
        check(magic == MAGIC)
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