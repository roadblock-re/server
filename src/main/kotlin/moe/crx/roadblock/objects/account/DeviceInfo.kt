package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class DeviceInfo(
    var gdId: String,
    var model: String,
    var country: String,
    var language: String,
    var carrier: String,
    var firmware: String,
    var width: String,
    var height: String,
)