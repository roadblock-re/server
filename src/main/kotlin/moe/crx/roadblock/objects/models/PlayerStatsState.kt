package moe.crx.roadblock.objects.models

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.*

class PlayerStatsState : RObject {

    var reputationLevel: ReputationLevel = 0
    var reputationPoints: ReputationPoints = 0
    var garageLevel: GarageLevel = 0
    var missionState: List<MissionState> = listOf()
    var garageValue: GarageValue = 0
    var menuTutorials: List<RInt> = listOf()
    var gameplayTutorials: List<RInt> = listOf()
    var tutorialOrderTracking: List<RInt> = listOf()
    var rewardForLevelUpClaimed: Boolean = false
    var lastGarageLevelWithClaimedReward: GarageLevel = 0
    var collectorStage: CollectorStage = 0
    var lastCollectorStageWithClaimedReward: CollectorStage = 0

    override fun read(sink: InputSink) {
        reputationLevel = sink.readInt()
        reputationPoints = sink.readInt()
        garageLevel = sink.readShort()
        missionState = sink.readList()
        garageValue = sink.readInt()
        menuTutorials = sink.readList()
        gameplayTutorials = sink.readList()
        tutorialOrderTracking = sink.readList()
        if (sink older "24.0.0") {
            rewardForLevelUpClaimed = sink.readBoolean()
        }
        if (sink newer "24.0.0") {
            lastGarageLevelWithClaimedReward = sink.readShort()
            collectorStage = sink.readShort()
            lastCollectorStageWithClaimedReward = sink.readShort()
        }
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
        if (sink older "24.0.0") {
            sink.writeBoolean(rewardForLevelUpClaimed)
        }

        if (sink newer "24.0.0") {
            sink.writeShort(lastGarageLevelWithClaimedReward)
            sink.writeShort(collectorStage)
            sink.writeShort(lastCollectorStageWithClaimedReward)
        }
    }
}