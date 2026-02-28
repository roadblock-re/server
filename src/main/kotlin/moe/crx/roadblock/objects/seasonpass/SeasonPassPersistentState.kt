package moe.crx.roadblock.objects.seasonpass

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.SeasonPassExperience
import moe.crx.roadblock.objects.SeasonPassId

@Serializable
data class SeasonPassPersistentState(
    var eventId: CalendarEventId,
    var id: SeasonPassId,
    var currentExperience: SeasonPassExperience,
    @ByteEnum
    var activeLegendPassType: SeasonPassLegendPassType?,
    var discountForNextSeason: Boolean,
    @FromVersion("24.0.0")
    var transactionId: String? = null
)