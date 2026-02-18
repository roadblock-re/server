package moe.crx.roadblock.core.routes

import io.ktor.server.response.*
import io.ktor.server.routing.*
import moe.crx.roadblock.core.utils.realRemoteHost

fun Route.pandoraLocate() = get("/{clientId}/locate") {
    val clientId = call.parameters["clientId"]
    val service = call.queryParameters["service"]

    checkNotNull(clientId)
    checkNotNull(service)

    call.respondText(
        text = call.realRemoteHost() + ":443/" + service,
    )
}