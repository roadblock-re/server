package moe.crx.roadblock.core

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import moe.crx.roadblock.core.plugins.configureApiRouting
import moe.crx.roadblock.core.plugins.configureLimits
import moe.crx.roadblock.core.plugins.configureLogging
import moe.crx.roadblock.core.plugins.configureSerialization
import moe.crx.roadblock.core.plugins.configureStatusPages

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