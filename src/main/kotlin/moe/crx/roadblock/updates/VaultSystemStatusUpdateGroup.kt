package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import kotlin.reflect.KClass

@Serializable
class VaultSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<VaultSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out VaultSystemStatusUpdateGroup>> {
            TODO()
        }
    }
}