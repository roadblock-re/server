package moe.crx.roadblock.objects.seasonpass

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.EnumList
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.objects.account.MaintenanceSlots
import moe.crx.roadblock.objects.account.SeasonPassBenefitBoost

@Serializable
data class LegendPassBenefitsMultipliers(
    var timeBetweenBoxes: UInt,
    var extraMaintenanceSlots: MaintenanceSlots,
    var boosters: EnumList<SeasonPassBenefitBoost, SeasonPassBoostType>,
    var hasNextRefillTimePoint: Boolean,
    var nextRefillTimePoint: Instant,
    @FromVersion("24.6.0")
    var hasUnlimitedFuelInCareerMode: Boolean = false,
    @FromVersion("45.0.0")
    var hasUnlimitedTicketsInTLE: Boolean = false,
)