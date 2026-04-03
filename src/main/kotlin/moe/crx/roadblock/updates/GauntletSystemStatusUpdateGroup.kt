package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import kotlin.reflect.KClass

@Serializable
class GauntletSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<GauntletSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out GauntletSystemStatusUpdateGroup>> {
            TODO("Not yet implemented")
        }
    }
}