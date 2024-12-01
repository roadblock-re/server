package moe.crx.roadblock.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.messageMe() = get("/messages/secured/me") {
    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            []
            """.trimIndent(),
    )
}
