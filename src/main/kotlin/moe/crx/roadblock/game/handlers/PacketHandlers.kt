package moe.crx.roadblock.game.handlers

import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.game.updates.UpdatesNode
import moe.crx.roadblock.game.updates.UpdatesTree
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.rpc.request.*
import moe.crx.roadblock.rpc.response.*
import moe.crx.roadblock.updates.inventory.InventoryCarMaintenanceBalanceChanged
import moe.crx.roadblock.updates.playerstats.PlayerStatsGameplayTutorialStateChanged
import moe.crx.roadblock.updates.playerstats.PlayerStatsMenuTutorialStateChanged
import moe.crx.roadblock.utils.toEnum

// TODO separate files

suspend fun handleActionLogin(session: GameConnection, request: ActionLoginRequest) {
    session.send(ActionLoginResponse())
}

suspend fun handleCareerStartRace(session: GameConnection, request: CareerStartRaceRequest) {
    val car = session.gameState.inventory.cars[RInt(request.carId)] ?: return // TODO return server error

    //TODO add LastUsageChanged
    val updates = UpdatesTree(
        UpdatesNode(
            InventoryCarMaintenanceBalanceChanged().apply {
                carId = request.carId
                oldSlots = car.maintenanceStats.maintenanceSlots
                newSlots = (car.maintenanceStats.maintenanceSlots - 1).toShort()
            }
        )
    ).flatten()

    car.maintenanceStats.maintenanceSlots = (car.maintenanceStats.maintenanceSlots - 1).toShort()

    session.saveState()

    session.send(CareerStartRaceResponse().apply { updatesQueue = updates })
}

suspend fun handleCareerFinishRace(session: GameConnection, request: CareerFinishRaceRequest) {
    session.send(CareerFinishRaceResponse())
}

suspend fun handleCareerCancelRace(session: GameConnection, request: CareerCancelRaceRequest) {
    session.send(CareerCancelRaceResponse())
}

suspend fun handleTutorialFinishRace(session: GameConnection, request: TutorialFinishRaceRequest) {
    session.send(TutorialFinishRaceResponse())
}

suspend fun handleClaimSatelliteReward(session: GameConnection, request: ClaimSatelliteRewardRequest) {
    session.send(ClaimSatelliteRewardResponse())
}

suspend fun handleCompleteCareerSeasonCheat(session: GameConnection, request: CompleteCareerSeasonCheatRequest) {
    session.send(CompleteCareerSeasonCheatResponse())
}

suspend fun handleGainEventFlagCheat(session: GameConnection, request: GainEventFlagCheatRequest) {
    session.send(GainEventFlagCheatResponse())
}

suspend fun handleUnlockAllChaptersCheat(session: GameConnection, request: UnlockAllChaptersCheatRequest) {
    session.send(UnlockAllChaptersCheatResponse())
}

suspend fun handleUnlockAllSeasonsCheat(session: GameConnection, request: UnlockAllSeasonsCheatRequest) {
    session.send(UnlockAllSeasonsCheatResponse())
}

suspend fun handleBuyCar(session: GameConnection, request: BuyCarRequest) {
    session.send(BuyCarResponse())
}

suspend fun handleSetPreferredCarVisual(session: GameConnection, request: SetPreferredCarVisualRequest) {
    session.send(SetPreferredCarVisualResponse())
}

suspend fun handleMaintenanceStartRefill(session: GameConnection, request: MaintenanceStartRefillRequest) {
    session.send(MaintenanceStartRefillResponse())
}

suspend fun handleMaintenanceSkipRefillWithTokens(
    session: GameConnection,
    request: MaintenanceSkipRefillWithTokensRequest
) {
    session.send(MaintenanceSkipRefillWithTokensResponse())
}

suspend fun handleMaintenanceSkipRefillWithBonusPassBenefit(
    session: GameConnection,
    request: MaintenanceSkipRefillWithBonusPassBenefitRequest
) {
    session.send(MaintenanceSkipRefillWithBonusPassBenefitResponse())
}

suspend fun handleMaintenanceValidateRefill(session: GameConnection, request: MaintenanceValidateRefillRequest) {
    session.send(MaintenanceValidateRefillResponse())
}

suspend fun handleUnlockUpgradeTier(session: GameConnection, request: UnlockUpgradeTierRequest) {
    session.send(UnlockUpgradeTierResponse())
}

suspend fun handleUpgradeCarStatLevel(session: GameConnection, request: UpgradeCarStatLevelRequest) {
    session.send(UpgradeCarStatLevelResponse())
}

suspend fun handleFreeUpgradeCarStatLevel(session: GameConnection, request: FreeUpgradeCarStatLevelRequest) {
    session.send(FreeUpgradeCarStatLevelResponse())
}

suspend fun handleInstallUpgradeItem(session: GameConnection, request: InstallUpgradeItemRequest) {
    session.send(InstallUpgradeItemResponse())
}

suspend fun handleConvertWildcardBlueprints(session: GameConnection, request: ConvertWildcardBlueprintsRequest) {
    session.send(ConvertWildcardBlueprintsResponse())
}

suspend fun handleTrashItem(session: GameConnection, request: TrashItemRequest) {
    session.send(TrashItemResponse())
}

suspend fun handleGainAllCarItemsCheat(session: GameConnection, request: GainAllCarItemsCheatRequest) {
    session.send(GainAllCarItemsCheatResponse())
}

suspend fun handleGainAllCarsCheat(session: GameConnection, request: GainAllCarsCheatRequest) {
    session.send(GainAllCarsCheatResponse())
}

suspend fun handleGainCurrencyCheat(session: GameConnection, request: GainCurrencyCheatRequest) {
    session.send(GainCurrencyCheatResponse())
}

suspend fun handleGainCarBlueprintsCheat(session: GameConnection, request: GainCarBlueprintsCheatRequest) {
    session.send(GainCarBlueprintsCheatResponse())
}

suspend fun handleGainWildcardBlueprintsCheat(session: GameConnection, request: GainWildcardBlueprintsCheatRequest) {
    session.send(GainWildcardBlueprintsCheatResponse())
}

