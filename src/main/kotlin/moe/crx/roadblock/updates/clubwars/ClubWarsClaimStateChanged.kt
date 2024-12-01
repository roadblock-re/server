package moe.crx.roadblock.updates.clubwars

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.clubwars.ClubWarsClaimState
import moe.crx.roadblock.objects.game.CalendarEventId
import moe.crx.roadblock.objects.game.ClubWarsRewardIndex
import moe.crx.roadblock.objects.game.LeaderboardPosition

class ClubWarsClaimStateChanged : RObject {

    var eventId: CalendarEventId = ""
    var state: ClubWarsClaimState = ClubWarsClaimState.Unknown
    var leaderboardPosition: LeaderboardPosition = 0
    var rewardIdx: ClubWarsRewardIndex = 0

    override fun read(sink: InputSink) {
        eventId = sink.readString()
        state = sink.readEnum()
        leaderboardPosition = sink.readInt()
        rewardIdx = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeString(eventId)
        sink.writeEnum(state)
        sink.writeInt(leaderboardPosition)
        sink.writeByte(rewardIdx)
    }
}