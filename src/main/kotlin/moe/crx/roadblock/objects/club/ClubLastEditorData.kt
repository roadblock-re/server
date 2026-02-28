package moe.crx.roadblock.objects.club

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.social.Credentials
import moe.crx.roadblock.objects.social.PlatformType

@Serializable
data class ClubLastEditorData(
    var credential: Credentials,
    var timestamp: Instant,
    var alias: String?,
    var name: String?,
    var platform: PlatformType?,
    var allCredentials: List<Credentials>?,
)