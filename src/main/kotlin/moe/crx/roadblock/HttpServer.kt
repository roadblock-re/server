package moe.crx.roadblock

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import moe.crx.roadblock.plugins.*

fun httpServer(workingDirectory: String, config: Configuration) = embeddedServer(
    factory = Netty,
    configure = {
        sslConfig(workingDirectory, config.httpsPort, config.eveDomain)

        connector {
            port = config.httpPort
        }
    },
) {
    configureSerialization()
    configureLogging()
    configureLimits()
    configureStatusPages()
    configureApiRouting(workingDirectory, config)
}