package moe.crx.roadblock.game

import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.rpc.*
import moe.crx.roadblock.rpc.base.RequestPacket
import java.io.File
import kotlin.reflect.KClass

class GameLayer(private val workingDirectory: String, private val ver: SerializationVersion) {

    companion object {
        fun reportVersion(gameVersion: String): SerializationVersion {
            val ver = SerializationVersion(gameVersion)

            // TODO Investigate this phenomena and add more versions
            if (ver eq "24.0.1") {
                return SerializationVersion("24.0.14")
            }

            if (ver eq "3.9.0") {
                return SerializationVersion("3.9.2")
            }

            if (ver eq "3.6.3") {
                return SerializationVersion("3.6.2000")
            }

            if (ver eq "3.7.5") {
                return SerializationVersion("3.7.1002")
            }

            return ver
        }
    }

    data class PacketHandler(
        val requestName: String,
        val requestClass: KClass<out RequestPacket>,
        val handle: (suspend (GameConnection, RequestPacket) -> Unit)?,
    )

    var handlers: MutableList<PacketHandler> = mutableListOf()

    init {
        register(::handleLogin)
        if (ver newer "24.0.0") {
            register(::handleNotifyShutdown)
        }
        register(::handleCareerStartRace)
        register(::handleCareerFinishRace)
        register(::handleCareerCancelRace)
        register(::handleClaimSatelliteReward)
        register(::handleCompleteCareerSeasonCheat)
        register(::handleGainEventFlagCheat)
        if (ver newer "24.6.0") {
            register(::handleGainCareerFlagsCheat)
        }
        register(::handleUnlockAllChaptersCheat)
        register(::handleUnlockAllSeasonsCheat)
        register(::handleBuyCar)
        register(::handleSetPreferredCarVisual)
        register(::handleMaintenanceStartRefill)
        register(::handleMaintenanceSkipRefillWithTokens)
        register(::handleMaintenanceSkipRefillWithBonusPassBenefit)
        register(::handleMaintenanceValidateRefill)
        if (ver newer "24.6.0") {
            register(::handleUnlockAssemblyStage)
        }
        register(::handleUnlockUpgradeTier)
        register(::handleUpgradeCarStatLevel)
        register(::handleFreeUpgradeCarStatLevel)
        register(::handleInstallUpgradeItem)
        if (ver newer "45.0.0") {
            register(::handleAcquireAndInstallUpgradeItem)
        }
        if (ver newer "3.7.0") {
            register(::handleConvertWildcardBlueprints)
        }
        if (ver newer "47.1.0") {
            register(::handleApplyWildcardStarUpItem)
        }
        register(::handleTrashItem)
        if (ver newer "45.0.0") {
            register(::handleEquipEvoTuningEngine)
            register(::handleEquipEvoTuningDriveTrain)
            register(::handleEquipEvoTuningIntake)
            register(::handleEquipEvoTuningNOS)
            register(::handleEquipEvoTuningSKit)
        }
        if (ver newer "47.1.0") {
            register(::handleReceiveEvoTicketsOnCarMaxed)
        }
        register(::handleGainAllCarItemsCheat)
        register(::handleGainAllCarsCheat)
        register(::handleGainCurrencyCheat)
        register(::handleGainCarBlueprintsCheat)
        if (ver newer "3.7.0") {
            register(::handleGainWildcardBlueprintsCheat)
        }
        if (ver older "24.0.0") {
            register(::handleGainCarEvoBlueprintsCheat)
        }
        if (ver newer "24.6.0") {
            register(::handleGainWildcardUpgradeItemsCheat)
        }
        if (ver newer "47.1.0") {
            register(::handleGainWildcardStarUpItemsCheat)
        }
        if (ver newer "45.0.0") {
            register(::handleGetAllEvoTuningCarPartsCheat)
        }
        register(::handleSaveEmojiConfiguration)
        register(::handleBuyGachaBox)
        register(::handleBuyTimeLimitedGachaBox)
        if (ver newer "24.0.0") {
            register(::handleClaimSponsorshipGachaBox)
        }
        if (ver newer "47.1.0") {
            register(::handleConvertEvoTicketsToCurrency)
            register(::handleBuyEvoGachaBox)
        }
        register(::handleClaimLevelUpGachaBoxes)
        register(::handleClaimMissionReward)
        if (ver newer "24.6.0") {
            register(::handleClaimAllMissionReward)
        }
        register(::handleTutorialFinishRace)
        register(::handleChangeMenuTutorialState)
        register(::handleChangeGameplayTutorialState)
        register(::handleGainGarageLevelCheat)
        register(::handleGainGarageValueCheat)
        if (ver newer "24.0.3") { // 24.0.1 doesn't support this
            register(::handleClaimAllFreePremiumGachasCheat)
        }
        register(::handleBlackMarketGetStatus)
        register(::handleBlackMarketBuy)
        register(::handleBlackMarketRefresh)
        register(::handleMultiplayerSeriesCancelMatchmaking)
        register(::handleMultiplayerSeriesCancelRace)
        register(::handleMultiplayerSeriesClaimRewards)
        register(::handleMultiplayerSeriesFinishRace)
        register(::handleMultiplayerSeriesRefreshClaimState)
        register(::handleMultiplayerSeriesRequestRevertOfMaintenanceBooking)
        register(::handleMultiplayerSeriesResetCurrentEventCheat)
        register(::handleMultiplayerSeriesResetMaxTierCheat)
        register(::handleMultiplayerSeriesSetEloCheat)
        register(::handleMultiplayerSeriesStartMatchmaking)
        register(::handleMultiplayerSeriesStartRace)
        register(::handleMultiplayerSeriesSyncRaces)
        register(::handleMultiplayerSeriesReportUser)
        if (ver newer "24.6.0") {
            register(::handleMultiplayerSeriesClaimSkippedMilestones)
        }
        register(::handleCreateClub)
        register(::handleEditClub)
        register(::handleLeaveClub)
        register(::handleRequestJoinClub)
        register(::handleAcceptClubRequest)
        register(::handleRejectClubRequest)
        register(::handlePromoteClubMember)
        register(::handleDemoteClubMember)
        register(::handleKickClubMember)
        register(::handleClaimClubSeasonMilestone)
        register(::handleClaimCurrentClubSeason)
        register(::handleClaimPreviousClubSeasons)
        register(::handleRefreshClubState)
        register(::handleFindOnlineUserByAlias)
        register(::handleInviteUser)
        register(::handleAcceptClubInvitation)
        register(::handleDeclineClubInvitation)
        if (ver newer "24.0.0") {
            register(::handleRequestClubDonation)
            register(::handleGiveClubDonation)
            register(::handleGetClubDonations)
        }
        if (ver newer "24.0.0" && ver older "24.6.0") {
            register(::handleSetClubUGCValidatedCheat)
        }
        if (ver newer "24.6.0") {
            register(::handleSearchClubsByKeywords)
            register(::handleSearchRecommendedClubs)
            register(::handleSearchClubByTag)
            register(::handleGetClubData)
            register(::handleGetClubInvitations)
            register(::handleGetClubMembershipApprovalRequests)
            register(::handleGetClubMembers)
            register(::handleGetInvitedPlayers)
        }
        if (ver older "24.6.0") {
            register(::handleClubRaceCancelRace)
            register(::handleClubRaceCreateRoom)
            register(::handleClubRaceFinishRace)
            register(::handleClubRaceJoinRoom)
            register(::handleClubRaceNotifyRoomJoined)
            register(::handleClubRaceNotifyRoomJoinFailed)
            register(::handleClubRaceNotifyRoomLeft)
            register(::handleClubRaceStartRace)
        }
        register(::handleMiscellaneousSetUserName)
        register(::handleMiscellaneousSetUserAgeAndGender)
        register(::handleMiscellaneousSetUserOnlinePrivacyPolicy)
        register(::handleMiscellaneousSetUnderageDisclaimerShown) // MiscellaneousSetConsentNoticeShown
        register(::handleSaveGameSettings)
        register(::handleMiscellaneousSetPlatform)
        if (ver newer "24.0.0") {
            register(::handleMiscellaneousSetCrossplayPlatformFilter)
            register(::handleSaveAdsMinigameResult)
        }
        if (ver older "24.0.0") {
            register(::handleMiscellaneousSetUniqueUserName)
        }
        if (ver newer "24.6.0") {
            register(::handleMiscellaneousUpdateProfileConsent)
            register(::handleMiscellaneousSaveProfileConsent)
            register(::handleMiscellaneousClaimAdsReplacement)
            register(::handleMiscellaneousResetAdsReplacementState)
        }
        register(::handlePerformCheat)
        register(::handlePurchaseOfflineProduct)
        register(::handleIAPFakePurchaseCheat)
        register(::handleProcessPendingSeshatAdTransaction)
        register(::handleProcessPendingSeshatGiftTransaction)
        register(::handleProcessPendingSeshatIAPTransaction)
        register(::handleProcessPendingSeshatRefundTransaction)
        if (ver older "45.0.0") {
            register(::handleProcessPendingSeshatTransactions)
        }
        if (ver newer "45.0.0") {
            register(::handleProcessOrphanTransactions)
        }
        register(::handleClaimAdClientSideRewards)
        if (ver newer "3.8.0") {
            register(::handleCurrencyPackValidatePurchase)
        }
        if (ver newer "3.9.0") {
            register(::handlePromotionValidatePurchase)
        }
        register(::handleTLETicketsCheat)
        register(::handleTLEventCancelRace)
        register(::handleTLEventClaimClubReward)
        register(::handleTLEventClaimRankRewards)
        register(::handleTLEventCompleteCheat)
        register(::handleTLEventFinishRace)
        if (ver newer "24.6.0") {
            register(::handleTLEventAutoplayFinishRace)
        }
        register(::handleTLEventRefillTickets)
        register(::handleTLEventRefreshClaimState)
        register(::handleTLEventSkipClubRewardCondition) // TLEventSkipClubRewardContidion
        register(::handleTLEventSkipSoloRewardCondition) // TLEventSkipSoloRewardContidion
        register(::handleTLEventStartRace)
        if (ver newer "24.6.0") {
            register(::handleTLEventAutoplayStartRace)
        }
        register(::handleTLEventClaimPreviousSpecialEvent)
        register(::handleTimeLimitedSpecialEventClaimProgressionReward)
        register(::handleTLEventAutoclaimRewards)
        if (ver newer "3.9.0") {
            register(::handleTLEventResetNitroGhost)
        }
        if (ver newer "47.1.0") {
            register(::handleTLEventEquipEvoEngineFreeTry)
            register(::handleTLEventEquipEvoDriveTrainFreeTry)
            register(::handleTLEventEquipEvoNOSFreeTry)
            register(::handleTLEventEquipEvoIntakeFreeTry)
            register(::handleTLEventEquipEvoSKitFreeTry)
        }
        register(::handleTLEventResetCheat)
        register(::handleRetrievePlaybackCheat)
        register(::handleForceConfigRefresh)
        register(::handleGetRemoteAccountConflictData)
        register(::handleClaimGift)
        register(::handleClaimIrisRedeemCode)
        register(::handleClaimDynamicReward)
        register(::handleResetUserState)
        register(::handleClaimEnableNotificationsReward)
        if (ver newer "3.8.0") {
            register(::handleClaimDailyTasks)
        }
        if (ver older "3.8.0") {
            register("::handleClaimDailyTask")
        }
        register(::handleDailyTasksReset)
        if (ver older "3.8.0") {
            register("::handleClaimDailyTaskRaceReady")
        }
        register(::handleBuyRelayOfferTier)
        register(::handleValidateIAPRelayOfferPurchase)
        if (ver newer "24.0.0" && ver older "24.6.0") {
            register(::handleQuickRaceFinishRace)
        }
        if (ver newer "3.7.0") {
            register(::handleSplitScreenStartRace)
        }
        if (ver newer "24.0.0") {
            register(::handleSplitScreenEndRace)
        }
        register(::handleUberSpecialEventDiscoverMissionCars)
        register(::handleUberSpecialEventStartRace)
        register(::handleUberSpecialEventCancelRace)
        register(::handleUberSpecialEventRegisterFinishRace)
        register(::handleUberSpecialEventRetryRace)
        register(::handleUberSpecialEventCommitResultsRace)
        register(::handleUberSpecialEventSkipMission)
        register(::handleUberSpecialEventCleanHazard)
        register(::handleUberSpecialEventMarketBuy)
        register(::handleUberSpecialEventFinalClaim)
        register(::handleChampionshipSpecialEventStartQualifyingPracticeRace)
        register(::handleChampionshipSpecialEventFinishQualifyingPracticeRace)
        register(::handleChampionshipSpecialEventStartQualifyingRace)
        register(::handleChampionshipSpecialEventFinishQualifyingRace)
        register(::handleChampionshipSpecialEventStartFinalsPracticeRace)
        register(::handleChampionshipSpecialEventFinishFinalsPracticeRace)
        register(::handleChampionshipSpecialEventStartFinalsRace)
        register(::handleChampionshipSpecialEventFinishFinalsRace)
        register(::handleChampionshipSpecialEventCancelRace)
        register(::handleChampionshipSpecialEventRefreshQualifyingRoundGroup)
        register(::handleChampionshipSpecialEventRefreshQualifyingRoundState)
        register(::handleChampionshipSpecialEventRefreshFinalsGroup)
        register(::handleChampionshipSpecialEventRefreshFinalsRoundState)
        register(::handleChampionshipSpecialEventSkipReward)
        register(::handleChampionshipSpecialEventBuyQualification)
        register(::handleChampionshipSpecialEventRefreshClaimState)
        register(::handleChampionshipSpecialEventClaimRankRewards)
        register(::handleChampionshipSpecialEventClaimFreePack)
        register(::handleChampionshipSpecialEventSyncServices)
        register(::handleChampionshipSpecialEventResetNitroGhost)
        register(::handleSeasonPassBuyTier)
        register(::handleSeasonPassClaimPendingRewards)
        register(::handleSeasonPassClaimEpisodePartialCompletionRewards)
        register(::handleSeasonPassClaimEpisodesCompletionRewards)
        register(::handleSeasonPassValidateProductPurchase)
        if (ver newer "3.7.0") {
            register(::handleSeasonPassPerformCheat) // SeasonPassSetPlayedOnboardingCheat
        }
        if (ver older "24.0.0") {
            register(::handleMultiplayerChallengesBuyEntry)
            register(::handleMultiplayerChallengesRevealMoreSponsors)
            register(::handleMultiplayerChallengesSelectSponsor)
            register(::handleMultiplayerChallengesReviveRound)
            register(::handleMultiplayerChallengesFinishRound)
            register(::handleMultiplayerChallengesClaimReward)
            register(::handleMultiplayerChallengesStartMatchmaking)
            register(::handleMultiplayerChallengesCancelMatchmaking)
            register(::handleMultiplayerChallengesStartRace)
            register(::handleMultiplayerChallengesFinishRace)
            register(::handleMultiplayerChallengesCancelRace)
            register(::handleMultiplayerChallengesSyncRaces)
            register(::handleMultiplayerChallengesReportUser)
            register(::handleMultiplayerChallengesSkipCooldown)
        }
        if (ver older "45.0.0") {
            register(::handleClubWarsRegister)
            register(::handleClubWarsRefreshRegistration)
            register(::handleClubWarsProcessMatchmaking)
            register(::handleClubWarsDefenseStartRace)
            register(::handleClubWarsDefenseFinishRace)
            register(::handleClubWarsDefenseCancelRace)
            register(::handleClubWarsDefenseAssignCar)
            register(::handleClubWarsDefenseOccupyNode)
            register(::handleClubWarsDefenseUnassignCar)
            register(::handleClubWarsDefenseVacateNode)
            register(::handleClubWarsPracticeStartRace)
            register(::handleClubWarsPracticeFinishRace)
            register(::handleClubWarsPracticeCancelRace)
            register(::handleClubWarsAttackStartRace)
            register(::handleClubWarsAttackFinishRace)
            register(::handleClubWarsAttackCancelRace)
            register(::handleClubWarsAttackConquerNode)
            register(::handleClubWarsAttackSelectEntryPoint)
            register(::handleClubWarsRefreshRegions)
            register(::handleClubWarsRefreshNodes)
            register(::handleClubWarsFinishRound)
            register(::handleClubWarsClaimRound)
            register(::handleClubWarsRefreshClaimState)
            register(::handleClubWarsClaimRewards)
            register(::handleClubWarsMarketBuy)
            register(::handleClubWarsMarketRefresh)
        }
        register(::handleInboxMarkAsRead)
        // Party was PrivateLobby before 24.0.0
        register(::handlePartyCreateRoom)
        register(::handlePartyJoinRoom)
        if (ver newer "24.0.0") {
            register(::handlePartyJoinByPartyId)
            register(::handlePartyFindRoomByAccessCode)
        }
        register(::handlePartyStartRace)
        register(::handlePartyFinishRace)
        if (ver newer "24.6.0") {
            register(::handlePartyNotifyReturnToLobby)
        }
        register(::handlePartyCancelRace)
        if (ver newer "24.0.0") {
            register(::handlePartyCancelRaceSpectator)
        }
        register(::handlePartyStartRaceSpectator)
        if (ver newer "24.0.0") {
            register(::handlePartyLeaveRoom)
            register(::handlePartyKickUser)
            register(::handlePartyLaunchRoom)
            register(::handlePartyUpdateUserData)
            register(::handlePartyUpdateRoomData)
            register(::handlePartyChangeUserRole)
            register(::handlePartySendPartyInvitation)
            register(::handlePartySetNativeSession)
        }
        register(::handleSendTrackingEvents)
        if (ver newer "24.0.0") {
            register(::handleGetPlatformIds)
        }
        if (ver older "24.0.0") {
            register(::handleGetXuids)
            register(::handleUpdateGamertag)
        }
        register(::handleGetOnlineUserInfo)
        register(::handleReportUser)
        if (ver older "24.6.0") {
            register(::handleXboxLiveOnlyEnable)
        }
        register(::handleBlockUser)
        register(::handleUnblockUser)
        register(::handleGetBlockedUsers)
        if (ver older "24.0.0") {
            register(::handleCreateTransferCode)
            register(::handleUseTransferCode)
        }
        register(::handleBonusPassBuyPass)
        register(::handleBonusPassValidateProductPurchase)
        if (ver newer "24.0.0") {
            register(::handleBonusPassBundleValidateProductPurchase)
        }
        register(::handleBonusPassFinishPass)
        if (ver newer "3.7.0") {
            register(::handlePiggyBankValidateProductPurchase)
            register(::handlePiggyBankClaimFreeTier)
            register(::handlePiggyBankExpireTier)
            register(::handlePiggyBankAddMoneyToBankCheat)
        }
        if (ver newer "3.8.0") {
            register(::handleLegendFundValidateProductPurchase)
        }
        if (ver newer "24.6.0") {
            register(::handleLegendFundCancelProductPurchase)
        }
        if (ver newer "3.8.0") {
            register(::handleLegendFundClaimMilestones)
            register(::handleLegendFundResetCheat)
            register(::handleLegendFundObtainCheat)
        }
        if (ver newer "24.0.0") {
            register(::handleIncreaseVaultTicketCheat)
            register(::handleConsumeVaultTicketCheat)
            register(::handleTriggerRefillVaultTicketByTimeCheat)
            register(::handleVaultCompleteStageCheat)
            register(::handleVaultRefillTickets)
            register(::handleVaultOccupySlot)
            register(::handleVaultDeoccupySlot)
            register(::handleVaultEventStartRace)
        }
        if (ver newer "24.6.0") {
            register(::handleVaultEventAutoplayStartRace)
        }
        if (ver newer "24.0.0") {
            register(::handleVaultEventFinishRace)
        }
        if (ver newer "24.6.0") {
            register(::handleVaultEventAutoplayFinishRace)
        }
        if (ver newer "24.0.0") {
            register(::handleVaultEventCancelRace)
            register(::handleVaultEventClaimProgressionRewards)
            register(::handleVaultExtendEvent)
            register(::handleVaultEventSkipSoloRewardConditions)
            register(::handleVaultGetRemoteVaultEventState)
            register(::handleVaultCleanCorruptSlot)
            register(::handleVaultNotifyAccomplishedEvent)
        }
        if (ver newer "24.0.0" && ver older "24.6.0") {
            register(::handleSeasonalCurrencyConvertCurrency)
        }
        if (ver newer "24.6.0") {
            register(::handleActivationConvertCurrency)
            register(::handleActivationBlackMarketGetStatus)
            register(::handleActivationRefreshBlackMarket)
            register(::handleActivationBlackMarketBuy)
        }
        if (ver newer "24.0.0") {
            register(::handleUpsellPopupBuyOffer)
            register(::handleUpsellPopupValidateProductPurchase)
        }
        if (ver newer "24.6.0") {
            register(::handleUpsellPopupCancelProductPurchase)
            register(::handleUpsellPopupShown)
        }
        if (ver newer "24.0.0") {
            register(::handleOverclockExpireEvent)
            register(::handleOverclockPurchaseOverclockForCar)
            register(::handleOverclockExpireCar)
        }
        if (ver newer "45.0.0") {
            register(::handleOverclockApplyOverclockForCarCheat)
        }
        if (ver newer "24.0.0") {
            register(::handleOverclockRemoveOverclockOfCarCheat)
            register(::handleOverclockGainOverclockChipsCheat)
            register(::handleOverclockResetOverclockChipsCheat)
            register(::handleSponsorshipSelectContract)
            register(::handleSponsorshipContractClaim)
            register(::handleSponsorshipContractFail)
            register(::handleProcessSponsorshipDailyLogin)
            register(::handleSaveObtainedAdsRewardDataIntoServerState)
            register(::handleClearAllObtainedAdsRewardDataInServerState)
            register(::handleCreateTransferCode)
            register(::handleLinkAccountWithTransferCode)
            register(::handleLinkAccountWithCredential)
        }
        if (ver newer "45.0.0") {
            register(::handleRelinkCredentials)
        }
        if (ver newer "24.0.0") {
            register(::handleConfirmLinkingOperation)
            register(::handlePostLoginSocialUpdate)
            register(::handleUpdateStatusLine)
            register(::handleListGameFriends)
            register(::handleRequestGameFriend)
            register(::handleRemoveGameFriend)
            register(::handleListGameFriendRequests)
            register(::handleAcceptGameFriendRequest)
            register(::handleRejectGameFriendRequest)
            register(::handleCancelSentGameFriendRequest)
            register(::handleSearchGameFriend)
            register(::handleListOneWayConnections)
            register(::handleAddOneWayConnection)
            register(::handleDeleteOneWayConnection)
            register(::handleBatchFilterExistingUsers)
            register(::handleGetCredentialsForConsoleUsers)
            register(::handleAcceptAllFriendRequests)
            register(::handleRejectAllFriendRequests)
        }
        if (ver newer "24.5.0") {
            register(::handleSetAllowFriendRequests)
            register(::handleSendChatMessage)
        }
        if (ver newer "24.0.0") {
            register(::handleProcessDLCIAPTransaction)
        }
        if (ver newer "24.6.0") {
            register(::handleListRegions)
            register(::handleGauntletStartEvent)
            register(::handleGauntletRefreshEvent)
            register(::handleGauntletRestartQualification)
            register(::handleGauntletFinishQualification)
            register(::handleGauntletLeaveQualification)
            register(::handleGauntletRerollOpponents)
            register(::handleGauntletRerollBannedOpponentsSet)
            register(::handleGauntletValidateRaceLog)
            register(::handleGauntletValidateEventAlreadyFinished)
            register(::handleGauntletStartChallenge)
            register(::handleGauntletStartRevenge)
            register(::handleGauntletSetChallengeCars)
            register(::handleGauntletStartRace)
            register(::handleGauntletFinishRace)
            register(::handleGauntletCancelRace)
            register(::handleGauntletBuyTicket)
            register(::handleGauntletLeaveChallenge)
            register(::handleGauntletFinishChallenge)
            register(::handleGauntletFinalClaim)
            register(::handleGauntletProcessPendingTransactions)
            register(::handleGauntletResetEventState)
            register(::handleGauntletUpdatePendingDataAndActions)
            register(::handleGauntletSetTicketsCheat)
            register(::handleGauntletFinishRaceCheat)
            register(::handleGauntletFinishChallengeCheat)
            register(::handleGauntletSetEloCheat)
            register(::handleGauntletAddChallengePointsCheat)
            register(::handleGauntletFakeOpponentsCheat)
            register(::handleGauntletResetStateCheat)
            register(::handleGauntletMarketRefreshCheat)
            register(::handleGauntletMarketBuy)
            register(::handleGauntletMarketRefresh)
            register(::handleClaimDailyVIPFreeGift)
            register(::handleVIPBlackMarketGetStatus)
            register(::handleRefreshVIPBlackMarket)
            register(::handleVIPBlackMarketBuy)
            register(::handleValidateVIPBundleProductPurchase)
            register(::handleJoinTournamentMatch)
            register(::handleQuitTournamentMatch)
            register(::handleGetTournamentMatchDetails)
            register(::handleUpdateTournamentMatchStatus)
            register(::handleTournamentCreateRoom)
            register(::handleTournamentJoinRoom)
            register(::handleTournamentUpdateUserData)
            register(::handleTournamentStartRace)
            register(::handleTournamentLaunchRoom)
            register(::handleTournamentFinishRace)
        }
        if (ver newer "45.0.0") {
            register(::handleTournamentCancelRace)
        }
        if (ver newer "24.6.0") {
            register(::handleTournamentNotifyReturnToLobby)
            register(::handleAllowAllPlatformTournamentCheat)
            register(::handleMockTournamentMatchCheat)
            register(::handleUserCustomizableBundleValidateProductPurchase)
            register(::handleValidateIAPVanityPurchase)
            register(::handleBuyCarVanityItem)
        }
    }

    @Suppress("unused")
    fun register(requestName: String? = null) {
        handlers += PacketHandler(
            requestName ?: "<unknown name>",
            RequestPacket::class,
            null,
        )
    }

    @Suppress("UNCHECKED_CAST")
    inline fun <reified T : RequestPacket> register(
        noinline handle: (suspend (GameConnection, T) -> Unit)
    ) {
        handlers += PacketHandler(
            T::class.java.simpleName,
            T::class,
            handle as suspend (GameConnection, RequestPacket) -> Unit,
        )
    }

    val gameDirectory = File(File(workingDirectory, "game"), "${ver.major}.${ver.minor}.${ver.build}")

    fun getConfig(): File {
        return File(gameDirectory, "clientconfig.json")
    }

    fun getGameDb(): File {
        return File(gameDirectory, "A9-business.gdb")
    }
}