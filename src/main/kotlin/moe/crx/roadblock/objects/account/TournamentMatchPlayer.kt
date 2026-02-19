package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class TournamentMatchPlayer(
    var psnCredential: Credentials,
    var joinFlag: UByte,
)