suspend fun handleGainCarEvoBlueprintsCheat(session: GameConnection, request: GainCarEvoBlueprintsCheatRequest) {
    session.send(GainCarEvoBlueprintsCheatResponse())
}

suspend fun handleSaveEmojiConfiguration(session: GameConnection, request: SaveEmojiConfigurationRequest) {
    session.send(SaveEmojiConfigurationResponse())
}

suspend fun handleBuyGachaBox(session: GameConnection, request: BuyGachaBoxRequest) {
    session.send(BuyGachaBoxResponse())
}

suspend fun handleBuyTimeLimitedGachaBox(session: GameConnection, request: BuyTimeLimitedGachaBoxRequest) {
    session.send(BuyTimeLimitedGachaBoxResponse())
}

suspend fun handleClaimLevelUpGachaBoxes(session: GameConnection, request: ClaimLevelUpGachaBoxesRequest) {
    session.send(ClaimLevelUpGachaBoxesResponse())
}

suspend fun handleClaimMissionReward(session: GameConnection, request: ClaimMissionRewardRequest) {
    session.send(ClaimMissionRewardResponse())
}

suspend fun handleChangeMenuTutorialState(session: GameConnection, request: ChangeMenuTutorialStateRequest) {
    val updates = UpdatesTree(
        UpdatesNode(
            PlayerStatsMenuTutorialStateChanged().apply {
                type = request.menuTutorialType
                oldState = session.gameState.playerStats.menuTutorials[request.menuTutorialType.ordinal].value.toEnum()
                newState = request.tutorialState
            }
        )
    ).flatten()

    session.gameState.playerStats.apply {
        menuTutorials = menuTutorials.toMutableList().apply {
            this[request.menuTutorialType.ordinal] = RInt().apply {
                value = request.tutorialState.ordinal
            }
        }
    }

    session.saveState()

    session.send(ChangeMenuTutorialStateResponse().apply { updatesQueue = updates })
}

suspend fun handleChangeGameplayTutorialState(session: GameConnection, request: ChangeGameplayTutorialStateRequest) {
    val updates = UpdatesTree(
        UpdatesNode(
            PlayerStatsGameplayTutorialStateChanged().apply {
                type = request.gameplayTutorialType
                oldState =
                    session.gameState.playerStats.gameplayTutorials[request.gameplayTutorialType.ordinal].value.toEnum()
                newState = request.tutorialState
            }
        )
    ).flatten()

    session.gameState.playerStats.apply {
        gameplayTutorials = gameplayTutorials.toMutableList().apply {
            this[request.gameplayTutorialType.ordinal] = RInt().apply {
                value = request.tutorialState.ordinal
            }
        }
    }

    session.saveState()

    session.send(ChangeGameplayTutorialStateResponse().apply { updatesQueue = updates })
}

suspend fun handleGainGarageLevelCheat(session: GameConnection, request: GainGarageLevelCheatRequest) {
    session.send(GainGarageLevelCheatResponse())
}

suspend fun handleGainGarageValueCheat(session: GameConnection, request: GainGarageValueCheatRequest) {
    session.send(GainGarageValueCheatResponse())
}

suspend fun handleBlackMarketGetStatus(session: GameConnection, request: BlackMarketGetStatusRequest) {
    session.send(BlackMarketGetStatusResponse())
}

suspend fun handleBlackMarketBuy(session: GameConnection, request: BlackMarketBuyRequest) {
    session.send(BlackMarketBuyResponse())
}

suspend fun handleBlackMarketRefresh(session: GameConnection, request: BlackMarketRefreshRequest) {
    session.send(BlackMarketRefreshResponse())
}

suspend fun handleMultiplayerSeriesCancelMatchmaking(
    session: GameConnection,
    request: MultiplayerSeriesCancelMatchmakingRequest
) {
    session.send(MultiplayerSeriesCancelMatchmakingResponse())
}

suspend fun handleMultiplayerSeriesCancelRace(session: GameConnection, request: MultiplayerSeriesCancelRaceRequest) {
    session.send(MultiplayerSeriesCancelRaceResponse())
}

suspend fun handleMultiplayerSeriesClaimRewards(
    session: GameConnection,
    request: MultiplayerSeriesClaimRewardsRequest
) {
    session.send(MultiplayerSeriesClaimRewardsResponse())
}

suspend fun handleMultiplayerSeriesFinishRace(session: GameConnection, request: MultiplayerSeriesFinishRaceRequest) {
    session.send(MultiplayerSeriesFinishRaceResponse())
}

suspend fun handleMultiplayerSeriesRefreshClaimState(
    session: GameConnection,
    request: MultiplayerSeriesRefreshClaimStateRequest
) {
    session.send(MultiplayerSeriesRefreshClaimStateResponse())
}

suspend fun handleMultiplayerSeriesRequestRevertOfMaintenanceBooking(
    session: GameConnection,
    request: MultiplayerSeriesRequestRevertOfMaintenanceBookingRequest
) {
    session.send(MultiplayerSeriesRequestRevertOfMaintenanceBookingResponse())
}

suspend fun handleMultiplayerSeriesResetCurrentEventCheat(
    session: GameConnection,
    request: MultiplayerSeriesResetCurrentEventCheatRequest
) {
    session.send(MultiplayerSeriesResetCurrentEventCheatResponse())
}

suspend fun handleMultiplayerSeriesResetMaxTierCheat(
    session: GameConnection,
    request: MultiplayerSeriesResetMaxTierCheatRequest
) {
    session.send(MultiplayerSeriesResetMaxTierCheatResponse())
}

suspend fun handleMultiplayerSeriesSetEloCheat(session: GameConnection, request: MultiplayerSeriesSetEloCheatRequest) {
    session.send(MultiplayerSeriesSetEloCheatResponse())
}

suspend fun handleMultiplayerSeriesStartMatchmaking(
    session: GameConnection,
    request: MultiplayerSeriesStartMatchmakingRequest
) {
    session.send(MultiplayerSeriesStartMatchmakingResponse())
}

