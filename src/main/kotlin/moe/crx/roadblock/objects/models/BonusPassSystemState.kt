package moe.crx.roadblock.objects.models

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.bonuspass.BonusPassState
import moe.crx.roadblock.objects.bonuspass.MultiplayerBenefitsState
import moe.crx.roadblock.objects.bonuspass.TLEBenefitsState
import moe.crx.roadblock.objects.account.CalendarEventId

@Serializable
data class BonusPassSystemState(
    var eventDataById: Map<CalendarEventId, BonusPassState> = mapOf(),
    var multiplayerBenefits: MultiplayerBenefitsState = MultiplayerBenefitsState(),
    var tleBenefits: TLEBenefitsState = TLEBenefitsState(),
)