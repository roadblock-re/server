package moe.crx.roadblock.objects.tracking

import kotlinx.serialization.Serializable

@Serializable
data class TrackingParameters(
    var vendorId: String,
    var advertisingId: String?,
    var anonymousId: String?,
    var gdId: String?,
    var gameId: UInt,
    var gameVersion: String,
    var platform: String,
)