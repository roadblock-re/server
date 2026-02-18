package moe.crx.roadblock.core.routes

import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.gdidAssignGlobalId() = get("/assign_global_id") {
    call.respondText(
        text = "1234567890123456789",
    )
}