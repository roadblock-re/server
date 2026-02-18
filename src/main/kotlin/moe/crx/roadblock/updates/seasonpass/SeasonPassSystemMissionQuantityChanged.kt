package moe.crx.roadblock.updates.seasonpass

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.SeasonPassEpisodeId
import moe.crx.roadblock.objects.game.SeasonPassMissionId
import moe.crx.roadblock.objects.seasonpass.MissionProgress
import moe.crx.roadblock.objects.seasonpass.SeasonPassMissionType

class SeasonPassSystemMissionQuantityChanged : RObject {

    var eventId: CalendarEventId = ""
    var episodeId: SeasonPassEpisodeId = 0
    var missionId: SeasonPassMissionId = 0
    var type: SeasonPassMissionType = SeasonPassMissionType.Incremental
    var oldQuantity: MissionProgress = MissionProgress()
    var newQuantity: MissionProgress = MissionProgress()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        episodeId = sink.readByte()
        missionId = sink.readShort()
        type = sink.readEnum()
        oldQuantity = sink.readObject()
        newQuantity = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeByte(episodeId)
        sink.writeShort(missionId)
        sink.writeEnum(type)
        sink.writeObject(oldQuantity)
        sink.writeObject(newQuantity)
    }
}