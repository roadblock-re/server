package moe.crx.roadblock.objects.club

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.account.PlatformType

@Serializable
data class ClubLastEditorData(
    var credential: Credentials,
    var timestamp: Instant,
    var alias: String?,
    var name: String?,
    var platform: PlatformType?,
    var allCredentials: List<Credentials>?,
)