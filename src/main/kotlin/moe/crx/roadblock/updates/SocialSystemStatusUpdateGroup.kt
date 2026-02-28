package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import kotlin.reflect.KClass

@Serializable
class SocialSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<SocialSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out SocialSystemStatusUpdateGroup>> {
            TODO()
        }
    }
}