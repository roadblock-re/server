package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.*
import moe.crx.roadblock.objects.models.VaultRewardsIndexesState
import moe.crx.roadblock.objects.vault.VaultEventProgressionRewardStatus
import kotlin.reflect.KClass

@Serializable
sealed class VaultSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<VaultSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out VaultSystemStatusUpdateGroup>> =
            buildList {
                add(VaultSystemTicketBalanceChanged::class)
                add(VaultSystemSlotEventAssignedChanged::class)
                add(VaultSystemSlotStateRemoved::class)
                add(VaultSystemEventStateRemoved::class)
                add(VaultSystemLockedStateChanged::class)
                add(VaultSystemEventDurationExtended::class)
                add(VaultSystemSoloRewardsObtained::class)
                add(VaultSystemEventProgressionChanged::class)
                add(VaultSystemEventProgressionRewardsStatusChanged::class)
                add(VaultSystemRaceFinished::class)
                add(VaultSystemEventDynamicRewardsIndexesStateRemoved::class)
                add(VaultSystemEventDynamicRewardsIndexesStatesChanged::class)
                add(VaultSystemEventAlreadyPlayedAdded::class)
                add(VaultSystemEventUnlockedByRewardAdded::class)
                add(VaultSystemEventAlreadyPlayedRemoved::class)
            }
    }
}

@Serializable
data class VaultSystemTicketBalanceChanged(
    var oldTicketBalance: VaultTicket,
    var newTicketBalance: VaultTicket,
    var lastTicketRefilledTime: Instant,
    var maxAutoRefillTicketsAvailable: VaultTicket,
    var absoluteMaxTicketsAvailable: VaultTicket,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemSlotEventAssignedChanged(
    var slotId: VaultSlotId,
    var assignedEventId: VaultEventId,
    var timestamp: Instant,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemSlotStateRemoved(
    var slotId: VaultSlotId,
    var eventAssignedId: VaultEventId,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemEventStateRemoved(
    var eventId: VaultEventId,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemLockedStateChanged(
    var oldLockedState: Boolean,
    var newLockedState: Boolean,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemEventDurationExtended(
    var eventId: VaultEventId,
    var startTimepoint: Instant,
    var extendedTime: UInt,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemSoloRewardsObtained(
    var eventId: VaultEventId,
    var stageId: VaultStageId,
    var obtainedRewardIndexes: List<UInt>,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemEventProgressionChanged(
    var eventId: VaultEventId,
    var stageId: VaultStageId,
    var progression: VaultEventProgressionRewardLevel,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemEventProgressionRewardsStatusChanged(
    var eventId: VaultEventId,
    var rewardIdxs: List<UByte>,
    var newStatus: VaultEventProgressionRewardStatus,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemRaceFinished(
    var eventId: VaultEventId,
    var stageId: VaultStageId,
    var position: UByte,
    var hasFinished: Boolean,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemEventDynamicRewardsIndexesStateRemoved(
    var removedEventId: VaultEventId,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemEventDynamicRewardsIndexesStatesChanged(
    var eventId: VaultEventId,
    var optVaultRewardsIndexesState: VaultRewardsIndexesState?,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemEventAlreadyPlayedAdded(
    var eventId: VaultEventId,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemEventUnlockedByRewardAdded(
    var eventId: VaultEventId,
) : VaultSystemStatusUpdateGroup()

@Serializable
data class VaultSystemEventAlreadyPlayedRemoved(
    var eventId: VaultEventId,
) : VaultSystemStatusUpdateGroup()