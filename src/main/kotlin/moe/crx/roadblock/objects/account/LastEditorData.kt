package moe.crx.roadblock.objects.account

import kotlinx.serialization.Serializable

@Serializable
data class LastEditorData(
    var credential: Credentials,
    var allCredentials: PlatformCredentials?,
)