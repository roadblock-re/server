package moe.crx.roadblock

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import moe.crx.roadblock.plugins.configureWebSockets

fun webSocketServer() = embeddedServer(
    factory = Netty,
    configure = {
        sslConfig(4443)

        connector {
            port = 480
        }
    },
) {
    configureWebSockets()
}