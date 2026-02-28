package moe.crx.roadblock.objects.party

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.social.Credentials

@Serializable
data class MultiplayerUserClubDataLastEditor(
    var credential: Credentials,
    var allCredentials: List<Credentials>?,
)