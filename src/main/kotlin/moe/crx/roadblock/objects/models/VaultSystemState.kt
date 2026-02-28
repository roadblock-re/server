package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.VaultEventId
import moe.crx.roadblock.objects.VaultTicket
import moe.crx.roadblock.objects.vault.VaultSlotsState

@Serializable
data class VaultSystemState(
    var ticketBalance: VaultTicket = 0u,
    var lastTicketRefilledTime: Instant = now(),
    var vaultSlots: List<VaultSlotsState> = listOf(),
    var isLocked: Boolean = true,
    var eventDataById: Map<VaultEventId, VaultEventState> = mapOf(),
    var alreadyPlayedEvents: List<VaultEventId> = listOf(),
    var unlockedEventsByReward: List<VaultEventId> = listOf(),
    var vaultRewardsIndexesState: VaultRewardsIndexesState = VaultRewardsIndexesState(),
    var hasTransitionedToSingleStruct: Boolean = false,
)