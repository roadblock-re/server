package moe.crx.roadblock.objects.mpchallenges

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.MultiplayerChallengesSeriesId
import moe.crx.roadblock.objects.MultiplayerRaceConfigId
import moe.crx.roadblock.objects.RaceToken
import moe.crx.roadblock.objects.multiplayer.RaceStats
import moe.crx.roadblock.objects.settings.ControlSchemeType

@Serializable
data class MultiplayerChallengeRaceResult(
    var eventId: MultiplayerChallengesSeriesId,
    var raceConfigId: MultiplayerRaceConfigId,
    var raceToken: RaceToken,
    var raceStats: RaceStats,
    var finishReason: UInt,
    var gameplayServerCreationTime: Instant,
    var raceFinishServerTime: Instant,
    var controlSchemeType: ControlSchemeType,
    var forceDefeatCheat: Boolean,
    var carId: CarId,
)