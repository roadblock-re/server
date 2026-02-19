package moe.crx.roadblock.objects.bonuspass

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.FreeFuelRefillsAmount

@Serializable
data class MultiplayerBenefitsState(
    var usedRefills: FreeFuelRefillsAmount = 0u,
    var nextRefillsRestore: Instant = now(),
)