suspend fun handleMultiplayerSeriesStartRace(session: GameConnection, request: MultiplayerSeriesStartRaceRequest) {
    session.send(MultiplayerSeriesStartRaceResponse())
}

suspend fun handleMultiplayerSeriesSyncRaces(session: GameConnection, request: MultiplayerSeriesSyncRacesRequest) {
    session.send(MultiplayerSeriesSyncRacesResponse())
}

suspend fun handleMultiplayerSeriesReportUser(session: GameConnection, request: MultiplayerSeriesReportUserRequest) {
    session.send(MultiplayerSeriesReportUserResponse())
}

suspend fun handleCreateClub(session: GameConnection, request: CreateClubRequest) {
    session.send(CreateClubResponse())
}

suspend fun handleEditClub(session: GameConnection, request: EditClubRequest) {
    session.send(EditClubResponse())
}

suspend fun handleLeaveClub(session: GameConnection, request: LeaveClubRequest) {
    session.send(LeaveClubResponse())
}

suspend fun handleRequestJoinClub(session: GameConnection, request: RequestJoinClubRequest) {
    session.send(RequestJoinClubResponse())
}

suspend fun handleAcceptClubRequest(session: GameConnection, request: AcceptClubRequestRequest) {
    session.send(AcceptClubRequestResponse())
}

suspend fun handleRejectClubRequest(session: GameConnection, request: RejectClubRequestRequest) {
    session.send(RejectClubRequestResponse())
}

suspend fun handlePromoteClubMember(session: GameConnection, request: PromoteClubMemberRequest) {
    session.send(PromoteClubMemberResponse())
}

suspend fun handleDemoteClubMember(session: GameConnection, request: DemoteClubMemberRequest) {
    session.send(DemoteClubMemberResponse())
}

suspend fun handleKickClubMember(session: GameConnection, request: KickClubMemberRequest) {
    session.send(KickClubMemberResponse())
}

suspend fun handleClaimClubSeasonMilestone(session: GameConnection, request: ClaimClubSeasonMilestoneRequest) {
    session.send(ClaimClubSeasonMilestoneResponse())
}

suspend fun handleClaimCurrentClubSeason(session: GameConnection, request: ClaimCurrentClubSeasonRequest) {
    session.send(ClaimCurrentClubSeasonResponse())
}

suspend fun handleClaimPreviousClubSeasons(session: GameConnection, request: ClaimPreviousClubSeasonsRequest) {
    session.send(ClaimPreviousClubSeasonsResponse())
}

suspend fun handleRefreshClubState(session: GameConnection, request: RefreshClubStateRequest) {
    session.send(RefreshClubStateResponse())
}

suspend fun handleFindOnlineUserByAlias(session: GameConnection, request: FindOnlineUserByAliasRequest) {
    session.send(FindOnlineUserByAliasResponse())
}

suspend fun handleInviteUser(session: GameConnection, request: InviteUserRequest) {
    session.send(InviteUserResponse())
}

suspend fun handleAcceptClubInvitation(session: GameConnection, request: AcceptClubInvitationRequest) {
    session.send(AcceptClubInvitationResponse())
}

suspend fun handleDeclineClubInvitation(session: GameConnection, request: DeclineClubInvitationRequest) {
    session.send(DeclineClubInvitationResponse())
}

suspend fun handleClubRaceCancelRace(session: GameConnection, request: ClubRaceCancelRaceRequest) {
    session.send(ClubRaceCancelRaceResponse())
}

suspend fun handleClubRaceCreateRoom(session: GameConnection, request: ClubRaceCreateRoomRequest) {
    session.send(ClubRaceCreateRoomResponse())
}

suspend fun handleClubRaceFinishRace(session: GameConnection, request: ClubRaceFinishRaceRequest) {
    session.send(ClubRaceFinishRaceResponse())
}

suspend fun handleClubRaceJoinRoom(session: GameConnection, request: ClubRaceJoinRoomRequest) {
    session.send(ClubRaceJoinRoomResponse())
}

suspend fun handleClubRaceNotifyRoomJoined(session: GameConnection, request: ClubRaceNotifyRoomJoinedRequest) {
    session.send(ClubRaceNotifyRoomJoinedResponse())
}

suspend fun handleClubRaceNotifyRoomJoinFailed(session: GameConnection, request: ClubRaceNotifyRoomJoinFailedRequest) {
    session.send(ClubRaceNotifyRoomJoinFailedResponse())
}

suspend fun handleClubRaceNotifyRoomLeft(session: GameConnection, request: ClubRaceNotifyRoomLeftRequest) {
    session.send(ClubRaceNotifyRoomLeftResponse())
}

suspend fun handleClubRaceStartRace(session: GameConnection, request: ClubRaceStartRaceRequest) {
    session.send(ClubRaceStartRaceResponse())
}

suspend fun handleMiscellaneousSetUserName(session: GameConnection, request: MiscellaneousSetUserNameRequest) {
    session.send(MiscellaneousSetUserNameResponse())
}

suspend fun handleMiscellaneousSetUserAgeAndGender(
    session: GameConnection,
    request: MiscellaneousSetUserAgeAndGenderRequest
) {
    session.send(MiscellaneousSetUserAgeAndGenderResponse())
}

suspend fun handleMiscellaneousSetUserOnlinePrivacyPolicy(
    session: GameConnection,
    request: MiscellaneousSetUserOnlinePrivacyPolicyRequest
) {
    session.send(MiscellaneousSetUserOnlinePrivacyPolicyResponse())
}

suspend fun handleMiscellaneousSetConsentNoticeShown(
    session: GameConnection,
    request: MiscellaneousSetConsentNoticeShownRequest
) {
    session.send(MiscellaneousSetConsentNoticeShownResponse())
}

suspend fun handleSaveGameSettings(
    session: GameConnection,
    request: SaveGameSettingsRequest
) {
    session.gameState.miscellaneous.gameSettings = request.settings

    session.saveState()

    // TODO Updates
    session.send(SaveGameSettingsResponse())
}

