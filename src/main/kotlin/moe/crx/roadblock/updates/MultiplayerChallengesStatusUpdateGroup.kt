package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.mpchallenges.MultiplayerChallengeRaceResult

@Serializable
sealed class MultiplayerChallengesStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<MultiplayerChallengesStatusUpdateGroup> {
        override fun variants(version: SerializationVersion) = buildList {
            add(MultiplayerChallengesStatusUpdate0::class)
            add(MultiplayerChallengesRaceFinished::class)
            add(MultiplayerChallengesRemoveEvents::class)
            add(MultiplayerChallengesStatusUpdate3::class)
            add(MultiplayerChallengesStatusUpdate4::class)
            add(MultiplayerChallengesVictoriesChanged::class)
            add(MultiplayerChallengesRevivesChanged::class)
            add(MultiplayerChallengesDefeatsChanged::class)
            add(MultiplayerChallengesStatusUpdate8::class)
            add(MultiplayerChallengesStatusUpdate9::class)
            add(MultiplayerChallengesStatusUpdate10::class)
            add(MultiplayerChallengesStatusUpdate11::class)
            add(MultiplayerChallengesStatusUpdate12::class)
        }
    }
}

@Serializable
data class MultiplayerChallengesDefeatsChanged(
    var eventId: UInt,
    var oldDefeats: UByte,
    var newDefeats: UByte,
) : MultiplayerChallengesStatusUpdateGroup()

@Serializable
data class MultiplayerChallengesRaceFinished(
    var raceResult: MultiplayerChallengeRaceResult
) : MultiplayerChallengesStatusUpdateGroup()

@Serializable
data class MultiplayerChallengesRemoveEvents(
    var eventIds: List<UInt>
) : MultiplayerChallengesStatusUpdateGroup()

@Serializable
data class MultiplayerChallengesRevivesChanged(
    var eventId: UInt,
    var oldRevives: UByte,
    var newRevives: UByte,
) : MultiplayerChallengesStatusUpdateGroup()

@Serializable
data class MultiplayerChallengesStatusUpdate0(
    var eventId: UInt,
    var victories: UByte,
    var useSeasonPass: Boolean,
    var sponsorsSeed: UInt,
) : MultiplayerChallengesStatusUpdateGroup()

@Serializable
data class MultiplayerChallengesStatusUpdate10(
    var eventId: UInt,
    var finishedId: UByte,
) : MultiplayerChallengesStatusUpdateGroup()

@Serializable
data class MultiplayerChallengesStatusUpdate11(
    var eventId: UInt,
    var cooldownUntil: Instant,
) : MultiplayerChallengesStatusUpdateGroup()

@Serializable
data class MultiplayerChallengesStatusUpdate12(
    var boxId: UShort,
) : MultiplayerChallengesStatusUpdateGroup()

@Serializable
data class MultiplayerChallengesStatusUpdate3(
    var eventId: UInt,
    var revealedSponsorsStep: UByte,
) : MultiplayerChallengesStatusUpdateGroup()

@Serializable
data class MultiplayerChallengesStatusUpdate4(
    var eventId: UInt,
    var selectedSponsor: UInt,
) : MultiplayerChallengesStatusUpdateGroup()

@Serializable
data class MultiplayerChallengesStatusUpdate8(
    var eventId: UInt,
) : MultiplayerChallengesStatusUpdateGroup()

@Serializable
data class MultiplayerChallengesStatusUpdate9(
    var eventId: UInt,
) : MultiplayerChallengesStatusUpdateGroup()

@Serializable
data class MultiplayerChallengesVictoriesChanged(
    var eventId: UInt,
    var oldVictories: UByte,
    var newVictories: UByte,
) : MultiplayerChallengesStatusUpdateGroup()