package moe.crx.roadblock.game

import moe.crx.roadblock.game.handlers.*
import moe.crx.roadblock.objects.game.SerializationVersion
import moe.crx.roadblock.rpc.base.RequestPacket
import java.io.File
import kotlin.reflect.KClass

class GameLayer(private val ver: SerializationVersion) {

    companion object {
        fun selectVersion(gameVersion: String): SerializationVersion {
            return if (gameVersion.split('.').first().toInt() >= 24) {
                SerializationVersion(24, 0, 14)
            } else {
                SerializationVersion(3, 9, 2)
            }
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
            registerStub("NotifyShutdownRequest")
        }
        register(::handleCareerStartRace)
        register(::handleCareerFinishRace)
        register(::handleCareerCancelRace)
        register(::handleClaimSatelliteReward)
        register(::handleCompleteCareerSeasonCheat)
        register(::handleGainEventFlagCheat)
        register(::handleUnlockAllChaptersCheat)
        register(::handleUnlockAllSeasonsCheat)
        register(::handleBuyCar)
        register(::handleSetPreferredCarVisual)
        register(::handleMaintenanceStartRefill)
        register(::handleMaintenanceSkipRefillWithTokens)
        register(::handleMaintenanceSkipRefillWithBonusPassBenefit)
        register(::handleMaintenanceValidateRefill)
        register(::handleUnlockUpgradeTier)
        register(::handleUpgradeCarStatLevel)
        register(::handleFreeUpgradeCarStatLevel)
        register(::handleInstallUpgradeItem)
        register(::handleConvertWildcardBlueprints)
        register(::handleTrashItem)
        register(::handleGainAllCarItemsCheat)
        register(::handleGainAllCarsCheat)
        register(::handleGainCurrencyCheat)
        register(::handleGainCarBlueprintsCheat)
        register(::handleGainWildcardBlueprintsCheat)
        if (ver older "24.0.0") {
            register(::handleGainCarEvoBlueprintsCheat)
        }
        register(::handleSaveEmojiConfiguration)
        register(::handleBuyGachaBox)
        register(::handleBuyTimeLimitedGachaBox)
        if (ver newer "24.0.0") {
            registerStub("ClaimSponsorshipGachaBoxRequest")
        }
        register(::handleClaimLevelUpGachaBoxes)
        register(::handleClaimMissionReward)
        register(::handleTutorialFinishRace)
        register(::handleChangeMenuTutorialState)
        register(::handleChangeGameplayTutorialState)
        register(::handleGainGarageLevelCheat)
        register(::handleGainGarageValueCheat)
        //registerStub("ClaimAllFreePremiumGachasCheatRequest") // TODO Not supported on 24.0.1f (but supported on 24.0.6)
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
            registerStub("RequestClubDonationRequest")
            registerStub("GiveClubDonationRequest")
            registerStub("GetClubDonationsRequest")
            registerStub("SetClubUGCValidatedCheatRequest")
        }
        register(::handleClubRaceCancelRace)
        register(::handleClubRaceCreateRoom)
        register(::handleClubRaceFinishRace)
        register(::handleClubRaceJoinRoom)
        register(::handleClubRaceNotifyRoomJoined)
        register(::handleClubRaceNotifyRoomJoinFailed)
        register(::handleClubRaceNotifyRoomLeft)
        register(::handleClubRaceStartRace)
        register(::handleMiscellaneousSetUserName)
        register(::handleMiscellaneousSetUserAgeAndGender)
        register(::handleMiscellaneousSetUserOnlinePrivacyPolicy)
        // TODO Are these the same? Should we use a single variable in MiscellaneousState?
        if (ver older "24.0.0") {
            register(::handleMiscellaneousSetConsentNoticeShown)
        }
        if (ver newer "24.0.0") {
            registerStub("MiscellaneousSetUnderageDisclaimerShownRequest")
        }
        register(::handleSaveGameSettings)
        register(::handleMiscellaneousSetPlatform)
        if (ver newer "24.0.0") {
            registerStub("MiscellaneousSetCrossplayPlatformFilterRequest")
            registerStub("SaveAdsMinigameResultRequest")
        }
        if (ver older "24.0.0") {
            register(::handleMiscellaneousSetUniqueUserName)
        }
        register(::handlePerformCheat)
        register(::handlePurchaseOfflineProduct)
        register(::handleIAPFakePurchaseCheat)
        register(::handleProcessPendingSeshatAdTransaction)
        register(::handleProcessPendingSeshatGiftTransaction)
        register(::handleProcessPendingSeshatIAPTransaction)
        register(::handleProcessPendingSeshatRefundTransaction)
        register(::handleProcessPendingSeshatTransactions)
        register(::handleClaimAdClientSideRewards)
        register(::handleCurrencyPackValidatePurchase)
        register(::handlePromotionValidatePurchase)
        register(::handleTLETicketsCheat)
        register(::handleTLEventCancelRace)
        register(::handleTLEventClaimClubReward)
        register(::handleTLEventClaimRankRewards)
        register(::handleTLEventCompleteCheat)
        register(::handleTLEventFinishRace)
        register(::handleTLEventRefillTickets)
        register(::handleTLEventRefreshClaimState)
        register(::handleTLEventSkipClubRewardContidion)
        register(::handleTLEventSkipSoloRewardContidion)
        register(::handleTLEventStartRace)
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
        if (ver newer "24.0.0") {
            registerStub("QuickRaceFinishRaceRequest")
        }
        register(::handleSplitScreenStartRace)
        if (ver newer "24.0.0") {
            registerStub("SplitScreenEndRaceRequest")
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
        register(::handleInboxMarkAsRead)
        register(::handlePrivateLobbyCreateRoom)
        register(::handlePrivateLobbyJoinRoom)
        // TODO PrivateLobby renamed to Party
        if (ver newer "24.0.0") {
            registerStub("PartyJoinByPartyId")
            registerStub("PartyFindRoomByAccessCode")
        }
        register(::handlePrivateLobbyStartRace)
        register(::handlePrivateLobbyFinishRace)
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
        register(::handleXboxLiveOnlyEnable)
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
            registerStub("VaultEventFinishRace")
            registerStub("VaultEventCancelRace")
            registerStub("VaultEventClaimProgressionRewards")
            registerStub("VaultExtendEvent")
            registerStub("VaultEventSkipSoloRewardConditions")
            registerStub("VaultGetRemoteVaultEventState")
            registerStub("VaultCleanCorruptSlot")
            registerStub("VaultNotifyAccomplishedEvent")
            registerStub("SeasonalCurrencyConvertCurrency")
            registerStub("UpsellPopupBuyOffer")
            registerStub("UpsellPopupValidateProductPurchase")
            registerStub("OverclockExpireEvent")
            registerStub("OverclockPurchaseOverclockForCar")
            registerStub("OverclockExpireCar")
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
            register(::handleConfirmLinkingOperation)
            register(::handlePostLoginSocialUpdate)
            registerStub("UpdateStatusLine")
            registerStub("ListGameFriends")
            registerStub("RequestGameFriend")
            registerStub("RemoveGameFriend")
            registerStub("ListGameFriendRequests")
            registerStub("AcceptGameFriendRequest")
            registerStub("RejectGameFriendRequest")
            registerStub("CancelSentGameFriendRequest")
            registerStub("SearchGameFriend")
            registerStub("ListOneWayConnections")
            registerStub("AddOneWayConnection")
            registerStub("DeleteOneWayConnection")
            registerStub("BatchFilterExistingUsers")
            register(::handleGetCredentialsForConsoleUsers)
            registerStub("AcceptAllFriendRequests")
            registerStub("RejectAllFriendRequests")
            registerStub("ProcessDLCIAPTransaction")
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