suspend fun handleMiscellaneousSetPlatform(session: GameConnection, request: MiscellaneousSetPlatformRequest) {
    session.send(MiscellaneousSetPlatformResponse())
}

suspend fun handleMiscellaneousSetUniqueUserName(
    session: GameConnection,
    request: MiscellaneousSetUniqueUserNameRequest
) {
    session.send(MiscellaneousSetUniqueUserNameResponse())
}

suspend fun handlePerformCheat(session: GameConnection, request: PerformCheatRequest) {
    session.send(PerformCheatResponse())
}

suspend fun handlePurchaseOfflineProduct(
    session: GameConnection,
    request: PurchaseOfflineProductRequest
) {
    session.send(PurchaseOfflineProductResponse())
}

suspend fun handleIAPFakePurchaseCheat(session: GameConnection, request: IAPFakePurchaseCheatRequest) {
    session.send(IAPFakePurchaseCheatResponse())
}

suspend fun handleProcessPendingSeshatAdTransaction(
    session: GameConnection,
    request: ProcessPendingSeshatAdTransactionRequest
) {
    session.send(ProcessPendingSeshatAdTransactionResponse())
}

suspend fun handleProcessPendingSeshatGiftTransaction(
    session: GameConnection,
    request: ProcessPendingSeshatGiftTransactionRequest
) {
    session.send(ProcessPendingSeshatGiftTransactionResponse())
}

suspend fun handleProcessPendingSeshatIAPTransaction(
    session: GameConnection,
    request: ProcessPendingSeshatIAPTransactionRequest
) {
    session.send(ProcessPendingSeshatIAPTransactionResponse())
}

suspend fun handleProcessPendingSeshatRefundTransaction(
    session: GameConnection,
    request: ProcessPendingSeshatRefundTransactionRequest
) {
    session.send(ProcessPendingSeshatRefundTransactionResponse())
}

suspend fun handleProcessPendingSeshatTransactions(
    session: GameConnection,
    request: ProcessPendingSeshatTransactionsRequest
) {
    session.send(ProcessPendingSeshatTransactionsResponse())
}

suspend fun handleClaimAdClientSideRewards(session: GameConnection, request: ClaimAdClientSideRewardsRequest) {
    session.send(ClaimAdClientSideRewardsResponse())
}

suspend fun handleCurrencyPackValidatePurchase(session: GameConnection, request: CurrencyPackValidatePurchaseRequest) {
    session.send(CurrencyPackValidatePurchaseResponse())
}

suspend fun handlePromotionValidatePurchase(session: GameConnection, request: PromotionValidatePurchaseRequest) {
    session.send(PromotionValidatePurchaseResponse())
}

suspend fun handleTLETicketsCheat(session: GameConnection, request: TLETicketsCheatRequest) {
    session.send(TLETicketsCheatResponse())
}

suspend fun handleTLEventCancelRace(session: GameConnection, request: TLEventCancelRaceRequest) {
    session.send(TLEventCancelRaceResponse())
}

suspend fun handleTLEventClaimClubReward(session: GameConnection, request: TLEventClaimClubRewardRequest) {
    session.send(TLEventClaimClubRewardResponse())
}

suspend fun handleTLEventClaimRankRewards(session: GameConnection, request: TLEventClaimRankRewardsRequest) {
    session.send(TLEventClaimRankRewardsResponse())
}

suspend fun handleTLEventCompleteCheat(session: GameConnection, request: TLEventCompleteCheatRequest) {
    session.send(TLEventCompleteCheatResponse())
}

suspend fun handleTLEventFinishRace(session: GameConnection, request: TLEventFinishRaceRequest) {
    session.send(TLEventFinishRaceResponse())
}

suspend fun handleTLEventRefillTickets(session: GameConnection, request: TLEventRefillTicketsRequest) {
    session.send(TLEventRefillTicketsResponse())
}

suspend fun handleTLEventRefreshClaimState(session: GameConnection, request: TLEventRefreshClaimStateRequest) {
    session.send(TLEventRefreshClaimStateResponse())
}

suspend fun handleTLEventSkipClubRewardContidion(
    session: GameConnection,
    request: TLEventSkipClubRewardConditionRequest
) {
    session.send(TLEventSkipClubRewardConditionResponse())
}

suspend fun handleTLEventSkipSoloRewardContidion(
    session: GameConnection,
    request: TLEventSkipSoloRewardConditionRequest
) {
    session.send(TLEventSkipSoloRewardConditionResponse())
}

suspend fun handleTLEventStartRace(session: GameConnection, request: TLEventStartRaceRequest) {
    session.send(TLEventStartRaceResponse())
}

suspend fun handleTLEventClaimPreviousSpecialEvent(
    session: GameConnection,
    request: TLEventClaimPreviousSpecialEventRequest
) {
    session.send(TLEventClaimPreviousSpecialEventResponse())
}

suspend fun handleTimeLimitedSpecialEventClaimProgressionReward(
    session: GameConnection,
    request: TimeLimitedSpecialEventClaimProgressionRewardRequest
) {
    session.send(TimeLimitedSpecialEventClaimProgressionRewardResponse())
}

suspend fun handleTLEventAutoclaimRewards(session: GameConnection, request: TLEventAutoclaimRewardsRequest) {
    session.send(TLEventAutoclaimRewardsResponse())
}

suspend fun handleTLEventResetNitroGhost(session: GameConnection, request: TLEventResetNitroGhostRequest) {
    session.send(TLEventResetNitroGhostResponse())
}

suspend fun handleTLEventResetCheat(session: GameConnection, request: TLEventResetCheatRequest) {
    session.send(TLEventResetCheatResponse())
}

suspend fun handleRetrievePlaybackCheat(session: GameConnection, request: RetrievePlaybackCheatRequest) {
    session.send(RetrievePlaybackCheatResponse())
}

suspend fun handleForceConfigRefresh(session: GameConnection, request: ForceConfigRefreshRequest) {
    session.send(ForceConfigRefreshResponse())
}

