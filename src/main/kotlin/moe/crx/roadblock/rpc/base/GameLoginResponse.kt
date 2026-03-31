package moe.crx.roadblock.rpc.base

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.objects.ActionResponseHeader
import moe.crx.roadblock.objects.ConfigData
import moe.crx.roadblock.objects.ServerDBDataSerialization
import moe.crx.roadblock.objects.ServerError
import moe.crx.roadblock.objects.StatusUpdatesQueueWithRootReactions
import moe.crx.roadblock.objects.models.State

@Serializable
data class GameLoginResponse(
    var magic: UByte = MAGIC,
    var error: ServerError? = null,
    var userSessionId: String = "a9a9a9a9-a9a9-a9a9-a9a9-a9a9a9a9a9a9",
    var revision: String = "b1610",
    var actionResponseParams: ActionResponseHeader,
    var lastServerActionId: UInt,
    var updatesQueue: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions(),
    var configData: ConfigData,
    var serverDBs: ServerDBDataSerialization,
    var serverSyslogId: String = "a9b-aaaaaaaa-bbbbbbbb",
    var buildId: String = "b1610",
    @FromVersion("24.6.0")
    var instance: String = "",
    var didMaintenanceFreeRefill: Boolean = false,
    var remindNewGarageLevel: Boolean = false,
    var isClientReloadNeeded: Boolean = false,
    @FromVersion("3.7.0")
    var isVipPlayer: Boolean = false,
    @FromVersion("24.0.0")
    var isForcedUserName: Boolean = false,
    var signatureValue: UInt = GAME_SIGNATURE,
    var serializationVersion: SerializationVersion,
    var state: State,
) {
    companion object {
        const val MAGIC: UByte = 0u
        const val GAME_SIGNATURE: UInt = 0x47DCEC79u
    }

    init {
        check(magic == MAGIC)
        check(signatureValue == GAME_SIGNATURE)
    }
}
