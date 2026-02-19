package moe.crx.roadblock.objects.quarantine

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.HoneyPotId

@Serializable
data class QuarantineData(
    var evidences: List<QuarantineEvidence>,
    var honeyPots: List<HoneyPotId>,
)