package moe.crx.roadblock.core.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.messageMe() = get("/messages/secured/me") {
    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            [{
                "type": "gift",
                "body": "{\"gifts\":[],\"message\":\"Welcome to Roadblock!\"}",
                "gift_type": "dynamic_gift",
                "id": "gift_id_idk_bruh"
            }]
            """.trimIndent(),

        )
}
