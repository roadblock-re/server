package moe.crx.roadblock.objects.vault

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.VaultEventId
import moe.crx.roadblock.objects.account.VaultSlotId

@Serializable
data class VaultSlotsState(
    var slotId: VaultSlotId,
    var assignedEventId: VaultEventId,
    var eventAssignedTimestamp: Instant,
)