package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class ClubRaceRoom(
    var clientData: ClubRaceClientRoomData,
    var encryptedServerData: String,
)