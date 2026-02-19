package moe.crx.roadblock.rpc.push

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.RaceToken
import moe.crx.roadblock.objects.account.StatusUpdatesQueueWithRootReactions
import moe.crx.roadblock.objects.multiplayer.GameServerConnectionInfo
import moe.crx.roadblock.rpc.base.PushMessagePacket

@Serializable
data class MultiplayerChallengesMatchmakingFinished(
    var raceToken: RaceToken,
    var roomId: String,
    var server: String,
    var port: UShort,
    var gameServerConnectionInfo: GameServerConnectionInfo?,
    var updatesQueue: StatusUpdatesQueueWithRootReactions,
) : PushMessagePacket()