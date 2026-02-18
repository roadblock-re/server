package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.game.ConfigData
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class ActionLoginResponse : UpdatesQueueWithRootReactionsResponse() {

    var data: ConfigData = ConfigData()
    var didMaintenanceFreeRefill: Boolean = false
    var remindNewGarageLevel: Boolean = false
    var isClientReloadNeeded: Boolean = false
    var isVipPlayer: Boolean = false
    var isForcedUserName: Boolean = false

    override fun read(sink: InputSink) {
        super.read(sink)
        data = sink.readObject()
        didMaintenanceFreeRefill = sink.readBoolean()
        remindNewGarageLevel = sink.readBoolean()
        isClientReloadNeeded = sink.readBoolean()
        isVipPlayer = sink.readBoolean()
        isForcedUserName = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeObject(data)
        sink.writeBoolean(didMaintenanceFreeRefill)
        sink.writeBoolean(remindNewGarageLevel)
        sink.writeBoolean(isClientReloadNeeded)
        sink.writeBoolean(isVipPlayer)
        sink.writeBoolean(isForcedUserName)
    }
}