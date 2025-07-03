package moe.crx.roadblock.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// TODO fix 406 Not Acceptable: POST - /iap-asa/inapp_crm/index.php
// TODO fix 404 Not Found: POST - /transaction/transactions/me/gifts
// TODO fix 404 Not Found: POST - /transaction/transactions/me/gift_bundles

fun Route.iapOrders() = get("/inapp_crm/orders/index.php/") {
    call.queryParameters["portal"]
    call.queryParameters["steam_id"]

    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            []
            """.trimIndent(),
    )
}

fun Route.iapIndexGet() = get("/inapp_crm/index.php/") {
    call.queryParameters["shop"]
    val action = call.queryParameters["action"]

    if (action == "check_limit") {
        call.respondText(
            contentType = ContentType.Application.Json,
            text = """
            {
              "enabled": false
            }
            """.trimIndent(),
        )
        return@get
    }

    call.respond(HttpStatusCode.NotFound)
}

fun Route.iapIndexPost() = post("/inapp_crm/index.php/") {
    call.respond(HttpStatusCode.InternalServerError)
}