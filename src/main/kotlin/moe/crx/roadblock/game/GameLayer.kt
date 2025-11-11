package moe.crx.roadblock.game

import moe.crx.roadblock.game.handlers.*
import moe.crx.roadblock.objects.game.SerializationVersion
import moe.crx.roadblock.rpc.base.RequestPacket
import java.io.File
import kotlin.reflect.KClass

class GameLayer(private val workingDirectory: String, private val ver: SerializationVersion) {

    companion object {
        val versionRegex = Regex("(\\d+)\\.(\\d+)\\.(\\d+)(\\w*)")

        fun selectVersion(gameVersion: String): SerializationVersion {
            val match = versionRegex.find(gameVersion)

            var ver = SerializationVersion(
                match?.groups[1]?.value?.toShortOrNull() ?: 0,
                match?.groups[2]?.value?.toShortOrNull() ?: 0,
                match?.groups[4]?.value?.toShortOrNull(16) ?: 0,
            )

            // TODO Add game version to serialization version mapping?
            if (ver == SerializationVersion(45, 0, 10)) {
                ver = SerializationVersion(45, 0, 6)
            }

            return ver
        }
    }

    data class PacketHandler(
        val requestName: String,
        val requestClass: KClass<out RequestPacket>,
        val handle: (suspend (GameConnection, RequestPacket) -> Unit)?,
    )

    var currentId: Short = 0
    var handlers: MutableMap<Short, PacketHandler?> = mutableMapOf()

