package moe.crx.roadblock.core.routes

import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.etsV2Binary() = post("/binary") {
    // Contains form-data

    call.respondText("")
}
