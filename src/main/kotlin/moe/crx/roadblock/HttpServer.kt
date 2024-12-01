package moe.crx.roadblock

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import moe.crx.roadblock.plugins.*

fun httpServer() = embeddedServer(
    factory = Netty,
    configure = {
        sslConfig(443)

        connector {
            port = 80
        }
    },
) {
    configureSerialization()
    configureLogging()
    configureLimits()
    configureStatusPages()
    configureApiRouting()
}