package moe.crx.roadblock.rpc.base

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.ServerError

@Serializable
data class ReconnectionResponse(
    var magic: UByte = MAGIC,
    var error: ServerError?,
    var lastActionId: UInt,
    var lastCommittedActionId: UInt,
) {
    companion object {
        const val MAGIC: UByte = 2u
    }

    init {
        check(magic == MAGIC)
    }
}