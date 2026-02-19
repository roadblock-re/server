package moe.crx.roadblock.objects.gacha

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion

@Serializable
data class GachaId(
    @FromVersion("24.0.0")
    var id: UInt = 0u,
    @UntilVersion("24.0.0")
    var legacyId: UShort = 0u,
)