package moe.crx.roadblock.objects.game

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class SNSUserConflictData : RObject {

    var username: String = ""
    var carsOwned: Int = 0
    var garageLevel: GarageLevel = 0
    var reputationLevel: ReputationLevel = 0
    var credits: Money = 0
    var tokens: Money = 0
    var careerFlags: Flags = 0
    var lastTimePlayed: Instant = now()
    var channelName: RString? = null
    var ownsCurrentSeasonPass: Boolean = false

    override fun read(sink: InputSink) {
        username = sink.readString()
        carsOwned = sink.readInt()
        garageLevel = sink.readShort()
        reputationLevel = sink.readInt()
        credits = sink.readInt()
        tokens = sink.readInt()
        careerFlags = sink.readInt()
        lastTimePlayed = sink.readInstant()
        channelName = sink.readOptional()
        ownsCurrentSeasonPass = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(username)
        sink.writeInt(carsOwned)
        sink.writeShort(garageLevel)
        sink.writeInt(reputationLevel)
        sink.writeInt(credits)
        sink.writeInt(tokens)
        sink.writeInt(careerFlags)
        sink.writeInstant(lastTimePlayed)
        sink.writeOptional(channelName)
        sink.writeBoolean(ownsCurrentSeasonPass)
    }
}