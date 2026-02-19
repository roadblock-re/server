package moe.crx.roadblock.rpc.push

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.ConfigData
import moe.crx.roadblock.objects.account.ServerDBDataSerialization
import moe.crx.roadblock.rpc.base.PushMessagePacket

@Serializable
data class ClientConfigLoaded(
    var configData: ConfigData,
    var serverDBs: ServerDBDataSerialization,
    var isGameDbObsolete: Boolean,
) : PushMessagePacket()