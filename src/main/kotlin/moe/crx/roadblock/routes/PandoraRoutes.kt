package moe.crx.roadblock.routes

import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.pandoraLocate() = get("/{clientId}/locate") {
    val clientId = call.parameters["clientId"]
    val service = call.queryParameters["service"]

    checkNotNull(clientId)
    checkNotNull(service)

    call.respondText(
        text = call.request.host() + ":443/" + service,
    )
}