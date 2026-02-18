package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject

class MultiplayerSeriesMatchmakingDebugOptions : RObject {

    var minUsers: RInt? = null
    var policeCars: RInt? = null
    var maxDisqualificationSeconds: RInt? = null
    var raceConfigId: RInt? = null
    var disableQuickWinEnabledInSingleUserRaces: Boolean = false
    var gameplayServerType: GameplayServerType = GameplayServerType.Anubis
    var standaloneGameplayServerAddress: String = ""
    var standaloneGameplayServerPort: Short = 0
    var standaloneGameplayServerCapacity: Int = 0
    var isEndlessRace: Boolean = false

    override fun read(sink: InputSink) {
        minUsers = sink.readOptional()
        policeCars = sink.readOptional()
        maxDisqualificationSeconds = sink.readOptional()
        raceConfigId = sink.readOptional()
        disableQuickWinEnabledInSingleUserRaces = sink.readBoolean()
        gameplayServerType = sink.readEnum()
        standaloneGameplayServerAddress = sink.readString()
        standaloneGameplayServerPort = sink.readShort()
        standaloneGameplayServerCapacity = sink.readInt()
        isEndlessRace = sink.readBoolean()
    }

    override fun write(sink: OutputSink) {
        sink.writeOptional(minUsers)
        sink.writeOptional(policeCars)
        sink.writeOptional(maxDisqualificationSeconds)
        sink.writeOptional(raceConfigId)
        sink.writeBoolean(disableQuickWinEnabledInSingleUserRaces)
        sink.writeEnum(gameplayServerType)
        sink.writeString(standaloneGameplayServerAddress)
        sink.writeShort(standaloneGameplayServerPort)
        sink.writeInt(standaloneGameplayServerCapacity)
        sink.writeBoolean(isEndlessRace)
    }
}