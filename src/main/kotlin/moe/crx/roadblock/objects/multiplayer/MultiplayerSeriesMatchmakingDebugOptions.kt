package moe.crx.roadblock.objects.multiplayer

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.GameplayServerType
import moe.crx.roadblock.objects.account.MultiplayerRaceConfigId

@Serializable
data class MultiplayerSeriesMatchmakingDebugOptions(
    var minUsers: UInt?,
    var policeCars: UInt?,
    var maxDisqualificationSeconds: UInt?,
    var raceConfigurationId: MultiplayerRaceConfigId?,
    var disableQuickWinEnabledInSingleUserRaces: Boolean,
    var gameplayServerType: GameplayServerType,
    var standaloneGameplayServerAddress: String,
    var standaloneGameplayServerPort: UShort,
    var standaloneGameplayServerCapacity: UInt,
    var isEndlessRace: Boolean,
)