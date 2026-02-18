package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class CarPreset : RObject {

    var type: CarPresetType = CarPresetType.Fixed
    var tierLevel: CarUpgradeTier = 0
    var upgradeLevelInfo: List<RByte> = listOf() // CarUpgradeLevel
    var importPartsInfo: List<RInt> = listOf() // UpgradeItems

    override fun read(sink: InputSink) {
        type = sink.readEnum()
        tierLevel = sink.readByte()
        upgradeLevelInfo = sink.readList()
        importPartsInfo = sink.readList()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(type)
        sink.writeByte(tierLevel)
        sink.writeList(upgradeLevelInfo)
        sink.writeList(importPartsInfo)
    }
}