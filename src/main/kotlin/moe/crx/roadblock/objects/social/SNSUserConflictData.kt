package moe.crx.roadblock.objects.social

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.Flags
import moe.crx.roadblock.objects.GarageLevel
import moe.crx.roadblock.objects.Money
import moe.crx.roadblock.objects.ReputationLevel

@Serializable
data class SNSUserConflictData(
    var username: String,
    var carsOwned: UInt,
    var garageLevel: GarageLevel,
    var reputationLevel: ReputationLevel,
    var credits: Money,
    var tokens: Money,
    var careerFlags: Flags,
    var lastTimePlayed: Instant,
    var channelName: String?,
    var ownsCurrentSeasonPass: Boolean,
)