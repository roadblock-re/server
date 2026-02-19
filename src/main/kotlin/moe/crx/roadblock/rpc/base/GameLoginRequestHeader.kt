package moe.crx.roadblock.rpc.base

import kotlinx.serialization.Serializable

@Serializable
open class GameLoginRequestHeader(
    var magic: UByte = MAGIC,
    var gameVersion: String = "",
) {
    companion object {
        const val MAGIC: UByte = 0u
    }

    init {
        check(magic == MAGIC)
    }
}