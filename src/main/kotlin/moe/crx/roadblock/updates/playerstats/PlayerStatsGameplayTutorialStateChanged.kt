package moe.crx.roadblock.updates.playerstats

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.GameplayTutorialType
import moe.crx.roadblock.objects.game.TutorialState

class PlayerStatsGameplayTutorialStateChanged : RObject {

    var type: GameplayTutorialType = GameplayTutorialType.TutorialRaceStart
    var oldState: TutorialState = TutorialState.Pending
    var newState: TutorialState = TutorialState.Pending

    override fun read(sink: InputSink) {
        type = sink.readEnum()
        oldState = sink.readEnum()
        newState = sink.readEnum()
    }

    override fun write(sink: OutputSink) {
        sink.writeEnum(type)
        sink.writeEnum(oldState)
        sink.writeEnum(newState)
    }
}