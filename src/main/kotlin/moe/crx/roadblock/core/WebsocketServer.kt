package moe.crx.roadblock.core

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import moe.crx.roadblock.core.plugins.configureWebSockets

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