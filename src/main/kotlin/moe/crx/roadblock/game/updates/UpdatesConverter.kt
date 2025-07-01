package moe.crx.roadblock.game.updates

import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.SerializationVersion
import moe.crx.roadblock.updates.blackmarket.*
import moe.crx.roadblock.updates.bonuspass.*
import moe.crx.roadblock.updates.career.*
import moe.crx.roadblock.updates.championship.*
import moe.crx.roadblock.updates.club.*
import moe.crx.roadblock.updates.clubrace.ClubRaceFinished
import moe.crx.roadblock.updates.clubwars.*
import moe.crx.roadblock.updates.dailytasks.*
import moe.crx.roadblock.updates.gacha.*
import moe.crx.roadblock.updates.groups.*
import moe.crx.roadblock.updates.inbox.InboxMessageRead
import moe.crx.roadblock.updates.inbox.InboxRemoveEvents
import moe.crx.roadblock.updates.inventory.*
import moe.crx.roadblock.updates.legendfund.LegendFundSystemLegendFundMilestoneClaimed
import moe.crx.roadblock.updates.legendfund.LegendFundSystemLegendFundOwnedChanged
import moe.crx.roadblock.updates.legendfund.LegendFundSystemLegendFundReset
import moe.crx.roadblock.updates.miscellaneous.*
import moe.crx.roadblock.updates.mpchallenges.*
import moe.crx.roadblock.updates.multiplayer.*
import moe.crx.roadblock.updates.piggybank.*
import moe.crx.roadblock.updates.playerstats.*
import moe.crx.roadblock.updates.privatelobby.PrivateLobbyRaceFinished
import moe.crx.roadblock.updates.privatelobby.PrivateLobbyRemoveEvents
import moe.crx.roadblock.updates.quarantine.QuarantineEnterReasonChanged
import moe.crx.roadblock.updates.quarantine.QuarantineEntered
import moe.crx.roadblock.updates.quarantine.QuarantineEvidenceAdded
import moe.crx.roadblock.updates.quarantine.QuarantineExited
import moe.crx.roadblock.updates.relayoffer.RelayOfferPurchaseTierUpdate
import moe.crx.roadblock.updates.relayoffer.RelayOfferSystemCurrentTierChanged
import moe.crx.roadblock.updates.relayoffer.RelayOfferSystemRemoveEvents
import moe.crx.roadblock.updates.seasonpass.*
import moe.crx.roadblock.updates.tle.*
import moe.crx.roadblock.updates.uber.*

object UpdatesConverter {

