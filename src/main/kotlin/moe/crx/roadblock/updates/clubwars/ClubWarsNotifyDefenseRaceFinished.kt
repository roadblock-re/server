package moe.crx.roadblock.updates.clubwars

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.clubwars.ClubWarsNodeId
import moe.crx.roadblock.objects.game.*

class ClubWarsNotifyDefenseRaceFinished : RObject {

    var eventId: CalendarEventId = ""
    var nodeId: ClubWarsNodeId = ClubWarsNodeId()
    var clubId: ClubId = ""
    var memberCredential: Credentials = Credentials()
    var carId: CarId = 0
    var carUpgradeTier: CarUpgradeTier = 0
    var carRank: CarRank = 0
    var carGarageValue: GarageValue = 0
    var raceTime: Int = 0
    var timeImproved: Boolean = false
    var timestamp: Instant = now()

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        nodeId = sink.readObject()
        clubId = sink.readString()
        memberCredential = sink.readObject()
        carId = sink.readInt()
        carUpgradeTier = sink.readByte()
        carRank = sink.readShort()
        carGarageValue = sink.readInt()
        raceTime = sink.readInt()
        timeImproved = sink.readBoolean()
        timestamp = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeObject(nodeId)
        sink.writeString(clubId)
        sink.writeObject(memberCredential)
        sink.writeInt(carId)
        sink.writeByte(carUpgradeTier)
        sink.writeShort(carRank)
        sink.writeInt(carGarageValue)
        sink.writeInt(raceTime)
        sink.writeBoolean(timeImproved)
        sink.writeInstant(timestamp)
    }
}