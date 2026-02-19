package moe.crx.roadblock.objects.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.objects.quarantine.QuarantineEvidenceType
import moe.crx.roadblock.objects.quarantine.QuarantineEnterData
import moe.crx.roadblock.objects.quarantine.QuarantineEvidenceData
import moe.crx.roadblock.objects.quarantine.QuarantineExitData

@Serializable
data class QuarantineState(
    @ByteEnum
    var type: Map<QuarantineEvidenceType, QuarantineEvidenceData> = mapOf(),
    var status: UInt = 0u, // TODO Must be QuarantinedStatus, but it has some garbage value
    var mostRecentEnterData: QuarantineEnterData? = null,
    var mostRecentExitData: QuarantineExitData? = null,
    var mostRecentEvidenceTime: Instant? = null,
)