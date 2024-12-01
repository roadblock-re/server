package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.privatelobby.PrivateLobbyRaceFinished
import moe.crx.roadblock.updates.privatelobby.PrivateLobbyRemoveEvents

class PrivateLobbyStatusUpdateGroup : RVariant(
    PrivateLobbyRemoveEvents::class,
    PrivateLobbyRaceFinished::class,
)