package moe.crx.roadblock.objects.multiplayer

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.base.RString

class MultiplayerSeriesEventState : RObject {

    var elo: Float = 0f
    var leaderboardData: MultiplayerSeriesLeaderboardData? = null
    var racesCount: Int = 0
    var currentTier: MultiplayerSeriesTierInfo = MultiplayerSeriesTierInfo()
    var maxTier: MultiplayerSeriesTierInfo = MultiplayerSeriesTierInfo()
    var participationState: Int = 0
    var leaderboardName: RString? = null
    var forceQuarantine: Boolean = false
    var score: Int = 0
    var skippedBonusMilestones: List<RByte> = listOf()
    var peakScore: Int = 0

    override fun read(sink: InputSink) {
        elo = sink.readFloat()
        leaderboardData = sink.readOptional()
        racesCount = sink.readInt()
        currentTier = sink.readObject()
        maxTier = sink.readObject()
        participationState = sink.readInt()
        leaderboardName = sink.readOptional()
        forceQuarantine = sink.readBoolean()
        score = sink.readInt()
        skippedBonusMilestones = sink.readList()
        if (sink newer "24.0.0") {
            peakScore = sink.readInt()
        }
    }

    override fun write(sink: OutputSink) {
        sink.writeFloat(elo)
        sink.writeOptional(leaderboardData)
        sink.writeInt(racesCount)
        sink.writeObject(currentTier)
        sink.writeObject(maxTier)
        sink.writeInt(participationState)
        sink.writeOptional(leaderboardName)
        sink.writeBoolean(forceQuarantine)
        sink.writeInt(score)
        sink.writeList(skippedBonusMilestones)
        if (sink newer "24.0.0") {
            sink.writeInt(peakScore)
        }
    }
}