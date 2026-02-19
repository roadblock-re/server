package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RoomId
import moe.crx.roadblock.objects.party.NativeSession
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.ResponsePacket

@Serializable
data class PartySetNativeSessionRequest(
    var roomId: RoomId,
    var nativeSession: NativeSession?,
) : RequestPacket()

@Serializable
class PartySetNativeSessionResponse : ResponsePacket()

suspend fun handlePartySetNativeSession(
    session: GameConnection,
    request: PartySetNativeSessionRequest
) {
    session.sendResponse(PartySetNativeSessionResponse())
}