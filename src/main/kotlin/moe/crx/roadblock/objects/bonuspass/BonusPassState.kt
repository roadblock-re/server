package moe.crx.roadblock.objects.bonuspass

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.BonusPassId

@Serializable
data class BonusPassState(
    var startDate: Instant,
    var bonusPassId: BonusPassId,
    var duration: Instant,
)