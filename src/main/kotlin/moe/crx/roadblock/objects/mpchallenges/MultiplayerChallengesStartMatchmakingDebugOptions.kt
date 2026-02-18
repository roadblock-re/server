package moe.crx.roadblock.objects.mpchallenges

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.GameplayServerType

class MultiplayerChallengesStartMatchmakingDebugOptions : RObject {

    var singleUser: Boolean = false
    var maxDisqualificationSeconds: RInt? = null
    var raceConfigId: RInt? = null
    var gameplayServerType: GameplayServerType = GameplayServerType.Anubis
    var standaloneGameplayServerAddress: String = ""
    var standaloneGameplayServerPort: Short = 0
    var standaloneGameplayServerCapacity: Int = 0

    override fun read(sink: InputSink) {
        singleUser = sink.readBoolean()
        maxDisqualificationSeconds = sink.readOptional()
        raceConfigId = sink.readOptional()
        gameplayServerType = sink.readEnum()
        standaloneGameplayServerAddress = sink.readString()
        standaloneGameplayServerPort = sink.readShort()
        standaloneGameplayServerCapacity = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        sink.writeBoolean(singleUser)
        sink.writeOptional(maxDisqualificationSeconds)
        sink.writeOptional(raceConfigId)
        sink.writeEnum(gameplayServerType)
        sink.writeString(standaloneGameplayServerAddress)
        sink.writeShort(standaloneGameplayServerPort)
        sink.writeInt(standaloneGameplayServerCapacity)
    }
}