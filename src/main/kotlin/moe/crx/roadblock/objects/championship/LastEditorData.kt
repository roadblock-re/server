package moe.crx.roadblock.objects.championship

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.social.PlatformCredentials

@Serializable
data class LastEditorData(
    var credential: Credentials,
    var allCredentials: PlatformCredentials?,
)