suspend fun handleGetRemoteAccountConflictData(session: GameConnection, request: GetRemoteAccountConflictDataRequest) {
    session.send(GetRemoteAccountConflictDataResponse())
}

suspend fun handleClaimGift(session: GameConnection, request: ClaimGiftRequest) {
    session.send(ClaimGiftResponse())
}

suspend fun handleClaimIrisRedeemCode(session: GameConnection, request: ClaimIrisRedeemCodeRequest) {
    session.send(ClaimIrisRedeemCodeResponse())
}

suspend fun handleClaimDynamicReward(session: GameConnection, request: ClaimDynamicRewardRequest) {
    session.send(ClaimDynamicRewardResponse())
}

suspend fun handleResetUserState(session: GameConnection, request: ResetUserStateRequest) {
    session.send(ResetUserStateResponse())
}

suspend fun handleClaimEnableNotificationsReward(
    session: GameConnection,
    request: ClaimEnableNotificationsRewardRequest
) {
    session.send(ClaimEnableNotificationsRewardResponse())
}

suspend fun handleClaimDailyTasks(session: GameConnection, request: ClaimDailyTasksRequest) {
    session.send(ClaimDailyTasksResponse())
}

suspend fun handleDailyTasksReset(session: GameConnection, request: DailyTasksResetRequest) {
    session.send(DailyTasksResetResponse())
}

suspend fun handleBuyRelayOfferTier(session: GameConnection, request: BuyRelayOfferTierRequest) {
    session.send(BuyRelayOfferTierResponse())
}

suspend fun handleValidateIAPRelayOfferPurchase(
    session: GameConnection,
    request: ValidateIAPRelayOfferPurchaseRequest
) {
    session.send(ValidateIAPRelayOfferPurchaseResponse())
}

suspend fun handleSplitScreenStartRace(session: GameConnection, request: SplitScreenStartRaceRequest) {
    session.send(SplitScreenStartRaceResponse())
}

suspend fun handleUberSpecialEventDiscoverMissionCars(
    session: GameConnection,
    request: UberSpecialEventDiscoverMissionCarsRequest
) {
    session.send(UberSpecialEventDiscoverMissionCarsResponse())
}

suspend fun handleUberSpecialEventStartRace(session: GameConnection, request: UberSpecialEventStartRaceRequest) {
    session.send(UberSpecialEventStartRaceResponse())
}

suspend fun handleUberSpecialEventCancelRace(session: GameConnection, request: UberSpecialEventCancelRaceRequest) {
    session.send(UberSpecialEventCancelRaceResponse())
}

suspend fun handleUberSpecialEventRegisterFinishRace(
    session: GameConnection,
    request: UberSpecialEventRegisterFinishRaceRequest
) {
    session.send(UberSpecialEventRegisterFinishRaceResponse())
}

suspend fun handleUberSpecialEventRetryRace(session: GameConnection, request: UberSpecialEventRetryRaceRequest) {
    session.send(UberSpecialEventRetryRaceResponse())
}

suspend fun handleUberSpecialEventCommitResultsRace(
    session: GameConnection,
    request: UberSpecialEventCommitResultsRaceRequest
) {
    session.send(UberSpecialEventCommitResultsRaceResponse())
}

suspend fun handleUberSpecialEventSkipMission(session: GameConnection, request: UberSpecialEventSkipMissionRequest) {
    session.send(UberSpecialEventSkipMissionResponse())
}

suspend fun handleUberSpecialEventCleanHazard(session: GameConnection, request: UberSpecialEventCleanHazardRequest) {
    session.send(UberSpecialEventCleanHazardResponse())
}

suspend fun handleUberSpecialEventMarketBuy(session: GameConnection, request: UberSpecialEventMarketBuyRequest) {
    session.send(UberSpecialEventMarketBuyResponse())
}

suspend fun handleUberSpecialEventFinalClaim(session: GameConnection, request: UberSpecialEventFinalClaimRequest) {
    session.send(UberSpecialEventFinalClaimResponse())
}

suspend fun handleChampionshipSpecialEventStartQualifyingPracticeRace(
    session: GameConnection,
    request: ChampionshipSpecialEventStartQualifyingPracticeRaceRequest
) {
    session.send(ChampionshipSpecialEventStartQualifyingPracticeRaceResponse())
}

suspend fun handleChampionshipSpecialEventFinishQualifyingPracticeRace(
    session: GameConnection,
    request: ChampionshipSpecialEventFinishQualifyingPracticeRaceRequest
) {
    session.send(ChampionshipSpecialEventFinishQualifyingPracticeRaceResponse())
}

suspend fun handleChampionshipSpecialEventStartQualifyingRace(
    session: GameConnection,
    request: ChampionshipSpecialEventStartQualifyingRaceRequest
) {
    session.send(ChampionshipSpecialEventStartQualifyingRaceResponse())
}

suspend fun handleChampionshipSpecialEventFinishQualifyingRace(
    session: GameConnection,
    request: ChampionshipSpecialEventFinishQualifyingRaceRequest
) {
    session.send(ChampionshipSpecialEventFinishQualifyingRaceResponse())
}

suspend fun handleChampionshipSpecialEventStartFinalsPracticeRace(
    session: GameConnection,
    request: ChampionshipSpecialEventStartFinalsPracticeRaceRequest
) {
    session.send(ChampionshipSpecialEventStartFinalsPracticeRaceResponse())
}

suspend fun handleChampionshipSpecialEventFinishFinalsPracticeRace(
    session: GameConnection,
    request: ChampionshipSpecialEventFinishFinalsPracticeRaceRequest
) {
    session.send(ChampionshipSpecialEventFinishFinalsPracticeRaceResponse())
}

suspend fun handleChampionshipSpecialEventStartFinalsRace(
    session: GameConnection,
    request: ChampionshipSpecialEventStartFinalsRaceRequest
) {
    session.send(ChampionshipSpecialEventStartFinalsRaceResponse())
}

