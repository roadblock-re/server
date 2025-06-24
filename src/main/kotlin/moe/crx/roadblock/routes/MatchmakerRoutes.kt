package moe.crx.roadblock.routes

import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import moe.crx.roadblock.utils.realRemoteHost

fun Route.matchmakerQuickLaunch() = post("/rooms/{clientId}/quick_launch") {
    val clientId = call.parameters["clientId"]

    checkNotNull(clientId)

    // ALU provides token via Access-Token header
    //val form = call.receiveParameters()
    //val accessToken = form["access_token"]

    //Newer versions (like 4.3.0h) and very old ones use TCP instead of WebSocket,
    //but it seems that game could work in WebSocket if gs_connection_info is present
    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            {
                "success": true,
                "gs_connection_info": {
                    "host": "%1",
                    "scheme": "wss",
                    "port": 4443
                },
                "controller_http_port": 4445,
                "room_id": "0f65cfc9-620f-4db7-88e6-d33cad87d82d",
                "controller_https_port": 4446,
                "action": "launch game",
                "controller_tcp_port": 4447,
                "controller_host": "%1",
                "controller_port": 4448
            }
            """.trimIndent().replace("%1", call.realRemoteHost()),
    )
}
