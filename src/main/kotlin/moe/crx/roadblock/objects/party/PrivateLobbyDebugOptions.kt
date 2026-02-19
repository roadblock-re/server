package moe.crx.roadblock.objects.party

import kotlinx.serialization.Serializable

@Serializable
data class PrivateLobbyDebugOptions(
    var mockedPrivateLobbies: Boolean = false,
)