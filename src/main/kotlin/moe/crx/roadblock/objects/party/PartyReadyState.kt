package moe.crx.roadblock.objects.party

import moe.crx.roadblock.game.serialization.ByteEnum

@ByteEnum
enum class PartyReadyState {
    NotReady,
    Ready,
    Racing,
}