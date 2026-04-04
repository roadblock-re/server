package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import kotlin.reflect.KClass

@Serializable
sealed class SocialSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<SocialSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out SocialSystemStatusUpdateGroup>> =
            buildList {
                add(SocialSystemAllowReceivingFriendRequestsChanged::class)
            }
    }
}

@Serializable
data class SocialSystemAllowReceivingFriendRequestsChanged(
    var newVault: Boolean,
) : SocialSystemStatusUpdateGroup()