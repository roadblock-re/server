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
import moe.crx.roadblock.objects.game.OverclockChips
import moe.crx.roadblock.objects.game.WalletState
import moe.crx.roadblock.objects.inventory.CarState
import moe.crx.roadblock.objects.inventory.MaintenanceBooking
import moe.crx.roadblock.objects.inventory.StatUpgradeInfoState
import moe.crx.roadblock.objects.inventory.WildcardBlueprintClassState

class InventoryState : RObject {

    var cars: Map<RInt, CarState> = mapOf()
    var wallets: List<WalletState> = listOf()

    var iapWallets: Map<RInt, WalletState> = mapOf() // 3.9+ only (also maybe 3.8)
    var wildcardBlueprints: List<WildcardBlueprintClassState> = listOf()
    var wildcardUpgradeItems: List<RInt> = listOf()
    var upgradeInfoState: List<StatUpgradeInfoState> = listOf()
    var lastActionTime: Instant = now()
    var maintenanceBooking: MaintenanceBooking? = null
    var emojisState: EmojisState = EmojisState()
    var overclockChips: OverclockChips = 0

    override fun read(sink: InputSink) {
        cars = sink.readMap()
        wallets = sink.readList()
        iapWallets = sink.readMap()
        wildcardBlueprints = sink.readList()
        if (sink newer "24.6.0") {
            wildcardUpgradeItems = sink.readList()
        }
        upgradeInfoState = sink.readList()
        lastActionTime = sink.readInstant()
        maintenanceBooking = sink.readOptional()
        emojisState = sink.readObject()
        if (sink newer "24.0.0") {
            overclockChips = sink.readInt()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeMap(cars)
        sink.writeList(wallets)
        sink.writeMap(iapWallets)
        sink.writeList(wildcardBlueprints)
        if (sink newer "24.6.0") {
            sink.writeList(wildcardUpgradeItems)
        }
        sink.writeList(upgradeInfoState)
        sink.writeInstant(lastActionTime)
        sink.writeOptional(maintenanceBooking)
        sink.writeObject(emojisState)
        if (sink newer "24.0.0") {
            sink.writeInt(overclockChips)
        }
    }
}