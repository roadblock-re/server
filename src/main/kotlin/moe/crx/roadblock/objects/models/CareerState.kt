package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CareerEventId
import moe.crx.roadblock.objects.ChapterId
import moe.crx.roadblock.objects.Flags
import moe.crx.roadblock.objects.SeasonId
import moe.crx.roadblock.objects.career.ChapterState
import moe.crx.roadblock.objects.career.EventState
import moe.crx.roadblock.objects.career.ProgressState
import moe.crx.roadblock.objects.career.SeasonState

@Serializable
data class CareerState(
    var flags: Flags = 0u,
    var seasons: Map<SeasonId, SeasonState> = mapOf(79u to SeasonState(ProgressState.InProgress)),
    var events: Map<CareerEventId, EventState> = mapOf(1028u to EventState(ProgressState.InProgress)),
    var chapters: Map<ChapterId, ChapterState> = mapOf(1u to ChapterState(ProgressState.InProgress)),
)