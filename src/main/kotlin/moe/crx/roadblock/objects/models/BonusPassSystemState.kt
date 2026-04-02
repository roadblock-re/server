package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.bonuspass.BonusPassState
import moe.crx.roadblock.objects.bonuspass.MultiplayerBenefitsState
import moe.crx.roadblock.objects.bonuspass.TLEBenefitsState

@Serializable
data class BonusPassSystemState(
    var eventDataById: Map<CalendarEventId, BonusPassState> = mapOf(),
    var multiplayerBenefits: MultiplayerBenefitsState = MultiplayerBenefitsState(),
    @FromVersion("3.8.0")
    var tleBenefits: TLEBenefitsState = TLEBenefitsState(),
)