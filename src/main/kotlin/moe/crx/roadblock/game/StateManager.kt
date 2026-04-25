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

        fun saveVersion(ver: SerializationVersion): SerializationVersion {
            if (ver eq "24.0.1") {
                return SerializationVersion("24.0.14")
            }

            if (ver eq "3.9.0") {
                return SerializationVersion("3.9.2")
            }

            if (ver eq "3.8.0") {
                return SerializationVersion("3.8.5")
            }

            if (ver eq "3.7.5") {
                return SerializationVersion("3.7.1002")
            }

            if (ver eq "3.6.3") {
                return SerializationVersion("3.6.2000")
            }

            if (ver eq "50.1.1") {
                return SerializationVersion("50.0.2")
            }

            return ver
        }
    }

    var stateFile = File(workingDirectory, "gamestate.saved.json")
    var stateBackupFile = File(workingDirectory, "gamestate.saved.json.bak")

    fun read(): State {
        lock.withLock {
            runCatching {
                return json.decodeFromString(stateFile.readText())
            }.onFailure {
                runCatching { stateFile.copyTo(stateBackupFile) }
                it.printStackTrace()
            }

            return default()
        }
    }

    // TODO Remove state argument, StateManager should store state
    fun write(state: State) {
        lock.withLock {
            stateFile.writeText(json.encodeToString(state))
        }
    }

    fun default(): State {
        return State()
    }
}