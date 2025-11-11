package moe.crx.roadblock.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import moe.crx.roadblock.game.GameConnection
import kotlin.time.Duration.Companion.seconds

fun Application.configureWebSockets(workingDirectory: String) {
    install(WebSockets) {
        pingPeriod = 60.seconds
        timeout = 60.seconds
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }

    routing {
        webSocket("/") {
            val connection = GameConnection(workingDirectory) { bytes, preferDeflated ->
                send(bytes)
            }

            try {
                for (frame in incoming) {
                    if (frame is Frame.Binary) {
                        val bytes = frame.readBytes()
                        connection.receive(bytes)
                    }
                }
            } finally {
                connection.close()
            }
        }
    }
}