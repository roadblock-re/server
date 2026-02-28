package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CareerEventId
import moe.crx.roadblock.objects.CareerFlagId
import moe.crx.roadblock.objects.ChapterId
import moe.crx.roadblock.objects.Flags
import moe.crx.roadblock.objects.SeasonId
import moe.crx.roadblock.objects.career.ProgressState
import moe.crx.roadblock.objects.career.SatelliteRewardState

@Serializable
sealed class CareerStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<CareerStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(CareerTotalFlagsChanged::class)
            add(CareerChapterStateChanged::class)
            add(CareerChapterFlagsChanged::class)
            add(CareerSeasonStateChanged::class)
            add(CareerSeasonFlagsChanged::class)
            add(CareerEventSatelliteRewardStateChanged::class)
            add(CareerEventStateChanged::class)
            add(CareerEventFlagChanged::class)
            add(CareerRaceFinished::class)
        }
    }
}

@Serializable
data class CareerChapterFlagsChanged(
    var chapterId: ChapterId,
    var oldFlags: Flags,
    var newFlags: Flags,
) : CareerStatusUpdateGroup()

@Serializable
data class CareerChapterStateChanged(
    var eventId: ChapterId,
    var oldState: ProgressState,
    var newState: ProgressState,
) : CareerStatusUpdateGroup()

@Serializable
data class CareerEventFlagChanged(
    var eventId: CareerEventId,
    var flagId: CareerFlagId,
    var obtained: Boolean,
) : CareerStatusUpdateGroup()

@Serializable
data class CareerEventSatelliteRewardStateChanged(
    var eventId: CareerEventId,
    var oldState: SatelliteRewardState,
    var newState: SatelliteRewardState,
) : CareerStatusUpdateGroup()

@Serializable
data class CareerEventStateChanged(
    var eventId: CareerEventId,
    var oldState: ProgressState,
    var newState: ProgressState,
) : CareerStatusUpdateGroup()

@Serializable
data class CareerRaceFinished(
    var position: Byte,
    var eventId: CareerEventId,
    var hasFinished: Boolean,
    var wasCompleted: Boolean,
) : CareerStatusUpdateGroup()

@Serializable
data class CareerSeasonFlagsChanged(
    var seasonId: SeasonId,
    var oldFlags: Flags,
    var newFlags: Flags,
) : CareerStatusUpdateGroup()

@Serializable
data class CareerSeasonStateChanged(
    var seasonId: SeasonId,
    var oldState: ProgressState,
    var newState: ProgressState,
) : CareerStatusUpdateGroup()

@Serializable
data class CareerTotalFlagsChanged(
    var oldFlags: Flags,
    var newFlags: Flags,
) : CareerStatusUpdateGroup()