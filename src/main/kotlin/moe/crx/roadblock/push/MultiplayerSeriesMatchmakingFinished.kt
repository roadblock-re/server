package moe.crx.roadblock.push

import moe.crx.roadblock.io.ObjectIO.readObject
import moe.crx.roadblock.io.ObjectIO.writeObject
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.game.RaceToken
import moe.crx.roadblock.objects.game.StatusUpdatesQueueWithRootReactions
import moe.crx.roadblock.objects.multiplayer.GameServerConnectionInfo

class MultiplayerSeriesMatchmakingFinished : PushMessagePacket() {

    var raceToken: RaceToken = 0
    var roomId: String = ""
    var server: String = ""
    var port: Short = 0
    var updatesQueue: StatusUpdatesQueueWithRootReactions = StatusUpdatesQueueWithRootReactions()
    var gameServerConnectionInfo: GameServerConnectionInfo? = null
    var gameLiftPlayerSessionId: RString? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        raceToken = sink.readInt()
        roomId = sink.readString()
        server = sink.readString()
        port = sink.readShort()
        updatesQueue = sink.readObject()
        gameServerConnectionInfo = sink.readOptional()
        gameLiftPlayerSessionId = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(raceToken)
        sink.writeString(roomId)
        sink.writeString(server)
        sink.writeShort(port)
        sink.writeObject(updatesQueue)
        sink.writeOptional(gameServerConnectionInfo)
        sink.writeOptional(gameLiftPlayerSessionId)
    }
}