package moe.crx.roadblock.objects.social

import kotlinx.serialization.Serializable

@Serializable
data class OneWayConnectionParams(
    var connectionKind: OneWayConnectionKind,
    var credentials: Credentials,
    var connectionFromPlatform: Boolean,
)