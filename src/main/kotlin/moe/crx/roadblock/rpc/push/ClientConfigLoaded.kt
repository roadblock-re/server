package moe.crx.roadblock.rpc.push

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.ConfigData
import moe.crx.roadblock.objects.ServerDBDataSerialization
import moe.crx.roadblock.rpc.base.PushMessagePacket

@Serializable
data class ClientConfigLoaded(
    var configData: ConfigData,
    var serverDBs: ServerDBDataSerialization,
    var isGameDbObsolete: Boolean,
) : PushMessagePacket()