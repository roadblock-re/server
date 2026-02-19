package moe.crx.roadblock.objects.party

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.NativeSessionId
import moe.crx.roadblock.objects.account.PlatformType

@Serializable
data class NativeSession(
    var nativeSessionId: NativeSessionId = "",
    var platformType: PlatformType = PlatformType.Unknown,
)