suspend fun handleChampionshipSpecialEventFinishFinalsRace(
    session: GameConnection,
    request: ChampionshipSpecialEventFinishFinalsRaceRequest
) {
    session.send(ChampionshipSpecialEventFinishFinalsRaceResponse())
}

suspend fun handleChampionshipSpecialEventCancelRace(
    session: GameConnection,
    request: ChampionshipSpecialEventCancelRaceRequest
) {
    session.send(ChampionshipSpecialEventCancelRaceResponse())
}

suspend fun handleChampionshipSpecialEventRefreshQualifyingRoundGroup(
    session: GameConnection,
    request: ChampionshipSpecialEventRefreshQualifyingRoundGroupRequest
) {
    session.send(ChampionshipSpecialEventRefreshQualifyingRoundGroupResponse())
}

suspend fun handleChampionshipSpecialEventRefreshQualifyingRoundState(
    session: GameConnection,
    request: ChampionshipSpecialEventRefreshQualifyingRoundStateRequest
) {
    session.send(ChampionshipSpecialEventRefreshQualifyingRoundStateResponse())
}

suspend fun handleChampionshipSpecialEventRefreshFinalsGroup(
    session: GameConnection,
    request: ChampionshipSpecialEventRefreshFinalsGroupRequest
) {
    session.send(ChampionshipSpecialEventRefreshFinalsGroupResponse())
}

suspend fun handleChampionshipSpecialEventRefreshFinalsRoundState(
    session: GameConnection,
    request: ChampionshipSpecialEventRefreshFinalsRoundStateRequest
) {
    session.send(ChampionshipSpecialEventRefreshFinalsRoundStateResponse())
}

suspend fun handleChampionshipSpecialEventSkipReward(
    session: GameConnection,
    request: ChampionshipSpecialEventSkipRewardRequest
) {
    session.send(ChampionshipSpecialEventSkipRewardResponse())
}

suspend fun handleChampionshipSpecialEventBuyQualification(
    session: GameConnection,
    request: ChampionshipSpecialEventBuyQualificationRequest
) {
    session.send(ChampionshipSpecialEventBuyQualificationResponse())
}

suspend fun handleChampionshipSpecialEventRefreshClaimState(
    session: GameConnection,
    request: ChampionshipSpecialEventRefreshClaimStateRequest
) {
    session.send(ChampionshipSpecialEventRefreshClaimStateResponse())
}

suspend fun handleChampionshipSpecialEventClaimRankRewards(
    session: GameConnection,
    request: ChampionshipSpecialEventClaimRankRewardsRequest
) {
    session.send(ChampionshipSpecialEventClaimRankRewardsResponse())
}

suspend fun handleChampionshipSpecialEventClaimFreePack(
    session: GameConnection,
    request: ChampionshipSpecialEventClaimFreePackRequest
) {
    session.send(ChampionshipSpecialEventClaimFreePackResponse())
}

suspend fun handleChampionshipSpecialEventSyncServices(
    session: GameConnection,
    request: ChampionshipSpecialEventSyncServicesRequest
) {
    session.send(ChampionshipSpecialEventSyncServicesResponse())
}

suspend fun handleChampionshipSpecialEventResetNitroGhost(
    session: GameConnection,
    request: ChampionshipSpecialEventResetNitroGhostRequest
) {
    session.send(ChampionshipSpecialEventResetNitroGhostResponse())
}

suspend fun handleSeasonPassBuyTier(session: GameConnection, request: SeasonPassBuyTierRequest) {
    session.send(SeasonPassBuyTierResponse())
}

suspend fun handleSeasonPassClaimPendingRewards(
    session: GameConnection,
    request: SeasonPassClaimPendingRewardsRequest
) {
    session.send(SeasonPassClaimPendingRewardsResponse())
}

suspend fun handleSeasonPassClaimEpisodePartialCompletionRewards(
    session: GameConnection,
    request: SeasonPassClaimEpisodePartialCompletionRewardsRequest
) {
    session.send(SeasonPassClaimEpisodePartialCompletionRewardsResponse())
}

suspend fun handleSeasonPassClaimEpisodesCompletionRewards(
    session: GameConnection,
    request: SeasonPassClaimEpisodesCompletionRewardsRequest
) {
    session.send(SeasonPassClaimEpisodesCompletionRewardsResponse())
}

suspend fun handleSeasonPassValidateProductPurchase(
    session: GameConnection,
    request: SeasonPassValidateProductPurchaseRequest
) {
    session.send(SeasonPassValidateProductPurchaseResponse())
}

suspend fun handleSeasonPassSetPlayedOnboardingCheat(
    session: GameConnection,
    request: SeasonPassSetPlayedOnboardingCheatRequest
) {
    session.send(SeasonPassSetPlayedOnboardingCheatResponse())
}

suspend fun handleMultiplayerChallengesBuyEntry(
    session: GameConnection,
    request: MultiplayerChallengesBuyEntryRequest
) {
    session.send(MultiplayerChallengesBuyEntryResponse())
}

suspend fun handleMultiplayerChallengesRevealMoreSponsors(
    session: GameConnection,
    request: MultiplayerChallengesRevealMoreSponsorsRequest
) {
    session.send(MultiplayerChallengesRevealMoreSponsorsResponse())
}

suspend fun handleMultiplayerChallengesSelectSponsor(
    session: GameConnection,
    request: MultiplayerChallengesSelectSponsorRequest
) {
    session.send(MultiplayerChallengesSelectSponsorResponse())
}

suspend fun handleMultiplayerChallengesReviveRound(
    session: GameConnection,
    request: MultiplayerChallengesReviveRoundRequest
) {
    session.send(MultiplayerChallengesReviveRoundResponse())
}

suspend fun handleMultiplayerChallengesFinishRound(
    session: GameConnection,
    request: MultiplayerChallengesFinishRoundRequest
) {
    session.send(MultiplayerChallengesFinishRoundResponse())
}

suspend fun handleMultiplayerChallengesClaimReward(
    session: GameConnection,
    request: MultiplayerChallengesClaimRewardRequest
) {
    session.send(MultiplayerChallengesClaimRewardResponse())
}

