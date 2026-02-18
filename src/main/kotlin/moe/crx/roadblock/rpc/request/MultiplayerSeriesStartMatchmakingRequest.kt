package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.*
import moe.crx.roadblock.rpc.base.RequestPacket

class MultiplayerSeriesStartMatchmakingRequest : RequestPacket() {

    var debugOptions: MultiplayerSeriesMatchmakingDebugOptions = MultiplayerSeriesMatchmakingDebugOptions()
    var seriesId: MultiplayerSeriesId = 0
    var eventId: CalendarEventId = ""
    var carId: CarId = 0
    var controlSchemeType: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive
    var regionLatencyMap: RegionLatencyMap? = null
    var connectivityType: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        debugOptions = sink.readObject()
        seriesId = sink.readInt()
        eventId = sink.readString()
        carId = sink.readInt()
        controlSchemeType = sink.readEnum()
        regionLatencyMap = sink.readOptional()
        connectivityType = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(debugOptions)
        sink.writeInt(seriesId)
        sink.writeString(eventId)
        sink.writeInt(carId)
        sink.writeEnum(controlSchemeType)
        sink.writeOptional(regionLatencyMap)
        sink.writeString(connectivityType)
    }
}