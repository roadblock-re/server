package moe.crx.roadblock.rpc.auth

import moe.crx.roadblock.io.ListIO.readList
import moe.crx.roadblock.io.ListIO.writeList
import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.*
import moe.crx.roadblock.rpc.base.AuthPacket

class LoginRequest : AuthPacket() {

    var gameVersion: String = ""
    var typeSystemHash: Long = 0
    var clientId: String = ""
    var datacenterName: String = ""

    //var clientBuildId: String = "" // ALU has it
    var userToken: String = ""
    var credentials: Credentials = Credentials()
    var deviceInfo: DeviceInfo = DeviceInfo()
    var lastRequestHeader: ActionRequestHeader = ActionRequestHeader()
    var lastResponseHeader: ActionResponseHeader = ActionResponseHeader()
    var lastServerActionId: Int = 0
    var trackingParameters: TrackingParameters = TrackingParameters()
    var launchSystemNotification: RInt? = null
    var channelName: RString? = null
    var forceLoadEvents: ForceLoadEvents? = null
    var platformCredentials: PlatformCredentials? = null

    //var platformUsername: RString? = null // ALU has it
    //var psnIssuerId: RString? = null // ALU has it
    //var serverDeltaTimeMinutes: Int = 0 // ALU has it
    var clientCachedEvents: List<CachedEventInfo> = listOf()

    override fun read(sink: InputSink) {
        super.read(sink)
        gameVersion = sink.readString()
        typeSystemHash = sink.readLong()
        clientId = sink.readString()
        datacenterName = sink.readString()
        //clientBuildId = sink.readString()
        userToken = sink.readString()
        credentials = sink.readObject()
        deviceInfo = sink.readObject()
        lastRequestHeader = sink.readObject()
        lastResponseHeader = sink.readObject()
        lastServerActionId = sink.readInt()
        trackingParameters = sink.readObject()
        launchSystemNotification = sink.readOptional()
        channelName = sink.readOptional()
        forceLoadEvents = sink.readOptional()
        platformCredentials = sink.readOptional()
        //platformUsername = sink.readOptional()
        //psnIssuerId = sink.readOptional()
        //serverDeltaTimeMinutes = sink.readInt()
        clientCachedEvents = sink.readList()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeString(gameVersion)
        sink.writeLong(typeSystemHash)
        sink.writeString(clientId)
        sink.writeString(datacenterName)
        //sink.writeString(clientBuildId)
        sink.writeString(userToken)
        sink.writeObject(credentials)
        sink.writeObject(deviceInfo)
        sink.writeObject(lastRequestHeader)
        sink.writeObject(lastResponseHeader)
        sink.writeInt(lastServerActionId)
        sink.writeObject(trackingParameters)
        sink.writeOptional(launchSystemNotification)
        sink.writeOptional(channelName)
        sink.writeOptional(forceLoadEvents)
        sink.writeOptional(platformCredentials)
        //sink.writeOptional(platformUsername)
        //sink.writeOptional(psnIssuerId)
        //sink.writeInt(serverDeltaTimeMinutes)
        sink.writeList(clientCachedEvents)
    }
}