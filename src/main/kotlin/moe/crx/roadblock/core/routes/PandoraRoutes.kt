package moe.crx.roadblock.core.routes

import io.ktor.server.response.*
import io.ktor.server.routing.*
import moe.crx.roadblock.core.Configuration

fun Route.pandoraLocate(config: Configuration) = get("/{clientId}/locate") {
    val clientId = call.parameters["clientId"]
    val service = call.queryParameters["service"]

    checkNotNull(clientId)
    checkNotNull(service)

    call.respondText(
        text = "${config.eveDomain}:443/$service",
    )
}