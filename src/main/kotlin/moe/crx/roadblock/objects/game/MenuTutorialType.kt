package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.serialization.SerializationVersion

enum class MenuTutorialType {
    MainMenuCareer,
    CareerMap,
    CareerSatelliteReward,
    CareerMultipleRaceGoals,
    CareerUnderRank,
    CareerGoPlayTLEs,
    Upgrades,
    UpgradeItems,
    Maintenance,
    MaintenanceSkip,
    MainMenuClubs,
    MainMenuTLE,
    TLEHUB,
    TLESoloRewards,
    TLERankHUB,
    TLERankRewards,
    TLERankLeaderboard,
    TLERankClaim,
    TLEEnergy,
    MainMenuMultiplayer,
    BlackMarketFirstPurchase,
    BlackMarketFirstRefresh,
    GachaFirstFreePack,
    GachaFirstPremiumPack,
    SetUserName,
    ClubHUB,
    ClubMembers,
    ClubSeasonLeaderboard,
    MultiplayerCarSelection1,
    MultiplayerCarSelection2,
    SmartDriveToggleButton,
    MultiplayerHUBVictoryPack,
    MultiplayerHUBEvent,
    SecondChanceTutorialRacePopup,
    CanBuyPremiumPackReminder,
    GoPlayTLEsReminder,
    GoPlayMultiplayerReminder,
    ControlSchemeTouchScreenSmartDrive,
    ControlSchemeTouchScreenTapToSteer,
    ControlSchemeTouchScreenTiltToSteer,
    ControlSchemeKeyboardSmartDrive,
    ControlSchemeKeyboardManual,
    ControlSchemeGamepadSmartDrive,
    ControlSchemeGamepadManualA,
    ControlSchemeGamepadManualB,
    ControlSchemeGamepadTiltToSteer,
    MainMenuCareerShowGuaranteedCars,
    ShowMoreControlsPopup,
    MainMenuDailyTasks,
    UberIntro,
    UberMainMenu,
    UberMissionsInfo,
    UberMissionsGoalAndReward,
    UberMissionsPinned,
    UberCarKey,
    UberShop,
    UberCleanHazardLevel,
    MainMenuParallelSpecialEvents,
    ChampionshipMainMenu,
    ChampionshipPractice,
    ChampionshipQualifiers,
    ChampionshipFinalRounds,
    ChampionshipFinalScoreboard,
    ControlSchemeSelector,
    WildcardsGarage,
    OnboardingSeasonPass,
    PiggyBankShop,
    OnboardingSeasonPassClaim,
    OnboardingSeasonPassUpsell,
    EpilepsyDisclaimer,
    MainMenuSponsorship,
    MultiplayerSeriesTakedownMode,
    MultiplayerSeriesTeamVsTeam,
    CareerUnlockClubs,
    Autoplay,
    WildcardUpgradeItem;

    companion object {
        fun lastEntryFor(ver: SerializationVersion): MenuTutorialType {
            return if (ver newer "45.0.0") {
                WildcardUpgradeItem
            } else if (ver newer "24.0.0") {
                MultiplayerSeriesTakedownMode
            } else {
                OnboardingSeasonPassUpsell
            }
        }
    }
}