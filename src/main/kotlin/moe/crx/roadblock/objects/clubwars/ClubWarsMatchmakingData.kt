package moe.crx.roadblock.objects.clubwars

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.ByteEnum
import moe.crx.roadblock.objects.ClubId
import moe.crx.roadblock.objects.ClubWarsPoints

@Serializable
data class ClubWarsMatchmakingData(
    var status: ClubWarsMatchmakingStatus,
    @ByteEnum
    var boardSide: ClubWarsBoardSideType,
    var opponentClub: ClubId,
    var defenseAssignedNodes: UShort,
    var attackAssignedEntryPoints: UShort,
    var opponentRegistrationScore: ClubWarsPoints?,
)