package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import kotlin.reflect.KClass

@Serializable
class GoldenChestSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<GoldenChestSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out GoldenChestSystemStatusUpdateGroup>> {
            TODO("Not yet implemented")
        }
    }
}