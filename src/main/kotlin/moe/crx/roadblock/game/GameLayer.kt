package moe.crx.roadblock.game

import moe.crx.roadblock.game.handlers.*
import moe.crx.roadblock.objects.game.SerializationVersion
import moe.crx.roadblock.rpc.base.RequestPacket
import java.io.File
import kotlin.reflect.KClass

class GameLayer(private val ver: SerializationVersion) {

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
            registerStub("NotifyShutdown")
        }
        register(::handleCareerStartRace)
        register(::handleCareerFinishRace)
        register(::handleCareerCancelRace)
        register(::handleClaimSatelliteReward)
        register(::handleCompleteCareerSeasonCheat)
        register(::handleGainEventFlagCheat)
        if (ver newer "24.6.0") {
            registerStub("GainCareerFlagsCheat")
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
            registerStub("UnlockAssemblyStage")
        }
        register(::handleUnlockUpgradeTier)
        register(::handleUpgradeCarStatLevel)
        register(::handleFreeUpgradeCarStatLevel)
        register(::handleInstallUpgradeItem)
        if (ver newer "45.0.0") {
            registerStub("AcquireAndInstallUpgradeItem")
        }
        register(::handleConvertWildcardBlueprints)
        register(::handleTrashItem)
        if (ver newer "45.0.0") {
            registerStub("EquipEvoTuningEngine")
            registerStub("EquipEvoTuningDriveTrain")
            registerStub("EquipEvoTuningIntake")
            registerStub("EquipEvoTuningNOS")
            registerStub("EquipEvoTuningSKit")
        }
        register(::handleGainAllCarItemsCheat)
        register(::handleGainAllCarsCheat)
        register(::handleGainCurrencyCheat)
        register(::handleGainCarBlueprintsCheat)
        register(::handleGainWildcardBlueprintsCheat)
        if (ver newer "24.6.0") {
            registerStub("GainWildcardUpgradeItemsCheat")
        }
        if (ver older "24.0.0") {
            register(::handleGainCarEvoBlueprintsCheat)
        }
        if (ver newer "45.0.0") {
            registerStub("GetAllEvoTuningCarPartsCheat")
        }
        register(::handleSaveEmojiConfiguration)
        register(::handleBuyGachaBox)
        register(::handleBuyTimeLimitedGachaBox)
        if (ver newer "24.0.0") {
            registerStub("ClaimSponsorshipGachaBox")
        }
        register(::handleClaimLevelUpGachaBoxes)
        register(::handleClaimMissionReward)
        if (ver newer "24.6.0") {
            registerStub("ClaimAllMissionReward")
        }
        register(::handleTutorialFinishRace)
        register(::handleChangeMenuTutorialState)
        register(::handleChangeGameplayTutorialState)
        register(::handleGainGarageLevelCheat)
        register(::handleGainGarageValueCheat)
        if (ver newer "24.0.0") {
            // TODO Not supported on 24.0.1f (but supported on 24.0.6)
            registerStub("ClaimAllFreePremiumGachasCheat")
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
            registerStub("MultiplayerSeriesClaimSkippedMilestones")
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
            registerStub("RequestClubDonation")
            registerStub("GiveClubDonation")
            registerStub("GetClubDonations")
        }
        if (ver newer "24.0.0" && ver older "24.6.0") {
            registerStub("SetClubUGCValidatedCheat")
        }
        if (ver newer "24.6.0") {
            registerStub("SearchClubsByKeywords")
            registerStub("SearchRecommendedClubs")
            registerStub("SearchClubByTag")
            registerStub("GetClubData")
            registerStub("GetClubInvitations")
            registerStub("GetClubMembershipApprovalRequests")
            registerStub("GetClubMembers")
            registerStub("GetInvitedPlayers")
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
            registerStub("MiscellaneousSetUnderageDisclaimerShown")
        }
        register(::handleSaveGameSettings)
        register(::handleMiscellaneousSetPlatform)
        if (ver newer "24.0.0") {
            registerStub("MiscellaneousSetCrossplayPlatformFilter")
            registerStub("SaveAdsMinigameResult")
        }
        if (ver older "24.0.0") {
            register(::handleMiscellaneousSetUniqueUserName)
        }
        if (ver newer "24.6.0") {
            registerStub("MiscellaneousUpdateProfileConsent")
            registerStub("MiscellaneousSaveProfileConsent")
            registerStub("MiscellaneousClaimAdsReplacement")
            registerStub("MiscellaneousResetAdsReplacementState")
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
            registerStub("ProcessOrphanTransactions")
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
            registerStub("TLEventAutoplayFinishRace")
        }
        register(::handleTLEventRefillTickets)
        register(::handleTLEventRefreshClaimState)
        register(::handleTLEventSkipClubRewardContidion)
        register(::handleTLEventSkipSoloRewardContidion)
        register(::handleTLEventStartRace)
        if (ver newer "24.6.0") {
            registerStub("TLEventAutoplayStartRace")
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
            registerStub("QuickRaceFinishRace")
        }
        register(::handleSplitScreenStartRace)
        if (ver newer "24.0.0") {
            registerStub("SplitScreenEndRace")
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
            registerStub("PartyJoinByPartyId")
            registerStub("PartyFindRoomByAccessCode")
        }
        register(::handlePrivateLobbyStartRace)
        register(::handlePrivateLobbyFinishRace)
        if (ver newer "24.6.0") {
            registerStub("PartyNotifyReturnToLobby")
        }
        register(::handlePrivateLobbyCancelRace)
        if (ver newer "24.0.0") {
            registerStub("PartyCancelRaceSpectator")
        }
        register(::handlePrivateLobbyStartRaceSpectator)
        if (ver newer "24.0.0") {
            registerStub("PartyLeaveRoom")
            registerStub("PartyKickUser")
            registerStub("PartyLaunchRoom")
            registerStub("PartyUpdateUserData")
            registerStub("PartyUpdateRoomData")
            registerStub("PartyChangeUserRole")
            registerStub("PartySendPartyInvitation")
            registerStub("PartySetNativeSession")
        }
        register(::handleSendTrackingEvents)
        if (ver older "24.0.0") {
            register(::handleGetXuids)
            register(::handleUpdateGamertag)
        }
        if (ver newer "24.0.0") {
            // TODO Is this GetXuids?
            registerStub("GetPlatformIds")
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
            registerStub("BonusPassBundleValidateProductPurchase")
        }
        register(::handleBonusPassFinishPass)
        register(::handlePiggyBankValidateProductPurchase)
        register(::handlePiggyBankClaimFreeTier)
        register(::handlePiggyBankExpireTier)
        register(::handlePiggyBankAddMoneyToBankCheat)
        register(::handleLegendFundValidateProductPurchase)
        if (ver newer "24.6.0") {
            registerStub("LegendFundCancelProductPurchase")
        }
        register(::handleLegendFundClaimMilestone)
        register(::handleLegendFundResetCheat)
        register(::handleLegendFundObtainCheat)
        if (ver newer "24.0.0") {
            registerStub("IncreaseVaultTicketCheat")
            registerStub("ConsumeVaultTicketCheat")
            registerStub("TriggerRefillVaultTicketByTimeCheat")
            registerStub("VaultCompleteStageCheat")
            registerStub("VaultRefillTickets")
            registerStub("VaultOccupySlot")
            registerStub("VaultDeoccupySlot")
            registerStub("VaultEventStartRace")
        }
        if (ver newer "24.6.0") {
            registerStub("VaultEventAutoplayStartRace")
        }
        if (ver newer "24.0.0") {
            registerStub("VaultEventFinishRace")
        }
        if (ver newer "24.6.0") {
            registerStub("VaultEventAutoplayFinishRace")
        }
        if (ver newer "24.0.0") {
            registerStub("VaultEventCancelRace")
            registerStub("VaultEventClaimProgressionRewards")
            registerStub("VaultExtendEvent")
            registerStub("VaultEventSkipSoloRewardConditions")
            registerStub("VaultGetRemoteVaultEventState")
            registerStub("VaultCleanCorruptSlot")
            registerStub("VaultNotifyAccomplishedEvent")
        }
        if (ver newer "24.0.0" && ver older "24.6.0") {
            registerStub("SeasonalCurrencyConvertCurrency")
        }
        if (ver newer "24.6.0") {
            registerStub("ActivationConvertCurrency")
            registerStub("ActivationBlackMarketGetStatus")
            registerStub("ActivationRefreshBlackMarket")
            registerStub("ActivationBlackMarketBuy")
        }
        if (ver newer "24.0.0") {
            registerStub("UpsellPopupBuyOffer")
            registerStub("UpsellPopupValidateProductPurchase")
        }
        if (ver newer "24.6.0") {
            registerStub("UpsellPopupCancelProductPurchase")
            registerStub("UpsellPopupShown")
        }
        if (ver newer "24.0.0") {
            registerStub("OverclockExpireEvent")
            registerStub("OverclockPurchaseOverclockForCar")
            registerStub("OverclockExpireCar")
        }
        if (ver newer "45.0.0") {
            registerStub("OverclockApplyOverclockForCarCheat")
        }
        if (ver newer "24.0.0") {
            registerStub("OverclockRemoveOverclockOfCarCheat")
            registerStub("OverclockGainOverclockChipsCheat")
            registerStub("OverclockResetOverclockChipsCheat")
            registerStub("SponsorshipSelectContract")
            registerStub("SponsorshipContractClaim")
            registerStub("SponsorshipContractFail")
            registerStub("ProcessSponsorshipDailyLogin")
            registerStub("SaveObtainedAdsRewardDataIntoServerState")
            registerStub("ClearAllObtainedAdsRewardDataInServerState")
            registerStub("CreateTransferCode")
            registerStub("LinkAccountWithTransferCode")
            register(::handleLinkAccountWithCredential)
        }
        if (ver newer "45.0.0") {
            registerStub("RelinkCredentials")
        }
        if (ver newer "24.0.0") {
            register(::handleConfirmLinkingOperation)
            register(::handlePostLoginSocialUpdate)
            registerStub("UpdateStatusLine")
            registerStub("ListGameFriends")
            registerStub("RequestGameFriend")
            registerStub("RemoveGameFriend")
            registerStub("ListGameFriendRequests")
            registerStub("AcceptGameFriend")
            registerStub("RejectGameFriend")
            registerStub("CancelSentGameFriend")
            registerStub("SearchGameFriend")
            registerStub("ListOneWayConnections")
            registerStub("AddOneWayConnection")
            registerStub("DeleteOneWayConnection")
            registerStub("BatchFilterExistingUsers")
            register(::handleGetCredentialsForConsoleUsers)
            registerStub("AcceptAllFriendRequests")
            registerStub("RejectAllFriendRequests")
        }
        if (ver newer "24.6.0") {
            // TODO Should be from 24.1.0
            registerStub("SetAllowFriendRequests")
            registerStub("SendChatMessage")
        }
        if (ver newer "24.0.0") {
            registerStub("ProcessDLCIAPTransaction")
        }
        if (ver newer "24.6.0") {
            registerStub("ListRegions")
            registerStub("GauntletStartEvent")
            registerStub("GauntletRefreshEvent")
            registerStub("GauntletRestartQualification")
            registerStub("GauntletFinishQualification")
            registerStub("GauntletLeaveQualification")
            registerStub("GauntletRerollOpponents")
            registerStub("GauntletRerollBannedOpponentsSet")
            registerStub("GauntletValidateRaceLog")
            registerStub("GauntletValidateEventAlreadyFinished")
            registerStub("GauntletStartChallenge")
            registerStub("GauntletStartRevenge")
            registerStub("GauntletSetChallengeCars")
            registerStub("GauntletStartRace")
            registerStub("GauntletFinishRace")
            registerStub("GauntletCancelRace")
            registerStub("GauntletBuyTicket")
            registerStub("GauntletLeaveChallenge")
            registerStub("GauntletFinishChallenge")
            registerStub("GauntletFinalClaim")
            registerStub("GauntletProcessPendingTransactions")
            registerStub("GauntletResetEventState")
            registerStub("GauntletUpdatePendingDataAndActions")
            registerStub("GauntletSetTicketsCheat")
            registerStub("GauntletFinishRaceCheat")
            registerStub("GauntletFinishChallengeCheat")
            registerStub("GauntletSetEloCheat")
            registerStub("GauntletAddChallengePointsCheat")
            registerStub("GauntletFakeOpponentsCheat")
            registerStub("GauntletResetStateCheat")
            registerStub("GauntletMarketRefreshCheat")
            registerStub("GauntletMarketBuy")
            registerStub("GauntletMarketRefresh")
            registerStub("ClaimDailyVIPFreeGift")
            registerStub("VIPBlackMarketGetStatus")
            registerStub("RefreshVIPBlackMarket")
            registerStub("VIPBlackMarketBuy")
            registerStub("ValidateVIPBundleProductPurchase")
            registerStub("JoinTournamentMatch")
            registerStub("QuitTournamentMatch")
            registerStub("GetTournamentMatchDetails")
            registerStub("UpdateTournamentMatchStatus")
            registerStub("TournamentCreateRoom")
            registerStub("TournamentJoinRoom")
            registerStub("TournamentUpdateUserData")
            registerStub("TournamentStartRace")
            registerStub("TournamentLaunchRoom")
            registerStub("TournamentFinishRace")
        }
        if (ver newer "45.0.0") {
            registerStub("TournamentCancelRace")
        }
        if (ver newer "24.6.0") {
            registerStub("TournamentNotifyReturnToLobby")
            registerStub("AllowAllPlatformTournamentCheat")
            registerStub("MockTournamentMatchCheat")
            registerStub("UserCustomizableBundleValidateProductPurchase")
            registerStub("ValidateIAPVanityPurchase")
            registerStub("BuyCarVanityItem")
        }
    }

    fun registerStub(requestName: String? = null) {
        check(!handlers.containsKey(currentId)) {
            "Handler with ID $currentId was already registered."
        }

        handlers.put(
            currentId,
            PacketHandler(
                requestName ?: "<unknown name>",
                RequestPacket::class,
                null,
            )
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

        handlers.put(
            currentId,
            PacketHandler(
                T::class.java.simpleName,
                T::class,
                handle as suspend (GameConnection, RequestPacket) -> Unit,
            )
        )

        ++currentId
    }

    fun getConfig(): File {
        return File(File("game", "${ver.major}.${ver.minor}.${ver.build}"), "clientconfig.json")
    }

    fun getGameDb(): File {
        return File(File("game", "${ver.major}.${ver.minor}.${ver.build}"), "A9-business.gdb")
    }
}