suspend fun handleMultiplayerChallengesStartMatchmaking(
    session: GameConnection,
    request: MultiplayerChallengesStartMatchmakingRequest
) {
    session.send(MultiplayerChallengesStartMatchmakingResponse())
}

suspend fun handleMultiplayerChallengesCancelMatchmaking(
    session: GameConnection,
    request: MultiplayerChallengesCancelMatchmakingRequest
) {
    session.send(MultiplayerChallengesCancelMatchmakingResponse())
}

suspend fun handleMultiplayerChallengesStartRace(
    session: GameConnection,
    request: MultiplayerChallengesStartRaceRequest
) {
    session.send(MultiplayerChallengesStartRaceResponse())
}

suspend fun handleMultiplayerChallengesFinishRace(
    session: GameConnection,
    request: MultiplayerChallengesFinishRaceRequest
) {
    session.send(MultiplayerChallengesFinishRaceResponse())
}

suspend fun handleMultiplayerChallengesCancelRace(
    session: GameConnection,
    request: MultiplayerChallengesCancelRaceRequest
) {
    session.send(MultiplayerChallengesCancelRaceResponse())
}

suspend fun handleMultiplayerChallengesSyncRaces(
    session: GameConnection,
    request: MultiplayerChallengesSyncRacesRequest
) {
    session.send(MultiplayerChallengesSyncRacesResponse())
}

suspend fun handleMultiplayerChallengesReportUser(
    session: GameConnection,
    request: MultiplayerChallengesReportUserRequest
) {
    session.send(MultiplayerChallengesReportUserResponse())
}

suspend fun handleMultiplayerChallengesSkipCooldown(
    session: GameConnection,
    request: MultiplayerChallengesSkipCooldownRequest
) {
    session.send(MultiplayerChallengesSkipCooldownResponse())
}

suspend fun handleClubWarsRegister(session: GameConnection, request: ClubWarsRegisterRequest) {
    session.send(ClubWarsRegisterResponse())
}

suspend fun handleClubWarsRefreshRegistration(session: GameConnection, request: ClubWarsRefreshRegistrationRequest) {
    session.send(ClubWarsRefreshRegistrationResponse())
}

suspend fun handleClubWarsProcessMatchmaking(session: GameConnection, request: ClubWarsProcessMatchmakingRequest) {
    session.send(ClubWarsProcessMatchmakingResponse())
}

suspend fun handleClubWarsDefenseStartRace(session: GameConnection, request: ClubWarsDefenseStartRaceRequest) {
    session.send(ClubWarsDefenseStartRaceResponse())
}

suspend fun handleClubWarsDefenseFinishRace(session: GameConnection, request: ClubWarsDefenseFinishRaceRequest) {
    session.send(ClubWarsDefenseFinishRaceResponse())
}

suspend fun handleClubWarsDefenseCancelRace(session: GameConnection, request: ClubWarsDefenseCancelRaceRequest) {
    session.send(ClubWarsDefenseCancelRaceResponse())
}

suspend fun handleClubWarsDefenseAssignCar(session: GameConnection, request: ClubWarsDefenseAssignCarRequest) {
    session.send(ClubWarsDefenseAssignCarResponse())
}

suspend fun handleClubWarsDefenseOccupyNode(session: GameConnection, request: ClubWarsDefenseOccupyNodeRequest) {
    session.send(ClubWarsDefenseOccupyNodeResponse())
}

suspend fun handleClubWarsDefenseUnassignCar(session: GameConnection, request: ClubWarsDefenseUnassignCarRequest) {
    session.send(ClubWarsDefenseUnassignCarResponse())
}

suspend fun handleClubWarsDefenseVacateNode(session: GameConnection, request: ClubWarsDefenseVacateNodeRequest) {
    session.send(ClubWarsDefenseVacateNodeResponse())
}

suspend fun handleClubWarsPracticeStartRace(session: GameConnection, request: ClubWarsPracticeStartRaceRequest) {
    session.send(ClubWarsPracticeStartRaceResponse())
}

suspend fun handleClubWarsPracticeFinishRace(session: GameConnection, request: ClubWarsPracticeFinishRaceRequest) {
    session.send(ClubWarsPracticeFinishRaceResponse())
}

suspend fun handleClubWarsPracticeCancelRace(session: GameConnection, request: ClubWarsPracticeCancelRaceRequest) {
    session.send(ClubWarsPracticeCancelRaceResponse())
}

suspend fun handleClubWarsAttackStartRace(session: GameConnection, request: ClubWarsAttackStartRaceRequest) {
    session.send(ClubWarsAttackStartRaceResponse())
}

suspend fun handleClubWarsAttackFinishRace(session: GameConnection, request: ClubWarsAttackFinishRaceRequest) {
    session.send(ClubWarsAttackFinishRaceResponse())
}

suspend fun handleClubWarsAttackCancelRace(session: GameConnection, request: ClubWarsAttackCancelRaceRequest) {
    session.send(ClubWarsAttackCancelRaceResponse())
}

suspend fun handleClubWarsAttackConquerNode(session: GameConnection, request: ClubWarsAttackConquerNodeRequest) {
    session.send(ClubWarsAttackConquerNodeResponse())
}

suspend fun handleClubWarsAttackSelectEntryPoint(
    session: GameConnection,
    request: ClubWarsAttackSelectEntryPointRequest
) {
    session.send(ClubWarsAttackSelectEntryPointResponse())
}

suspend fun handleClubWarsRefreshRegions(session: GameConnection, request: ClubWarsRefreshRegionsRequest) {
    session.send(ClubWarsRefreshRegionsResponse())
}

suspend fun handleClubWarsRefreshNodes(session: GameConnection, request: ClubWarsRefreshNodesRequest) {
    session.send(ClubWarsRefreshNodesResponse())
}

suspend fun handleClubWarsFinishRound(session: GameConnection, request: ClubWarsFinishRoundRequest) {
    session.send(ClubWarsFinishRoundResponse())
}

