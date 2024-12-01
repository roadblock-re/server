package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.io.EnumIO.readEnum
import moe.crx.roadblock.io.EnumIO.writeEnum
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.MenuTutorialType
import moe.crx.roadblock.objects.game.TutorialState
import moe.crx.roadblock.rpc.base.RequestPacket

class ChangeMenuTutorialStateRequest : RequestPacket() {

    var menuTutorialType: MenuTutorialType = MenuTutorialType.MainMenuCareer
    var tutorialState: TutorialState = TutorialState.Pending
    var durationMicroseconds: Int = 0

    override fun read(sink: InputSink) {
        super.read(sink)
        menuTutorialType = sink.readEnum()
        tutorialState = sink.readEnum()
        durationMicroseconds = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeEnum(menuTutorialType)
        sink.writeEnum(tutorialState)
        sink.writeInt(durationMicroseconds)
    }
}