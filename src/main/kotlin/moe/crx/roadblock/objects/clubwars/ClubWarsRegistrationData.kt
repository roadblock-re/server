package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ClubWarsRegistrationData : RObject {

    var clubWhenJoined: String = ""
    var clubGarageValueWhenJoined: Int = 0
    var participationData: ClubWarsParticipationData? = null
    var finishState: Int = 0
    var matchmakingData: ClubWarsMatchmakingData = ClubWarsMatchmakingData()

    override fun read(sink: InputSink) {
        clubWhenJoined = sink.readString()
        clubGarageValueWhenJoined = sink.readInt()
        participationData = sink.readOptional()
        finishState = sink.readInt()
        matchmakingData = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(clubWhenJoined)
        sink.writeInt(clubGarageValueWhenJoined)
        sink.writeOptional(participationData)
        sink.writeInt(finishState)
        sink.writeObject(matchmakingData)
    }
}