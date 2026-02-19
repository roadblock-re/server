package moe.crx.roadblock.objects.piggybank

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.Money
import moe.crx.roadblock.objects.account.PiggyBankEventId
import moe.crx.roadblock.objects.account.PiggyBankTierId

@Serializable
data class PiggyBankState(
    var startDate: Instant,
    var eventId: PiggyBankEventId,
    var currentTier: PiggyBankTierId,
    var currentProgress: Money,
    var bankFilledTimestamp: Instant?,
    var dataByTier: Map<PiggyBankTierId, PiggyBankTierState>,
    @FromVersion("24.0.0")
    var totalProgress: Money = 0,
)