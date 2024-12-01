package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class ClubWarsMatchmakingData : RObject {

    var status: Int = 0
    var boardSide: Byte = 0
    var opponentClub: String = ""
    var defenseAssignedNodes: Short = 0
    var attackAssignedEntryPoints: Short = 0
    var opponentRegistrationScore: RInt? = null

    override fun read(sink: InputSink) {
        status = sink.readInt()
        boardSide = sink.readByte()
        opponentClub = sink.readString()
        defenseAssignedNodes = sink.readShort()
        attackAssignedEntryPoints = sink.readShort()
        opponentRegistrationScore = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(status)
        sink.writeByte(boardSide)
        sink.writeString(opponentClub)
        sink.writeShort(defenseAssignedNodes)
        sink.writeShort(attackAssignedEntryPoints)
        sink.writeOptional(opponentRegistrationScore)
    }
}