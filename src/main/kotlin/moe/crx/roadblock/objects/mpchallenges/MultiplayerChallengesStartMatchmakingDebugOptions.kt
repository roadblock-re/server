package moe.crx.roadblock.objects.mpchallenges

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.multiplayer.GameplayServerType
import moe.crx.roadblock.objects.MultiplayerRaceConfigId

@Serializable
data class MultiplayerChallengesStartMatchmakingDebugOptions(
    var singleUser: Boolean = true,
    var maxDisqualificationSeconds: UInt? = null,
    var raceConfigId: MultiplayerRaceConfigId? = null,
    var gameplayServerType: GameplayServerType = GameplayServerType.anubis,
    var standaloneGameplayServerAddress: String = "",
    var standaloneGameplayServerPort: UShort = 0u,
    var standaloneGameplayServerCapacity: UInt = 0u,
)