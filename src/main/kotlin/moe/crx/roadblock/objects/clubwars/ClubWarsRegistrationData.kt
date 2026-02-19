package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.ClubId
import moe.crx.roadblock.objects.account.GarageValue

@Serializable
data class ClubWarsRegistrationData(
    var clubWhenJoined: ClubId,
    var clubGarageValueWhenJoined: GarageValue,
    var participationData: ClubWarsParticipationData?,
    var finishState: ClubWarsRoundFinishState,
    var matchmakingData: ClubWarsMatchmakingData,
)