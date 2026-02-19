package moe.crx.roadblock.objects.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.Credentials

@Serializable
data class OneWayConnectionParams(
    var connectionKind: OneWayConnectionKind,
    var credentials: Credentials,
    var connectionFromPlatform: Boolean,
)