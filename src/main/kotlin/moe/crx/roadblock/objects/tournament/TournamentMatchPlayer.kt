package moe.crx.roadblock.objects.tournament

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.social.Credentials

@Serializable
data class TournamentMatchPlayer(
    var psnCredential: Credentials,
    var joinFlag: UByte,
)