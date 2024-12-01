package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.mpchallenges.*

// Update group 0x0D
// TODO Update names
class MultiplayerChallengesStatusUpdateGroup : RVariant(
    MultiplayerChallengesStatusUpdate0::class,
    MultiplayerChallengesRaceFinished::class,
    MultiplayerChallengesRemoveEvents::class,
    MultiplayerChallengesStatusUpdate3::class,
    MultiplayerChallengesStatusUpdate4::class,
    MultiplayerChallengesVictoriesChanged::class,
    MultiplayerChallengesRevivesChanged::class,
    MultiplayerChallengesDefeatsChanged::class,
    MultiplayerChallengesStatusUpdate8::class,
    MultiplayerChallengesStatusUpdate9::class,
    MultiplayerChallengesStatusUpdate10::class,
    MultiplayerChallengesStatusUpdate11::class,
    MultiplayerChallengesStatusUpdate12::class,
)