package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.CarId
import moe.crx.roadblock.objects.game.CarStatType
import moe.crx.roadblock.objects.game.CarUpgradeLevel
import moe.crx.roadblock.rpc.base.RequestPacket

class UpgradeCarStatLevelRequest : RequestPacket() {

    var carId: CarId = 0
    var statType: CarStatType = CarStatType.TopSpeed
    var upgradeLevel: CarUpgradeLevel = 0
    var eventId: RString? = null // CalendarEventId

    override fun read(sink: InputSink) {
        super.read(sink)
        carId = sink.readInt()
        statType = sink.readEnum()
        upgradeLevel = sink.readByte()
        eventId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(carId)
        sink.writeEnum(statType)
        sink.writeByte(upgradeLevel)
        sink.writeOptional(eventId)
    }
}