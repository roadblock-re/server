package moe.crx.roadblock.game

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.objects.models.State
import java.io.File
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class StateManager(workingDirectory: String) {

    companion object {
        var json = Json {
            encodeDefaults = true
            explicitNulls = true
            ignoreUnknownKeys = true
            prettyPrint = true
            allowStructuredMapKeys = true
        }

        var lock: ReentrantLock = ReentrantLock()
    }

    var stateFile = File(workingDirectory, "gamestate.saved.json")
    var stateBackupFile = File(workingDirectory, "gamestate.saved.json.bak")

    fun read(ver: SerializationVersion): State {
        lock.withLock {
            runCatching {
                return json.decodeFromString(stateFile.readText())
            }.onFailure {
                runCatching { stateFile.copyTo(stateBackupFile) }
                it.printStackTrace()
            }

            return default(ver)
        }
    }

    // TODO Remove state argument, StateManager should store state
    fun write(state: State, ver: SerializationVersion) {
        lock.withLock {
            stateFile.writeText(json.encodeToString(state))
        }
    }

    fun default(ver: SerializationVersion): State {
        return State()
    }
}