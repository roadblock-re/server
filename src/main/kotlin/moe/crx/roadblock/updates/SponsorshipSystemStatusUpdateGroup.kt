package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import kotlin.reflect.KClass

@Serializable
class SponsorshipSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<SponsorshipSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out SponsorshipSystemStatusUpdateGroup>> {
            TODO()
        }
    }
}