package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.MissionState

class PlayerStatsState : RObject {

    var reputationLevel: Int = 0
    var reputationPoints: Int = 0
    var garageLevel: Short = 0
    var missionState: List<MissionState> = listOf()
    var garageValue: Int = 0
    var menuTutorials: List<RInt> = listOf()
    var gameplayTutorials: List<RInt> = listOf()
    var tutorialOrderTracking: List<RInt> = listOf()
    var rewardForLevelUpClaimed: Boolean = false

    override fun read(sink: InputSink) {
        reputationLevel = sink.readInt()
        reputationPoints = sink.readInt()
        garageLevel = sink.readShort()
        missionState = sink.readList()
        garageValue = sink.readInt()
        menuTutorials = sink.readList()
        gameplayTutorials = sink.readList()
        tutorialOrderTracking = sink.readList()
        rewardForLevelUpClaimed = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeInt(reputationLevel)
        sink.writeInt(reputationPoints)
        sink.writeShort(garageLevel)
        sink.writeList(missionState)
        sink.writeInt(garageValue)
        sink.writeList(menuTutorials)
        sink.writeList(gameplayTutorials)
        sink.writeList(tutorialOrderTracking)
        sink.writeBoolean(rewardForLevelUpClaimed)
    }
}