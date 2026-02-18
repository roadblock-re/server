package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CarRank
import moe.crx.roadblock.objects.game.CarUpgradeTier
import moe.crx.roadblock.objects.game.GarageValue

class ClubWarsCarStatusUpdate : RObject {

    var id: CarId = 0
    var upgradeTier: CarUpgradeTier = 0
    var rank: CarRank = 0
    var garageValue: GarageValue = 0

    override fun read(sink: InputSink) {
        id = sink.readInt()
        upgradeTier = sink.readByte()
        rank = sink.readShort()
        garageValue = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(id)
        sink.writeByte(upgradeTier)
        sink.writeShort(rank)
        sink.writeInt(garageValue)
    }
}