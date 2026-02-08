package moe.crx.roadblock

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import moe.crx.roadblock.plugins.configureWebSockets

fun webSocketServer(workingDirectory: String, config: Configuration) = embeddedServer(
    factory = Netty,
    configure = {
        sslConfig(workingDirectory, config.wssPort, config.eveDomain)

        connector {
            port = config.wsPort
        }
    },
) {
    configureWebSockets(workingDirectory)
}