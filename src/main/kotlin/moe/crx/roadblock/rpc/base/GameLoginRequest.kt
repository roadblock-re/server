package moe.crx.roadblock.rpc.base

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.objects.ActionRequestHeader
import moe.crx.roadblock.objects.ActionResponseHeader
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.PsnIssuerId
import moe.crx.roadblock.objects.miscellaneous.DeviceInfo
import moe.crx.roadblock.objects.miscellaneous.SystemNotificationType
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.social.PlatformCredentials
import moe.crx.roadblock.objects.tle.CachedEventInfo
import moe.crx.roadblock.objects.tracking.TrackingParameters

@Serializable
data class GameLoginRequest(
    var typeSystemHash: ULong,
    var clientId: String,
    var datacenterName: String,
    @FromVersion("24.1.0")
    var clientBuildId: String = "",
    var userToken: String,
    var credentials: Credentials,
    var deviceInfo: DeviceInfo,
    var lastRequestHeader: ActionRequestHeader,
    var lastResponseHeader: ActionResponseHeader,
    var lastServerActionId: UInt,
    var trackingParameters: TrackingParameters,
    var launchSystemNotification: SystemNotificationType?,
    var channelName: String?,
    var forceLoadEventIds: Set<CalendarEventId>?,
    var platformCredentials: PlatformCredentials?,
    @FromVersion("24.0.0")
    var platformUsername: String? = null,
    @FromVersion("24.0.0")
    var psnIssuerId: PsnIssuerId? = null,
    @FromVersion("50.1.0") // TODO Find exact version
    var gameStateVersion: SerializationVersion = SerializationVersion(),
    @FromVersion("24.0.0")
    var serverDeltaTimeMinutes: UInt = 0u,
    var clientCachedEvents: List<CachedEventInfo>,
) : GameLoginRequestHeader()