package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.BlackMarketDailyRefreshes
import moe.crx.roadblock.objects.BlackMarketSlotId
import moe.crx.roadblock.objects.VipExperience
import moe.crx.roadblock.objects.models.VipBlackMarketSlot

@Serializable
sealed class VanitySystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<VanitySystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(VanitySystemStatusUpdateGroup0::class)
            add(VanitySystemStatusUpdateGroup1::class)
            add(VanitySystemStatusUpdateGroup2::class)
            add(VanitySystemStatusUpdateGroup3::class)
            add(VanitySystemStatusUpdateGroup4::class)
            add(VanitySystemStatusUpdateGroup5::class)
            add(VanitySystemStatusUpdateGroup6::class)
            add(VanitySystemStatusUpdateGroup7::class)
            add(VanitySystemStatusUpdateGroup8::class)
            add(VanitySystemStatusUpdateGroup9::class)
        }
    }
}

@Serializable
data class VanitySystemStatusUpdateGroup0(
    var nextResetTime: Instant,
) : VanitySystemStatusUpdateGroup()

@Serializable
class VanitySystemStatusUpdateGroup1 : VanitySystemStatusUpdateGroup()

@Serializable
data class VanitySystemStatusUpdateGroup2(
    var oldVIPExperience: VipExperience,
    var newVIPExperience: VipExperience,
) : VanitySystemStatusUpdateGroup()

@Serializable
data class VanitySystemStatusUpdateGroup3(
    var vipLevelPurchased: Boolean,
) : VanitySystemStatusUpdateGroup()

@Serializable
data class VanitySystemStatusUpdateGroup4(
    var slots: List<VipBlackMarketSlot>
) : VanitySystemStatusUpdateGroup()

@Serializable
data class VanitySystemStatusUpdateGroup5(
    var slot: BlackMarketSlotId,
    var oldAmount: UInt,
    var newAmount: UInt,
) : VanitySystemStatusUpdateGroup()

@Serializable
data class VanitySystemStatusUpdateGroup6(
    var oldRefreshes: BlackMarketDailyRefreshes,
    var newRefreshes: BlackMarketDailyRefreshes,
) : VanitySystemStatusUpdateGroup()

@Serializable
data class VanitySystemStatusUpdateGroup7(
    var oldTimePoint: Instant,
    var newTimePoint: Instant,
) : VanitySystemStatusUpdateGroup()

@Serializable
data class VanitySystemStatusUpdateGroup8(
    var oldTimePoint: Instant,
    var newTimePoint: Instant,
) : VanitySystemStatusUpdateGroup()

@Serializable
data class VanitySystemStatusUpdateGroup9(
    var oldVIPLevel: UByte,
    var newVIPLevel: UByte,
) : VanitySystemStatusUpdateGroup()