package moe.crx.roadblock.rpc.auth

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.*

class LoginResponse : RObject {
    companion object {
        const val GAME_SIGNATURE = 0x47DCEC79
    }

    var error: ServerError? = null
    var userSessionId: String = ""
    var revision: String = ""
    var actionResponseParams: ActionResponseHeader = ActionResponseHeader()
    var lastServerActionId: Int = 0
    var updatesQueue: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions()
    var configData: ConfigData = ConfigData()
    var serverDBs: ServerDBSerialization = ServerDBSerialization()
    var serverSyslogId: String = ""
    var buildId: String = ""
    var didMaintenanceFreeRefill: Boolean = false
    var remindNewGarageLevel: Boolean = false
    var isClientReloadNeeded: Boolean = false
    var isVipPlayer: Boolean = false
    var isForcedUserName: Boolean = false
    var signatureValue: Int = 0
    var serializationVersion: SerializationVersion = SerializationVersion()
    var state: State = State()

    override fun read(sink: InputSink) {
        check(sink.readByte() == 0.toByte())
        error = sink.readOptional()
        userSessionId = sink.readString()
        revision = sink.readString()
        actionResponseParams = sink.readObject()
        lastServerActionId = sink.readInt()
        updatesQueue = sink.readObject()
        configData = sink.readObject()
        serverDBs = sink.readObject()
        serverSyslogId = sink.readString()
        buildId = sink.readString()
        didMaintenanceFreeRefill = sink.readBoolean()
        remindNewGarageLevel = sink.readBoolean()
        isClientReloadNeeded = sink.readBoolean()
        isVipPlayer = sink.readBoolean()
        if (sink newer "24.0.0") {
            isForcedUserName = sink.readBoolean()
        }
        signatureValue = sink.readInt()
        serializationVersion = sink.readObject()
        state = sink.readObject()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(0)
        sink.writeOptional(error)
        sink.writeString(userSessionId)
        sink.writeString(revision)
        sink.writeObject(actionResponseParams)
        sink.writeInt(lastServerActionId)
        sink.writeObject(updatesQueue)
        sink.writeObject(configData)
        sink.writeObject(serverDBs)
        sink.writeString(serverSyslogId)
        sink.writeString(buildId)
        sink.writeBoolean(didMaintenanceFreeRefill)
        sink.writeBoolean(remindNewGarageLevel)
        sink.writeBoolean(isClientReloadNeeded)
        sink.writeBoolean(isVipPlayer)
        if (sink newer "24.0.0") {
            sink.writeBoolean(isForcedUserName)
        }
        sink.writeInt(signatureValue)
        sink.writeObject(serializationVersion)
        sink.writeObject(state)
    }
}
