package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant

@Serializable
sealed class StrangePlacementUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<StrangePlacementUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(StrangePlacementUpdateGroup0::class)
        }
    }
}

@Serializable
data class StrangePlacementUpdateGroup0(
    var placement: UShort,
) : StrangePlacementUpdateGroup()