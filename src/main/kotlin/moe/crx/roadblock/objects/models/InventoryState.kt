package moe.crx.roadblock.objects.models

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.MapIO.readMap
import moe.crx.roadblock.io.MapIO.writeMap
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.EmojisState
import moe.crx.roadblock.objects.game.WalletState
import moe.crx.roadblock.objects.inventory.CarState
import moe.crx.roadblock.objects.inventory.MaintenanceBooking
import moe.crx.roadblock.objects.inventory.StatUpgradeInfoState
import moe.crx.roadblock.objects.inventory.WildcardBlueprintClassState

class InventoryState : RObject {

    var cars: List<CarState> = listOf()
    var wallets: List<WalletState> = listOf()
    //var iapWallets37: List<WalletState> = listOf()

    var iapWallets39: Map<RInt, WalletState> = mapOf() // 3.9+ only (also maybe 3.8)
    var wildcardBlueprints: List<WildcardBlueprintClassState> = listOf()
    var upgradeInfoState: List<StatUpgradeInfoState> = listOf()
    var lastActionTime: Instant = now()
    var maintenanceBooking: MaintenanceBooking? = null
    var emojisState: EmojisState = EmojisState()

    override fun read(sink: InputSink) {
        cars = sink.readList()
        wallets = sink.readList()
        //iapWallets37 = sink.readList()
        iapWallets39 = sink.readMap()
        wildcardBlueprints = sink.readList()
        upgradeInfoState = sink.readList()
        lastActionTime = sink.readInstant()
        maintenanceBooking = sink.readOptional()
        emojisState = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeList(cars)
        sink.writeList(wallets)
        //sink.writeList(iapWallets37)
        sink.writeMap(iapWallets39)
        sink.writeList(wildcardBlueprints)
        sink.writeList(upgradeInfoState)
        sink.writeInstant(lastActionTime)
        sink.writeOptional(maintenanceBooking)
        sink.writeObject(emojisState)
    }
}