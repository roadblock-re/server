package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.DateTimeUnit.Companion.HOUR
import kotlinx.datetime.Instant
import kotlinx.datetime.plus
import kotlinx.serialization.Serializable
import moe.crx.roadblock.core.utils.midnight
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.CalendarEventId
import moe.crx.roadblock.objects.gacha.EventBoxData
import moe.crx.roadblock.objects.gacha.GachaId
import moe.crx.roadblock.objects.gacha.GachaPoolDataEntry

@Serializable
data class GachaSystemState(
    var isLocked: Boolean = true,
    var nextRetentionBoxReadyTime: Instant = now().midnight().plus(24, HOUR),
    var openedGachaBoxes: Set<GachaId> = setOf(),
    var openedEventBoxes: Map<CalendarEventId, List<EventBoxData>> = mapOf(),
    @FromVersion("24.0.0")
    var nextSponsorshipRetentionBoxReadyTime: Instant = now(),
    @FromVersion("45.0.0")
    var gachaBoxesPoolData: Map<UInt, GachaPoolDataEntry> = mapOf(),
)