package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.*
import moe.crx.roadblock.objects.gauntlet.GauntletChallengeData
import moe.crx.roadblock.objects.gauntlet.GauntletDefenceEntry
import moe.crx.roadblock.objects.gauntlet.GauntletOpponent
import moe.crx.roadblock.objects.quarantine.QuarantineEvidence
import moe.crx.roadblock.objects.social.Credentials
import kotlin.reflect.KClass

@Serializable
sealed class GauntletSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<GauntletSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out GauntletSystemStatusUpdateGroup>> =
            buildList {
                add(GauntletSystemStatusUpdateGroup0::class)
                add(GauntletSystemStatusUpdateGroup1::class)
                add(GauntletSystemStatusUpdateGroup2::class)
                add(GauntletSystemStatusUpdateGroup3::class)
                add(GauntletSystemStatusUpdateGroup4::class)
                add(GauntletSystemStatusUpdateGroup5::class)
                add(GauntletSystemStatusUpdateGroup6::class)
                add(GauntletSystemStatusUpdateGroup7::class)
                add(GauntletSystemStatusUpdateGroup8::class)
                add(GauntletSystemStatusUpdateGroup9::class)
                add(GauntletSystemStatusUpdateGroup10::class)
                add(GauntletSystemStatusUpdateGroup11::class)
                add(GauntletSystemStatusUpdateGroup12::class)
                add(GauntletSystemStatusUpdateGroup13::class)
                add(GauntletSystemStatusUpdateGroup14::class)
                add(GauntletSystemStatusUpdateGroup15::class)
                add(GauntletSystemStatusUpdateGroup16::class)
                add(GauntletSystemStatusUpdateGroup17::class)
                add(GauntletSystemStatusUpdateGroup18::class)
                add(GauntletSystemStatusUpdateGroup19::class)
                add(GauntletSystemStatusUpdateGroup20::class)
                add(GauntletSystemStatusUpdateGroup21::class)
                add(GauntletSystemStatusUpdateGroup22::class)
                add(GauntletSystemStatusUpdateGroup23::class)
                add(GauntletSystemStatusUpdateGroup24::class)
                add(GauntletSystemStatusUpdateGroup25::class)
                add(GauntletSystemStatusUpdateGroup26::class)
                add(GauntletSystemStatusUpdateGroup27::class)
                add(GauntletSystemStatusUpdateGroup28::class)
                add(GauntletSystemStatusUpdateGroup29::class)
                add(GauntletSystemStatusUpdateGroup30::class)
                add(GauntletSystemStatusUpdateGroup31::class)
                add(GauntletSystemStatusUpdateGroup32::class)
                add(GauntletSystemStatusUpdateGroup33::class)
                add(GauntletSystemStatusUpdateGroup34::class)
            }
    }
}

@Serializable
data class GauntletSystemStatusUpdateGroup0(
    var eventId: CalendarEventId,
    var maxTickets: UShort,
    var division: GauntletDivision,
    var tracks: List<EventTrackDefId>,
    var totalCarRank: CarRank,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup1(
    var eventId: CalendarEventId,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup2(
    var eventId: CalendarEventId,
    var oldValue: UShort,
    var newValue: UShort,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup3(
    var eventId: CalendarEventId,
    var oldValue: UShort,
    var newValue: UShort,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup4(
    var eventId: CalendarEventId,
    var oldValue: UByte,
    var newValue: UByte,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup5(
    var eventId: CalendarEventId,
    var oldValue: UShort,
    var newValue: UShort,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup6(
    var eventId: CalendarEventId,
    var newValue: UInt,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup7(
    var eventId: CalendarEventId,
    var timePoint: Instant,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup8(
    var eventId: CalendarEventId,
    var timePoint: Instant,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup9(
    var eventId: CalendarEventId,
    var qualificationId: GauntletQualificationId,
    var timePoint: Instant,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup10(
    var eventId: CalendarEventId,
    var challengeData: GauntletChallengeData,
    var revengeLogIndex: UInt?,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup11(
    var eventId: CalendarEventId,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup12(
    var eventId: CalendarEventId,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup13(
    var eventId: CalendarEventId,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup14(
    var eventId: CalendarEventId,
    var raceId: UByte,
    var time: Instant,
    var carId: CarId,
    var carRank: CarRank,
    var isOverclocked: Boolean,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup15(
    var eventId: CalendarEventId,
    var carIds: List<CarId>,
    var carRanks: List<CarRank>,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup16(
    var eventId: CalendarEventId,
    var defenceData: GauntletDefenceEntry,
    var maxLogSize: UInt,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup17(
    var eventId: CalendarEventId,
    var credentials: Credentials,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup18(
    var eventId: CalendarEventId,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup19(
    var eventId: CalendarEventId,
    var position: GauntletPosition,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup20(
    var eventId: CalendarEventId,
    var nextRefreshTime: Instant,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup21(
    var eventId: CalendarEventId,
    var opponentsSet: List<GauntletOpponent?>?,
    var rerollsCount: UInt,
    var expirationTime: Instant,
    var blacklistDuration: UByte,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup22(
    var eventId: CalendarEventId,
    var count: UInt,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup23(
    var eventId: CalendarEventId,
    var timestamp: Instant,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup24(
    var eventId: CalendarEventId,
    var raceId: UByte,
    var carId: CarId,
    var carRank: CarRank,
    var isOverclocked: Boolean,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup25(
    var eventId: CalendarEventId,
    var raceId: UByte,
    var duration: ULong,
    var isFinished: Boolean,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup26(
    var eventIds: List<CalendarEventId>,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup27(
    var productId: UInt,
) : GauntletSystemStatusUpdateGroup()

@Serializable
class GauntletSystemStatusUpdateGroup28 : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup29(
    var newTimePoint: Instant,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup30(
    var newState: UByte,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup31(
    var eventId: CalendarEventId,
    var banType: UInt,
    var timePoint: Instant,
    var isBanned: Boolean,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup32(
    var banType: UInt,
    var timePoint: Instant,
    var isBanned: Boolean,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup33(
    var eventId: CalendarEventId,
    var evidence: QuarantineEvidence,
) : GauntletSystemStatusUpdateGroup()

@Serializable
data class GauntletSystemStatusUpdateGroup34(
    var eventId: CalendarEventId,
) : GauntletSystemStatusUpdateGroup()