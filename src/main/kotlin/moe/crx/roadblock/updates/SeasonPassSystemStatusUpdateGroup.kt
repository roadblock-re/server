package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.*
import moe.crx.roadblock.objects.*
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
            if (version newer "45.0.0") { // TODO find exact version
                add(SeasonPassSystemStatusUpdateGroup10::class)
                add(SeasonPassSystemStatusUpdateGroup11::class)
            }
            add(SeasonPassSystemTierRewardStateChanged::class)
            add(SeasonPassSystemEpisodePartialCompletionRewardStateChanged::class)
            add(SeasonPassSystemEpisodesCompletionRewardStateChanged::class)
            add(SeasonPassSystemNextSeasonDiscountPurchasedChanged::class)
            add(SeasonPassSystemRemoveEvents::class)
            add(SeasonPassSystemNotifyClaimTierRewards::class)
            add(SeasonPassSystemPlayedOnboardingChanged::class)
            if (version newer "45.0.0") { // TODO find exact version
                add(SeasonPassSystemStatusUpdateGroup19::class)
                add(SeasonPassSystemStatusUpdateGroup20::class)
            }
        }
    }
}

@Serializable
data class SeasonPassSystemSeasonPassStarted(
    var eventId: CalendarEventId,
    var id: SeasonPassId,
    var isOnboarding: Boolean,
    @FromVersion("45.0.0") // TODO find exact version
    var optActivationId: UInt? = null,
    var endDate: Instant,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemSeasonPassFinished(
    var eventId: CalendarEventId,
    @FromVersion("45.0.0") // TODO find exact version
    var optActivationId: UInt? = null,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemSeasonPassEndDateModified(
    var eventId: CalendarEventId,
    var previousEndDate: Instant,
    var newEndDate: Instant,
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
    @UntilVersion("45.0.0") @ByteEnum // TODO find exact version
    var legacyNewState: SeasonPassMissionState = SeasonPassMissionState.Ready,
    @FromVersion("45.0.0") // TODO find exact version
    var newState: SeasonPassMissionState = SeasonPassMissionState.Ready,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemExperienceChanged(
    var eventId: CalendarEventId,
    var oldExperience: SeasonPassExperience,
    var newExperience: SeasonPassExperience,
    @UntilVersion("45.0.0") @ByteEnum // TODO find exact version
    var legacyOrigin: SeasonPassExperienceOrigin = SeasonPassExperienceOrigin.MissionCompleted,
    @FromVersion("45.0.0") // TODO find exact version
    var origin: SeasonPassExperienceOrigin = SeasonPassExperienceOrigin.MissionCompleted,
    var legendPassType: SeasonPassLegendPassType?,
    var legendPassExtraExperience: SeasonPassExperience?,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemBoostChanged(
    var eventId: CalendarEventId,
    @UntilVersion("45.0.0") @ByteEnum // TODO find exact version
    var legacyType: SeasonPassBoostType = SeasonPassBoostType.Reputation,
    @FromVersion("45.0.0") // TODO find exact version
    var type: SeasonPassBoostType = SeasonPassBoostType.Reputation,
    var oldBoost: SeasonPassBenefitBoost,
    var newBoost: SeasonPassBenefitBoost,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemExtraMaintenanceSlotsChanged(
    var eventId: CalendarEventId,
    var oldSlots: MaintenanceSlots,
    var newSlots: MaintenanceSlots,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemBenefitNextAvailableTLERefillChanged(
    var eventId: CalendarEventId,
    var nextAvailableTLERefillTimePoint: Instant?,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemStatusUpdateGroup10(
    var eventId: CalendarEventId,
    var hasUnlimitedFuelInCareerMode: Boolean,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemStatusUpdateGroup11(
    var eventId: CalendarEventId,
    var hasUnlimitedTicketsInTLE: Boolean,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemTierRewardStateChanged(
    var eventId: CalendarEventId,
    var tier: SeasonPassTierId,
    @UntilVersion("45.0.0") @ByteEnum // TODO find exact version
    var legacyType: SeasonPassTierRewardType = SeasonPassTierRewardType.Free,
    @UntilVersion("45.0.0") @ByteEnum // TODO find exact version
    var legacyNewState: SeasonPassTierRewardState = SeasonPassTierRewardState.Locked,
    @FromVersion("45.0.0") // TODO find exact version
    var type: SeasonPassTierRewardType = SeasonPassTierRewardType.Free,
    @FromVersion("45.0.0") // TODO find exact version
    var newState: SeasonPassTierRewardState = SeasonPassTierRewardState.Locked,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemEpisodePartialCompletionRewardStateChanged(
    var eventId: CalendarEventId,
    var episodeId: SeasonPassEpisodeId,
    @UntilVersion("45.0.0") @ByteEnum // TODO find exact version
    var legacyNewState: SeasonPassEpisodePartialCompletionRewardState = SeasonPassEpisodePartialCompletionRewardState.Locked,
    @FromVersion("45.0.0") // TODO find exact version
    var newState: SeasonPassEpisodePartialCompletionRewardState = SeasonPassEpisodePartialCompletionRewardState.Locked,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemEpisodesCompletionRewardStateChanged(
    var eventId: CalendarEventId,
    @UntilVersion("45.0.0") @ByteEnum // TODO find exact version
    var legacyNewState: SeasonPassEpisodesCompletionRewardState = SeasonPassEpisodesCompletionRewardState.Locked,
    @FromVersion("45.0.0") // TODO find exact version
    var newState: SeasonPassEpisodesCompletionRewardState = SeasonPassEpisodesCompletionRewardState.Locked,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemNextSeasonDiscountPurchasedChanged(
    var eventId: CalendarEventId,
    var purchased: Boolean,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemRemoveEvents(
    var eventIds: List<CalendarEventId>
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemNotifyClaimTierRewards(
    var eventId: CalendarEventId,
    var tierId: SeasonPassTierId,
    @UntilVersion("45.0.0") @ByteEnum // TODO find exact version
    var legacyType: SeasonPassTierRewardType = SeasonPassTierRewardType.Free,
    @FromVersion("45.0.0") // TODO find exact version
    var type: SeasonPassTierRewardType = SeasonPassTierRewardType.Free,
    @FromVersion("45.0.0") // TODO find exact version
    var isUnlockedByPurchase: Boolean = false,
    @FromVersion("45.0.0") // TODO find exact version
    val isEndOfEventClaim: Boolean = false,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemPlayedOnboardingChanged(
    var played: Boolean
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemStatusUpdateGroup19(
    var oldEventId: CalendarEventId,
    var newEventId: CalendarEventId,
) : SeasonPassSystemStatusUpdateGroup()

@Serializable
data class SeasonPassSystemStatusUpdateGroup20(
    var bonus: UInt,
) : SeasonPassSystemStatusUpdateGroup()