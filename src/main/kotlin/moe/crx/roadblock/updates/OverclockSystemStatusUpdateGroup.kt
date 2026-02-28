package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import kotlin.reflect.KClass

@Serializable
class OverclockSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<OverclockSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out OverclockSystemStatusUpdateGroup>> {
            TODO("Not yet implemented")
        }
    }
}