suspend fun handleClubWarsClaimRound(session: GameConnection, request: ClubWarsClaimRoundRequest) {
    session.send(ClubWarsClaimRoundResponse())
}

suspend fun handleClubWarsRefreshClaimState(session: GameConnection, request: ClubWarsRefreshClaimStateRequest) {
    session.send(ClubWarsRefreshClaimStateResponse())
}

suspend fun handleClubWarsClaimRewards(session: GameConnection, request: ClubWarsClaimRewardsRequest) {
    session.send(ClubWarsClaimRewardsResponse())
}

suspend fun handleClubWarsMarketBuy(session: GameConnection, request: ClubWarsMarketBuyRequest) {
    session.send(ClubWarsMarketBuyResponse())
}

suspend fun handleClubWarsMarketRefresh(session: GameConnection, request: ClubWarsMarketRefreshRequest) {
    session.send(ClubWarsMarketRefreshResponse())
}

suspend fun handleInboxMarkAsRead(session: GameConnection, request: InboxMarkAsReadRequest) {
    session.send(InboxMarkAsReadResponse())
}

suspend fun handlePrivateLobbyCreateRoom(session: GameConnection, request: PrivateLobbyCreateRoomRequest) {
    session.send(PrivateLobbyCreateRoomResponse())
}

suspend fun handlePrivateLobbyJoinRoom(session: GameConnection, request: PrivateLobbyJoinRoomRequest) {
    session.send(PrivateLobbyJoinRoomResponse())
}

suspend fun handlePrivateLobbyStartRace(session: GameConnection, request: PrivateLobbyStartRaceRequest) {
    session.send(PrivateLobbyStartRaceResponse())
}

suspend fun handlePrivateLobbyFinishRace(session: GameConnection, request: PrivateLobbyFinishRaceRequest) {
    session.send(PrivateLobbyFinishRaceResponse())
}

suspend fun handlePrivateLobbyCancelRace(session: GameConnection, request: PrivateLobbyCancelRaceRequest) {
    session.send(PrivateLobbyCancelRaceResponse())
}

suspend fun handlePrivateLobbyStartRaceSpectator(
    session: GameConnection,
    request: PrivateLobbyStartRaceSpectatorRequest
) {
    session.send(PrivateLobbyStartRaceSpectatorResponse())
}

suspend fun handleSendTrackingEvents(session: GameConnection, request: SendTrackingEventsRequest) {
    session.send(SendTrackingEventsResponse())
}

suspend fun handleGetXuids(session: GameConnection, request: GetXuidsRequest) {
    session.send(GetXuidsResponse())
}

suspend fun handleUpdateGamertag(session: GameConnection, request: UpdateGamertagRequest) {
    session.send(UpdateGamertagResponse())
}

suspend fun handleGetOnlineUserInfo(session: GameConnection, request: GetOnlineUserInfoRequest) {
    session.send(GetOnlineUserInfoResponse())
}

suspend fun handleReportUser(session: GameConnection, request: ReportUserRequest) {
    session.send(ReportUserResponse())
}

suspend fun handleXboxLiveOnlyEnable(session: GameConnection, request: XboxLiveOnlyEnableRequest) {
    session.send(XboxLiveOnlyEnableResponse())
}

suspend fun handleBlockUser(session: GameConnection, request: BlockUserRequest) {
    session.send(BlockUserResponse())
}

suspend fun handleUnblockUser(session: GameConnection, request: UnblockUserRequest) {
    session.send(UnblockUserResponse())
}

suspend fun handleGetBlockedUsers(session: GameConnection, request: GetBlockedUsersRequest) {
    session.send(GetBlockedUsersResponse())
}

suspend fun handleCreateTransferCode(session: GameConnection, request: CreateTransferCodeRequest) {
    session.send(CreateTransferCodeResponse())
}

suspend fun handleUseTransferCode(session: GameConnection, request: UseTransferCodeRequest) {
    session.send(UseTransferCodeResponse())
}

suspend fun handleBonusPassBuyPass(session: GameConnection, request: BonusPassBuyPassRequest) {
    session.send(BonusPassBuyPassResponse())
}

suspend fun handleBonusPassValidateProductPurchase(
    session: GameConnection,
    request: BonusPassValidateProductPurchaseRequest
) {
    session.send(BonusPassValidateProductPurchaseResponse())
}

suspend fun handleBonusPassFinishPass(session: GameConnection, request: BonusPassFinishPassRequest) {
    session.send(BonusPassFinishPassResponse())
}

suspend fun handlePiggyBankValidateProductPurchase(
    session: GameConnection,
    request: PiggyBankValidateProductPurchaseRequest
) {
    session.send(PiggyBankValidateProductPurchaseResponse())
}

suspend fun handlePiggyBankClaimFreeTier(session: GameConnection, request: PiggyBankClaimFreeTierRequest) {
    session.send(PiggyBankClaimFreeTierResponse())
}

suspend fun handlePiggyBankExpireTier(session: GameConnection, request: PiggyBankExpireTierRequest) {
    session.send(PiggyBankExpireTierResponse())
}

suspend fun handlePiggyBankAddMoneyToBankCheat(session: GameConnection, request: PiggyBankAddMoneyToBankCheatRequest) {
    session.send(PiggyBankAddMoneyToBankCheatResponse())
}

suspend fun handleLegendFundValidateProductPurchase(
    session: GameConnection,
    request: LegendFundValidateProductPurchaseRequest
) {
    session.send(LegendFundValidateProductPurchaseResponse())
}

suspend fun handleLegendFundClaimMilestone(session: GameConnection, request: LegendFundClaimMilestoneRequest) {
    session.send(LegendFundClaimMilestoneResponse())
}

suspend fun handleLegendFundResetCheat(session: GameConnection, request: LegendFundResetCheatRequest) {
    session.send(LegendFundResetCheatResponse())
}

suspend fun handleLegendFundObtainCheat(session: GameConnection, request: LegendFundObtainCheatRequest) {
    session.send(LegendFundObtainCheatResponse())
}
