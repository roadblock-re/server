package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.RegionInfo
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.ResponsePacket

@Serializable
class ListRegionsRequest : RequestPacket()

@Serializable
data class ListRegionsResponse(
    var regions: List<RegionInfo> = listOf(),
    var nextRefreshDelay: ULong = 1800u,
) : ResponsePacket()

suspend fun handleListRegions(session: GameConnection, request: ListRegionsRequest) {
    session.sendResponse(ListRegionsResponse())
}