    init {
        register(::handleActionLogin)
        if (ver newer "24.0.0") {
            register("NotifyShutdown")
        }
        register(::handleCareerStartRace)
        register(::handleCareerFinishRace)
        register(::handleCareerCancelRace)
        register(::handleClaimSatelliteReward)
        register(::handleCompleteCareerSeasonCheat)
        register(::handleGainEventFlagCheat)
        if (ver newer "24.6.0") {
            register("GainCareerFlagsCheat")
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
            register("UnlockAssemblyStage")
        }
        register(::handleUnlockUpgradeTier)
        register(::handleUpgradeCarStatLevel)
        register(::handleFreeUpgradeCarStatLevel)
        register(::handleInstallUpgradeItem)
        if (ver newer "45.0.0") {
            register("AcquireAndInstallUpgradeItem")
        }
        register(::handleConvertWildcardBlueprints)
        register(::handleTrashItem)
        if (ver newer "45.0.0") {
            register("EquipEvoTuningEngine")
            register("EquipEvoTuningDriveTrain")
            register("EquipEvoTuningIntake")
            register("EquipEvoTuningNOS")
            register("EquipEvoTuningSKit")
        }
        register(::handleGainAllCarItemsCheat)
        register(::handleGainAllCarsCheat)
        register(::handleGainCurrencyCheat)
        register(::handleGainCarBlueprintsCheat)
        register(::handleGainWildcardBlueprintsCheat)
        if (ver newer "24.6.0") {
            register("GainWildcardUpgradeItemsCheat")
        }
        if (ver older "24.0.0") {
            register(::handleGainCarEvoBlueprintsCheat)
        }
        if (ver newer "45.0.0") {
            register("GetAllEvoTuningCarPartsCheat")
        }
        register(::handleSaveEmojiConfiguration)
        register(::handleBuyGachaBox)
        register(::handleBuyTimeLimitedGachaBox)
        if (ver newer "24.0.0") {
            register("ClaimSponsorshipGachaBox")
        }
        register(::handleClaimLevelUpGachaBoxes)
        register(::handleClaimMissionReward)
        if (ver newer "24.6.0") {
            register("ClaimAllMissionReward")
        }
        register(::handleTutorialFinishRace)
        register(::handleChangeMenuTutorialState)
        register(::handleChangeGameplayTutorialState)
        register(::handleGainGarageLevelCheat)
        register(::handleGainGarageValueCheat)
        if (ver newer "24.0.0") {
            // TODO Not supported on 24.0.1f (but supported on 24.0.6)
            register("ClaimAllFreePremiumGachasCheat")
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
            register("MultiplayerSeriesClaimSkippedMilestones")
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
            register("RequestClubDonation")
            register("GiveClubDonation")
            register("GetClubDonations")
        }
        if (ver newer "24.0.0" && ver older "24.6.0") {
            register("SetClubUGCValidatedCheat")
        }
        if (ver newer "24.6.0") {
            register("SearchClubsByKeywords")
            register("SearchRecommendedClubs")
            register("SearchClubByTag")
            register("GetClubData")
            register(::handleGetClubInvitations)
            register("GetClubMembershipApprovalRequests")
            register("GetClubMembers")
            register("GetInvitedPlayers")
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
        // TODO Are these the same? Should we use a single variable in MiscellaneousState?
        if (ver older "24.0.0") {
            register(::handleMiscellaneousSetConsentNoticeShown)
        }
        if (ver newer "24.0.0") {
            register("MiscellaneousSetUnderageDisclaimerShown")
        }
        register(::handleSaveGameSettings)
        register(::handleMiscellaneousSetPlatform)
        if (ver newer "24.0.0") {
            register("MiscellaneousSetCrossplayPlatformFilter")
            register("SaveAdsMinigameResult")
        }
        if (ver older "24.0.0") {
            register(::handleMiscellaneousSetUniqueUserName)
        }
        if (ver newer "24.6.0") {
            register(::handleMiscellaneousUpdateProfileConsent)
            register("MiscellaneousSaveProfileConsent")
            register("MiscellaneousClaimAdsReplacement")
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
        register(::handleCurrencyPackValidatePurchase)
        register(::handlePromotionValidatePurchase)
        register(::handleTLETicketsCheat)
        register(::handleTLEventCancelRace)
        register(::handleTLEventClaimClubReward)
        register(::handleTLEventClaimRankRewards)
        register(::handleTLEventCompleteCheat)
        register(::handleTLEventFinishRace)
        if (ver newer "45.0.0") {
            register("TLEventAutoplayFinishRace")
        }
        register(::handleTLEventRefillTickets)
        register(::handleTLEventRefreshClaimState)
        register(::handleTLEventSkipClubRewardContidion)
        register(::handleTLEventSkipSoloRewardContidion)
        register(::handleTLEventStartRace)
        if (ver newer "24.6.0") {
            register("TLEventAutoplayStartRace")
        }
        register(::handleTLEventClaimPreviousSpecialEvent)
        register(::handleTimeLimitedSpecialEventClaimProgressionReward)
        register(::handleTLEventAutoclaimRewards)
        register(::handleTLEventResetNitroGhost)
        register(::handleTLEventResetCheat)
        register(::handleRetrievePlaybackCheat)
        register(::handleForceConfigRefresh)
        register(::handleGetRemoteAccountConflictData)
        register(::handleClaimGift)
        register(::handleClaimIrisRedeemCode)
        register(::handleClaimDynamicReward)
        register(::handleResetUserState)
        register(::handleClaimEnableNotificationsReward)
        register(::handleClaimDailyTasks)
        register(::handleDailyTasksReset)
        register(::handleBuyRelayOfferTier)
        register(::handleValidateIAPRelayOfferPurchase)
        if (ver newer "24.0.0" && ver older "24.6.0") {
            register("QuickRaceFinishRace")
        }
        register(::handleSplitScreenStartRace)
        if (ver newer "24.0.0") {
            register("SplitScreenEndRace")
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
        register(::handleSeasonPassSetPlayedOnboardingCheat)
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
        // TODO PrivateLobby renamed to Party
        register(::handlePrivateLobbyCreateRoom)
        register(::handlePrivateLobbyJoinRoom)
        if (ver newer "24.0.0") {
            register("PartyJoinByPartyId")
            register("PartyFindRoomByAccessCode")
        }
        register(::handlePrivateLobbyStartRace)
        register(::handlePrivateLobbyFinishRace)
        if (ver newer "24.6.0") {
            register("PartyNotifyReturnToLobby")
        }
        register(::handlePrivateLobbyCancelRace)
        if (ver newer "24.0.0") {
            register("PartyCancelRaceSpectator")
        }
        register(::handlePrivateLobbyStartRaceSpectator)
        if (ver newer "24.0.0") {
            register("PartyLeaveRoom")
            register("PartyKickUser")
            register("PartyLaunchRoom")
            register("PartyUpdateUserData")
            register("PartyUpdateRoomData")
            register("PartyChangeUserRole")
            register("PartySendPartyInvitation")
            register("PartySetNativeSession")
        }
        register(::handleSendTrackingEvents)
        if (ver older "24.0.0") {
            register(::handleGetXuids)
            register(::handleUpdateGamertag)
        }
        if (ver newer "24.0.0") {
            // TODO Is this GetXuids?
            register("GetPlatformIds")
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
            register("BonusPassBundleValidateProductPurchase")
        }
        register(::handleBonusPassFinishPass)
        register(::handlePiggyBankValidateProductPurchase)
        register(::handlePiggyBankClaimFreeTier)
        register(::handlePiggyBankExpireTier)
        register(::handlePiggyBankAddMoneyToBankCheat)
        register(::handleLegendFundValidateProductPurchase)
        if (ver newer "24.6.0") {
            register("LegendFundCancelProductPurchase")
        }
        register(::handleLegendFundClaimMilestone)
        register(::handleLegendFundResetCheat)
        register(::handleLegendFundObtainCheat)
        if (ver newer "24.0.0") {
            register("IncreaseVaultTicketCheat")
            register("ConsumeVaultTicketCheat")
            register("TriggerRefillVaultTicketByTimeCheat")
            register("VaultCompleteStageCheat")
            register("VaultRefillTickets")
            register("VaultOccupySlot")
            register("VaultDeoccupySlot")
            register("VaultEventStartRace")
        }
        if (ver newer "24.6.0") {
            register("VaultEventAutoplayStartRace")
        }
        if (ver newer "24.0.0") {
            register("VaultEventFinishRace")
        }
        if (ver newer "24.6.0") {
            register("VaultEventAutoplayFinishRace")
        }
        if (ver newer "24.0.0") {
            register("VaultEventCancelRace")
            register("VaultEventClaimProgressionRewards")
            register("VaultExtendEvent")
            register("VaultEventSkipSoloRewardConditions")
            register("VaultGetRemoteVaultEventState")
            register("VaultCleanCorruptSlot")
            register("VaultNotifyAccomplishedEvent")
        }
        if (ver newer "24.0.0" && ver older "24.6.0") {
            register("SeasonalCurrencyConvertCurrency")
        }
        if (ver newer "24.6.0") {
            register("ActivationConvertCurrency")
            register("ActivationBlackMarketGetStatus")
            register("ActivationRefreshBlackMarket")
            register("ActivationBlackMarketBuy")
        }
        if (ver newer "24.0.0") {
            register("UpsellPopupBuyOffer")
            register("UpsellPopupValidateProductPurchase")
        }
        if (ver newer "24.6.0") {
            register("UpsellPopupCancelProductPurchase")
            register("UpsellPopupShown")
        }
        if (ver newer "24.0.0") {
            register("OverclockExpireEvent")
            register("OverclockPurchaseOverclockForCar")
            register("OverclockExpireCar")
        }
        if (ver newer "45.0.0") {
            register("OverclockApplyOverclockForCarCheat")
        }
        if (ver newer "24.0.0") {
            register("OverclockRemoveOverclockOfCarCheat")
            register("OverclockGainOverclockChipsCheat")
            register("OverclockResetOverclockChipsCheat")
            register("SponsorshipSelectContract")
            register("SponsorshipContractClaim")
            register("SponsorshipContractFail")
            register("ProcessSponsorshipDailyLogin")
            register("SaveObtainedAdsRewardDataIntoServerState")
            register("ClearAllObtainedAdsRewardDataInServerState")
            register("CreateTransferCode")
            register("LinkAccountWithTransferCode")
            register(::handleLinkAccountWithCredential)
        }
        if (ver newer "45.0.0") {
            register("RelinkCredentials")
        }
        if (ver newer "24.0.0") {
            register(::handleConfirmLinkingOperation)
            register(::handlePostLoginSocialUpdate)
            register("UpdateStatusLine")
            register("ListGameFriends")
            register("RequestGameFriend")
            register("RemoveGameFriend")
            register("ListGameFriendRequests")
            register("AcceptGameFriend")
            register("RejectGameFriend")
            register("CancelSentGameFriend")
            register("SearchGameFriend")
            register("ListOneWayConnections")
            register("AddOneWayConnection")
            register("DeleteOneWayConnection")
            register("BatchFilterExistingUsers")
            register(::handleGetCredentialsForConsoleUsers)
            register("AcceptAllFriendRequests")
            register("RejectAllFriendRequests")
        }
        if (ver newer "24.6.0") {
            // TODO Should be from 24.1.0
            register("SetAllowFriendRequests")
            register("SendChatMessage")
        }
        if (ver newer "24.0.0") {
            register("ProcessDLCIAPTransaction")
        }
        if (ver newer "24.6.0") {
            register(::handleListRegions)
            register("GauntletStartEvent")
            register("GauntletRefreshEvent")
            register("GauntletRestartQualification")
            register("GauntletFinishQualification")
            register("GauntletLeaveQualification")
            register("GauntletRerollOpponents")
            register("GauntletRerollBannedOpponentsSet")
            register("GauntletValidateRaceLog")
            register("GauntletValidateEventAlreadyFinished")
            register("GauntletStartChallenge")
            register("GauntletStartRevenge")
            register("GauntletSetChallengeCars")
            register("GauntletStartRace")
            register("GauntletFinishRace")
            register("GauntletCancelRace")
            register("GauntletBuyTicket")
            register("GauntletLeaveChallenge")
            register("GauntletFinishChallenge")
            register("GauntletFinalClaim")
            register("GauntletProcessPendingTransactions")
            register("GauntletResetEventState")
            register("GauntletUpdatePendingDataAndActions")
            register("GauntletSetTicketsCheat")
            register("GauntletFinishRaceCheat")
            register("GauntletFinishChallengeCheat")
            register("GauntletSetEloCheat")
            register("GauntletAddChallengePointsCheat")
            register("GauntletFakeOpponentsCheat")
            register("GauntletResetStateCheat")
            register("GauntletMarketRefreshCheat")
            register("GauntletMarketBuy")
            register("GauntletMarketRefresh")
            register("ClaimDailyVIPFreeGift")
            register("VIPBlackMarketGetStatus")
            register("RefreshVIPBlackMarket")
            register("VIPBlackMarketBuy")
            register("ValidateVIPBundleProductPurchase")
            register("JoinTournamentMatch")
            register("QuitTournamentMatch")
            register("GetTournamentMatchDetails")
            register("UpdateTournamentMatchStatus")
            register("TournamentCreateRoom")
            register("TournamentJoinRoom")
            register("TournamentUpdateUserData")
            register("TournamentStartRace")
            register("TournamentLaunchRoom")
            register("TournamentFinishRace")
        }
        if (ver newer "45.0.0") {
            register("TournamentCancelRace")
        }
        if (ver newer "24.6.0") {
            register("TournamentNotifyReturnToLobby")
            register("AllowAllPlatformTournamentCheat")
            register("MockTournamentMatchCheat")
            register("UserCustomizableBundleValidateProductPurchase")
            register("ValidateIAPVanityPurchase")
            register("BuyCarVanityItem")
        }
    }

    fun register(requestName: String? = null) {
        check(!handlers.containsKey(currentId)) {
            "Handler with ID $currentId was already registered."
        }

        handlers[currentId] = PacketHandler(
            requestName ?: "<unknown name>",
            RequestPacket::class,
            null,
        )

        ++currentId
    }

    @Suppress("UNCHECKED_CAST")
    inline fun <reified T : RequestPacket> register(
        noinline handle: (suspend (GameConnection, T) -> Unit)
    ) {
        check(!handlers.containsKey(currentId)) {
            "Handler with ID $currentId was already registered."
        }

        handlers[currentId] = PacketHandler(
            T::class.java.simpleName,
            T::class,
            handle as suspend (GameConnection, RequestPacket) -> Unit,
        )

        ++currentId
    }

    val gameDirectory = File(File(workingDirectory, "game"), "${ver.major}.${ver.minor}.${ver.build}")

    fun getConfig(): File {
        return File(gameDirectory, "clientconfig.json")
    }

    fun getGameDb(): File {
        return File(gameDirectory, "A9-business.gdb")
    }
}