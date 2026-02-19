package moe.crx.roadblock.objects.party

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.PartyRoomAccessCode
import moe.crx.roadblock.objects.account.RoomId

@Serializable
data class PartyRoomData(
    var accessCode: PartyRoomAccessCode = "",
    var roomId: RoomId = "",
    var lobbyHost: String = "",
    var lobbyPort: UShort = 0u,
    var encryptedServerRoomData: String = "",
    var capacity: UInt = 0u,
    var clientData: PartyClientRoomData = PartyClientRoomData(),
    var users: List<UserData> = listOf(),
    var raceRoomId: RoomId = "",
    var nativeSession: NativeSession = NativeSession(),
)