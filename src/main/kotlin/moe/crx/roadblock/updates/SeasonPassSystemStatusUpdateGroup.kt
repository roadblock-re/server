package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.MaintenanceSlots
import moe.crx.roadblock.objects.SeasonPassBenefitBoost
import moe.crx.roadblock.objects.SeasonPassEpisodeId
import moe.crx.roadblock.objects.SeasonPassExperience
import moe.crx.roadblock.objects.SeasonPassId
import moe.crx.roadblock.objects.SeasonPassMissionId
import moe.crx.roadblock.objects.SeasonPassTierId
import moe.crx.roadblock.objects.seasonpass.*

@Serializable
sealed class SeasonPassSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<SeasonPassSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(SeasonPassSystemSeasonPassStarted::class)
            add(SeasonPassSystemSeasonPassFinished::class)
            add(SeasonPassSystemSeasonPassEndDateModified::class)
            add(SeasonPassSystemLegendPassStateChanged::class)
            add(SeasonPassSystemMissionQuantityChanged::class)
            add(SeasonPassSystemMissionStateChanged::class)
            add(SeasonPassSystemExperienceChanged::class)
            add(SeasonPassSystemBoostChanged::class)
            add(SeasonPassSystemExtraMaintenanceSlotsChanged::class)
            add(SeasonPassSystemBenefitNextAvailableTLERefillChanged::class) // SeasonPassSystemBenefitNextAvaiableTLERefillChanged
            add(SeasonPassSystemTierRewardStateChanged::class)
            add(SeasonPassSystemEpisodePartialCompletionRewardStateChanged::class)
            add(SeasonPassSystemEpisodesCompletionRewardStateChanged::class)
            add(SeasonPassSystemNextSeasonDiscountPurchasedChanged::class)
            add(SeasonPassSystemRemoveEvents::class)
            add(SeasonPassSystemNotifyClaimTierRewards::class)
            add(SeasonPassSystemPlayedOnboardingChanged::class)
        }
    }
}

@Serializable
data class SeasonPassSystemBenefitNextAvailableTLERefillChanged(
    var eventId: CalendarEventId,
    var nextAvailableTLERefillTimePoint: Instant?,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemBoostChanged(
    var eventId: CalendarEventId,
    @ByteEnum
    var type: SeasonPassBoostType,
    var oldBoost: SeasonPassBenefitBoost,
    var newBoost: SeasonPassBenefitBoost,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemEpisodePartialCompletionRewardStateChanged(
    var eventId: CalendarEventId,
    var episodeId: SeasonPassEpisodeId,
    @ByteEnum
    var newState: SeasonPassEpisodePartialCompletionRewardState,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemEpisodesCompletionRewardStateChanged(
    var eventId: CalendarEventId,
    @ByteEnum
    var newState: SeasonPassEpisodesCompletionRewardState,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemExperienceChanged(
    var eventId: CalendarEventId,
    var oldExperience: SeasonPassExperience,
    var newExperience: SeasonPassExperience,
    @ByteEnum
    var origin: SeasonPassExperienceOrigin,
    var legendPassType: SeasonPassLegendPassType?,
    var legendPassExtraExperience: SeasonPassExperience?,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemExtraMaintenanceSlotsChanged(
    var eventId: CalendarEventId,
    var oldSlots: MaintenanceSlots,
    var newSlots: MaintenanceSlots,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemLegendPassStateChanged(
    var eventId: CalendarEventId,
    var legendPassType: SeasonPassLegendPassType?,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemMissionQuantityChanged(
    var eventId: CalendarEventId,
    var episodeId: SeasonPassEpisodeId,
    var missionId: SeasonPassMissionId,
    var type: SeasonPassMissionType,
    var oldQuantity: MissionProgress,
    var newQuantity: MissionProgress,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemMissionStateChanged(
    var eventId: CalendarEventId,
    var episodeId: SeasonPassEpisodeId,
    var missionId: SeasonPassMissionId,
    @ByteEnum
    var newState: SeasonPassMissionState,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemNextSeasonDiscountPurchasedChanged(
    var eventId: CalendarEventId,
    var purchased: Boolean,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemNotifyClaimTierRewards(
    var eventId: CalendarEventId,
    var tierId: SeasonPassTierId,
    @ByteEnum
    var type: SeasonPassTierRewardType,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemPlayedOnboardingChanged(
    var played: Boolean
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemRemoveEvents(
    var eventIds: List<CalendarEventId>
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemSeasonPassEndDateModified(
    var eventId: CalendarEventId,
    var previousEndDate: Instant,
    var newEndDate: Instant,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemSeasonPassFinished(
    var eventId: CalendarEventId,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemSeasonPassStarted(
    var eventId: CalendarEventId,
    var id: SeasonPassId,
    var isOnboarding: Boolean,
    var endDate: Instant,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemTierRewardStateChanged(
    var eventId: CalendarEventId,
    var tier: SeasonPassTierId,
    @ByteEnum
    var type: SeasonPassTierRewardType,
    @ByteEnum
    var newState: SeasonPassTierRewardState,
) : SeasonPassSystemStatusUpdateGroup()