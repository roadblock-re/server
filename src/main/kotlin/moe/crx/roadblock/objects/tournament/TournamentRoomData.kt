package moe.crx.roadblock.objects.tournament

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.RoomId
import moe.crx.roadblock.objects.party.UserData

@Serializable
data class TournamentRoomData(
    var matchId: String,
    var roomId: RoomId,
    var lobbyHost: String,
    var lobbyPort: UShort,
    var encryptedServerRoomData: String,
    var clientData: TournamentClientRoomData,
    var users: List<UserData>,
    var raceRoomId: RoomId,
)