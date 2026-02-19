package moe.crx.roadblock.objects.settings

import kotlinx.serialization.Serializable

@Serializable
data class Localization(
    var language: LanguageCode = LanguageCode.EN,
    var script: ScriptCode = ScriptCode.NONE,
    var region: RegionCode = RegionCode.NONE,
)