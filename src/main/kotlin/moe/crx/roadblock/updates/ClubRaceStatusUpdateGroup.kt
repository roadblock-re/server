package moe.crx.roadblock.updates

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.ClubRaceEventId

@Serializable
sealed class ClubRaceStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<ClubRaceStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(ClubRaceFinished::class)
        }
    }
}

@Serializable
data class ClubRaceFinished(
    var position: UByte,
    var eventId: ClubRaceEventId,
    var laps: UInt,
    var hasFinished: Boolean,
) : ClubRaceStatusUpdateGroup()