    // TODO Rewrite this utilising reflection, please.
    fun RObject.toStatusUpdateGroup(ver: SerializationVersion): StatusUpdateGroup {
        return StatusUpdateGroup(ver).apply {
            variant = when (this@toStatusUpdateGroup::class) {
                BlackMarketLockedStateChanged::class,
                BlackMarketSlotsRefreshed::class,
                BlackMarketSlotRemainingAmountChanged::class,
                BlackMarketDailyRefreshesChanged::class,
                BlackMarketNextDailyRefreshesResetTimeChanged::class,
                BlackMarketNextAutoRefreshTimeChanged::class,
                BlackMarketConsecutiveRefreshesChanged::class,
                BlackMarketCooldownRefreshesChanged::class -> {
                    BlackMarketStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                BonusPassSystemBonusPassStarted::class,
                BonusPassSystemBonusPassFinished::class,
                BonusPassSystemBonusPassDurationModified::class,
                BonusPassSystemBonusPassEventIdModified::class,
                BonusPassSystemRemoveEvents::class,
                BonusPassSystemBenefitFuelRefillsAmountChanged::class,
                BonusPassSystemBenefitFuelRefillsRestored::class,
                BonusPassSystemBenefitTLETicketsRefillsAmountChanged::class,
                BonusPassSystemBenefitTLETicketsRefillsRestored::class,
                BonusPassSystemNextTLETicketsRefillTimeChanged::class -> {
                    BonusPassSystemStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                CareerTotalFlagsChanged::class,
                CareerChapterStateChanged::class,
                CareerChapterFlagsChanged::class,
                CareerSeasonStateChanged::class,
                CareerSeasonFlagsChanged::class,
                CareerEventSatelliteRewardStateChanged::class,
                CareerEventStateChanged::class,
                CareerEventFlagChanged::class,
                CareerRaceFinished::class -> {
                    CareerStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                ChampionshipSystemRoundAttemptsChanged::class,
                ChampionshipSystemIsRegisteredChanged::class,
                ChampionshipSystemIsQualifiedChanged::class,
                ChampionshipSystemRaceFinished::class,
                ChampionshipSystemRaceBestTimeChanged::class,
                ChampionshipSystemRoundLeaderboardChanged::class,
                ChampionshipSystemFinalsLeaderboardChanged::class,
                ChampionshipSystemQualifyingRoundGroupChanged::class,
                ChampionshipSystemPracticeRewardsObtained::class,
                ChampionshipSystemFinalsGroupChanged::class,
                ChampionshipSystemQualifyingRoundStateChanged::class,
                ChampionshipSystemFinalsRoundStateChanged::class,
                ChampionshipSystemClaimStateChanged::class,
                ChampionshipSystemClaimRankReward::class,
                ChampionshipSystemClaimFreePack::class,
                ChampionshipSystemNeedsSyncServices::class,
                ChampionshipSystemNitroGhostResetCountChanged::class,
                ChampionshipSystemBestNitroGhostTimeChanged::class,
                ChampionshipSystemResetBestNitroGhostTime::class,
                ChampionshipSystemRemoveEvents::class -> {
                    ChampionshipSystemStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                ClubRaceFinished::class -> {
                    ClubRaceStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                ClubSystemLockedStateChanged::class,
                ClubSystemJoinedClub::class,
                ClubSystemLeftClub::class,
                ClubSystemUpdatedCachedInfo::class,
                ClubSystemSentJoinRequest::class,
                ClubSystemCancelledJoinRequest::class,
                ClubSystemSeasonEventStarted::class,
                ClubSystemSeasonEventFinished::class,
                ClubSystemJoinedSeasonEvent::class,
                ClubSystemClubReputationChanged::class,
                ClubSystemContributedReputationChanged::class,
                ClubSystemClaimedMilestones::class,
                ClubSystemClubWarsRoundRegistrationChanged::class,
                ClubSystemClubWarsLastFinishedRoundChanged::class,
                ClubSystemRemoveSeasonEvents::class,
                ClubSystemRemoveClubWarsEvents::class -> {
                    ClubSystemStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                ClubWarsRemoveEvents::class,
                ClubWarsLockedStateChanged::class,
                ClubWarsRegisterRound::class,
                ClubWarsUnregisterRound::class,
                ClubWarsRoundFinishStateChanged::class,
                ClubWarsRegistrationTimestampChanged::class,
                ClubWarsClaimRoundRewards::class,
                ClubWarsMatchmakingFinished::class,
                ClubWarsClaimStateChanged::class,
                ClubWarsClaimEventRewards::class,
                ClubWarsDefenseAttemptsChanged::class,
                ClubWarsNotifyOccupyNode::class,
                ClubWarsNotifyVacateNode::class,
                ClubWarsNotifyAssignCar::class,
                ClubWarsNotifyUnassignCar::class,
                ClubWarsNotifyDefenseRaceFinished::class,
                ClubWarsNotifyAttackRaceFinished::class,
                ClubWarsNotifyAttackRaceStarted::class,
                ClubWarsNotifyConquerNode::class,
                ClubWarsNotifySelectEntryPoint::class,
                ClubWarsNotifyResetNodes::class,
                ClubWarsNotifyRefreshNode::class,
                ClubWarsMarketLockedStateChanged::class,
                ClubWarsMarketStockChanged::class,
                ClubWarsMarketRefreshed::class,
                ClubWarsMarketNextRefreshTimeChanged::class -> {
                    ClubWarsStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                DailyTasksReseted::class,
                DailyTasksTaskUnlocked::class,
                DailyTasksTaskIncreased::class,
                DailyTasksTaskCompleted::class,
                DailyTasksTaskClaimed::class,
                DailyTasksTaskEnabled::class,
                DailyTasksRaceReadyCompleted::class,
                DailyTasksRaceReadyClaimed::class -> {
                    DailyTasksStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                GachaSystemLockedStateChanged::class,
                GachaSystemNextBoxIsCriticalChanged::class,
                GachaSystemRetentionBoxReadyTimeChanged::class,
                GachaSystemOpenedEventBoxes::class,
                GachaSystemRemoveEvents::class,
                GachaSystemOpenedBoxes::class,
                OpenedGachaBoxContainer::class -> {
                    GachaSystemStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                InboxMessageRead::class,
                InboxRemoveEvents::class -> {
                    InboxStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                InventoryCarIsClaimable::class,
                InventoryCarCanStarUp::class,
                InventoryCarHasUnlockItemChanged::class,
                InventoryCarOwnedStateChanged::class,
                InventoryCarBlueprintsChanged::class,
                InventoryCarEvoTierBlueprintsChanged::class,
                InventoryCarCanUpgradeEvoTier::class,
                InventoryCarEvoTierChanged::class,
                InventoryCarRacesFinishedChanged::class,
                InventoryCarUnlockedUpgradeTiersChanged::class,
                InventoryCarUpgradeLevelChanged::class,
                InventoryCarUpgradeItemChanged::class,
                InventoryCarMaintenanceBalanceChanged::class,
                InventoryCarMaintenanceStateChanged::class,
                InventoryCarLastUsageChanged::class,
                InventoryCarConsecutiveUsedDaysChanged::class,
                InventoryWalletBalanceChanged::class,
                InventoryWalletAdded::class,
                InventoryWalletRemoved::class,
                InventoryWildcardBlueprintsChanged::class,
                InventoryCarSpecificFreeUpgradesChanged::class,
                InventoryClassSpecificFreeUpgradesChanged::class,
                InventoryClassAndUnlockedTierSpecificFreeUpgradesChanged::class,
                InventoryCarVisualConfigurationChanged::class,
                InventoryCarCustomizationLocksChanged::class,
                InventoryCarDecalVisualOwnedChanged::class,
                InventoryCarCustomPartOwnedChanged::class,
                InventoryMaintenanceBookingAdded::class,
                InventoryMaintenanceBookingRemoved::class,
                InventoryEmojiLockChanged::class,
                InventoryFavoriteEmojisChanged::class,
                InventoryMuteEmojisChanged::class,
                InventoryAutoTrashStatusUpdate::class,
                InventoryUpgradeItemsStatusUpdate::class -> {
                    InventoryStatusUpdateGroup(ver).apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                LegendFundSystemLegendFundOwnedChanged::class,
                LegendFundSystemLegendFundMilestoneClaimed::class,
                LegendFundSystemLegendFundReset::class -> {
                    LegendFundSystemStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                MiscellaneousUserNameChanged::class,
                MiscellaneousUnderageDisclaimerShownChanged::class,
                MiscellaneousUserAgeAndGenderChanged::class,
                MiscellaneousUserGPDRComplianceChanged::class,
                MiscellaneousUserDeviceCountryChanged::class,
                MiscellaneousRegionChangeCountChanged::class,
                MiscellaneousGameSettingsChanged::class,
                MiscellaneousClaimedSystemNotificationRewardChanged::class,
                MiscellaneousXboxLiveOnlyEnableChanged::class,
                MiscellaneousEndRaceOfferHidden::class -> {
                    MiscellaneousStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                MultiplayerChallengesStatusUpdate0::class,
                MultiplayerChallengesRaceFinished::class,
                MultiplayerChallengesRemoveEvents::class,
                MultiplayerChallengesStatusUpdate3::class,
                MultiplayerChallengesStatusUpdate4::class,
                MultiplayerChallengesVictoriesChanged::class,
                MultiplayerChallengesRevivesChanged::class,
                MultiplayerChallengesDefeatsChanged::class,
                MultiplayerChallengesStatusUpdate8::class,
                MultiplayerChallengesStatusUpdate9::class,
                MultiplayerChallengesStatusUpdate10::class,
                MultiplayerChallengesStatusUpdate11::class,
                MultiplayerChallengesStatusUpdate12::class -> {
                    MultiplayerChallengesStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                MultiplayerSeriesLockedStateChanged::class,
                MultiplayerSeriesEventJoined::class,
                MultiplayerSeriesEventClaimable::class,
                MultiplayerSeriesEventClaimed::class,
                MultiplayerSeriesClaimRankRewards::class,
                MultiplayerSeriesCurrentEventReset::class,
                MultiplayerSeriesEloChanged::class,
                MultiplayerSeriesLeaderboardDataChanged::class,
                MultiplayerSeriesRacesCountChanged::class,
                MultiplayerSeriesCurrentTierChanged::class,
                MultiplayerSeriesMaxTierChanged::class,
                MultiplayerSeriesLeaderboardNameChanged::class,
                MultiplayerSeriesMostRecentDisconnectionsChanged::class,
                MultiplayerSeriesRaceFinished::class,
                MultiplayerSeriesRemoveEvents::class,
                MultiplayerSeriesScoreChanged::class,
                MultiplayerSeriesMilestoneChanged::class -> {
                    MultiplayerSeriesStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                PiggyBankSystemPiggyBankStarted::class,
                PiggyBankSystemPiggyBankFinished::class,
                PiggyBankSystemRemoveEvents::class,
                PiggyBankSystemPiggyBankCurrentProgressChanged::class,
                PiggyBankSystemPiggyBankCurrentTierChanged::class,
                PiggyBankSystemPiggyBankFilledTimestampChanged::class,
                PiggyBankSystemPiggyBankNotifyTierClaimed::class,
                PiggyBankSystemPiggyBankTierAttemptsIncreased::class -> {
                    PiggyBankSystemStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                PlayerStatsReputationLevelChanged::class,
                PlayerStatsReputationPointsChanged::class,
                PlayerStatsReputationPointsOverflowed::class,
                PlayerStatsGarageLevelChanged::class,
                PlayerStatsGarageValueChanged::class,
                PlayerStatsLastGarageLevelWithClaimedRewardChanged::class,
                PlayerStatsMissionRewardClaimableChanged::class,
                PlayerStatsMissionValueChanged::class,
                PlayerStatsMissionMilestoneChanged::class,
                PlayerStatsMenuTutorialStateChanged::class,
                PlayerStatsGameplayTutorialStateChanged::class -> {
                    PlayerStatsStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                PrivateLobbyRemoveEvents::class,
                PrivateLobbyRaceFinished::class -> {
                    PrivateLobbyStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                QuarantineEvidenceAdded::class,
                QuarantineEntered::class,
                QuarantineEnterReasonChanged::class,
                QuarantineExited::class -> {
                    QuarantineStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                RelayOfferSystemCurrentTierChanged::class,
                RelayOfferSystemRemoveEvents::class,
                RelayOfferPurchaseTierUpdate::class -> {
                    RelayOfferSystemStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                SeasonPassSystemSeasonPassStarted::class,
                SeasonPassSystemSeasonPassFinished::class,
                SeasonPassSystemSeasonPassEndDateModified::class,
                SeasonPassSystemLegendPassStateChanged::class,
                SeasonPassSystemMissionQuantityChanged::class,
                SeasonPassSystemMissionStateChanged::class,
                SeasonPassSystemExperienceChanged::class,
                SeasonPassSystemBoostChanged::class,
                SeasonPassSystemExtraMaintenanceSlotsChanged::class,
                SeasonPassSystemBenefitNextAvailableTLERefillChanged::class,
                SeasonPassSystemTierRewardStateChanged::class,
                SeasonPassSystemEpisodePartialCompletionRewardStateChanged::class,
                SeasonPassSystemEpisodesCompletionRewardStateChanged::class,
                SeasonPassSystemNextSeasonDiscountPurchasedChanged::class,
                SeasonPassSystemRemoveEvents::class,
                SeasonPassSystemNotifyClaimTierRewards::class,
                SeasonPassSystemPlayedOnboardingChanged::class -> {
                    SeasonPassSystemStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                TLEventsSystemLockedStateChanged::class,
                TLEventsSystemTicketBalanceChanged::class,
                TLEventsSystemSoloRewardsObtained::class,
                TLEventsSystemRankLeaderboardChanged::class,
                TLEventsSystemClaimRankDataChanged::class,
                TLEventsSystemClaimRankReward::class,
                TLEventsSystemClaimTopClubReward::class,
                TLEventsSystemClubRewardsCompleted::class,
                TLEventsSystemClubRewardClaimed::class,
                TLEventsSystemClaimClubDataChanged::class,
                TLEventsSystemBestTimeChanged::class,
                TLEventsSystemEnterQuarantine::class,
                TLEventsSystemExitQuarantine::class,
                TLEventsSystemQuarantineBestTimeChanged::class,
                TLEventsSystemRaceFinished::class,
                TLEventsSystemRemoveEvents::class,
                TLEventsSystemRemoveSpecialEvents::class,
                TLEventsSystemSpecialEventProgressionChanged::class,
                TLEventsSystemSpecialEventProgressionRewardStateChanged::class,
                TLEventsSystemEventAutoclaimed::class,
                TLEventsSystemBestNitroGhostTimeChanged::class,
                TLEventsSystemResetCountChanged::class -> {
                    TLEventsSystemStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                UberSystemEventParticipated::class,
                UberSystemMissionCompleted::class,
                UberSystemExperienceChanged::class,
                UberSystemHazardLevelChanged::class,
                UberSystemtimesPurchasedForSlotChanged::class,
                UberSystemRemoveEvents::class,
                UberSystemRaceFinished::class,
                UberSystemCarDiscovered::class,
                UberSystemRaceReward::class,
                UberSystemCurrencyBeenConvertedChanged::class,
                UberSystemMilestoneAchieved::class,
                UberSystemUberExperienceObtainedInMissionsChanged::class,
                UberSystemUberCurrencyObtainedInPinnedMissionChanged::class -> {
                    UberSystemStatusUpdateGroup().apply {
                        variant = this@toStatusUpdateGroup
                    }
                }

                else -> {
                    throw IllegalArgumentException("CONVERSION ISSUE: Unknown update to convert")
                }
            }
        }
    }
}