package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.MapIO.readMap
import moe.crx.roadblock.game.io.MapIO.writeMap
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.VaultTicket
import moe.crx.roadblock.objects.vault.VaultSlotsState

class VaultSystemState : RObject {

    var ticketBalance: VaultTicket = 0
    var lastTicketRefilledTime: Instant = now()
    var vaultSlots: List<VaultSlotsState> = listOf()
    var isLocked: Boolean = false
    var eventDataById: Map<RInt, VaultEventState> = mapOf()
    var alreadyPlayedEvents: List<RInt> = listOf()
    var unlockedEventsByReward: List<RInt> = listOf()
    var vaultRewardsIndexesState: VaultRewardsIndexesState = VaultRewardsIndexesState()
    var hasTransitionedToSingleStruct: Boolean = false

    override fun read(sink: InputSink) {
        ticketBalance = sink.readInt()
        lastTicketRefilledTime = sink.readInstant()
        vaultSlots = sink.readList()
        isLocked = sink.readBoolean()
        eventDataById = sink.readMap()
        alreadyPlayedEvents = sink.readList()
        unlockedEventsByReward = sink.readList()
        vaultRewardsIndexesState = sink.readObject()
        hasTransitionedToSingleStruct = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(ticketBalance)
        sink.writeInstant(lastTicketRefilledTime)
        sink.writeList(vaultSlots)
        sink.writeBoolean(isLocked)
        sink.writeMap(eventDataById)
        sink.writeList(alreadyPlayedEvents)
        sink.writeList(unlockedEventsByReward)
        sink.writeObject(vaultRewardsIndexesState)
        sink.writeBoolean(hasTransitionedToSingleStruct)
    }
}