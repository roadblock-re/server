package moe.crx.roadblock.objects.bonuspass

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.FreeTLETicketsRefillsAmount

@Serializable
data class TLEBenefitsState(
    var usedTLERefills: FreeTLETicketsRefillsAmount = 0u,
    var nextTLETicketsRefillsRestore: Instant = now(),
)