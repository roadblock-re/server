package moe.crx.roadblock.core.routes

import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import moe.crx.roadblock.core.Configuration

fun Route.groupChatRoomsSubscribe(config: Configuration) = post("/chat/rooms/{channel}/subscribe") {
    val channel = call.parameters["channel"]

    checkNotNull(channel)

    val form = call.receiveParameters()
    form["access_token"]
    val language = form["language"]

    //checkNotNull(accessToken)
    checkNotNull(language)

    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            {
                "status": "ok",
                "https_listen_url": "https://${config.eveDomain}:443/groupchat/chat/rooms/a9_chat_room_febeb3b1-c9fe-4374-a2e0-f21ff1c32203?game=a9win&memberid=506746a9-0f5e-4827-9dfc-eb9ccbad8b81&language=en",
                "cmd_url": "https://${config.eveDomain}:443/groupchat/chat/rooms/a9_chat_room_febeb3b1-c9fe-4374-a2e0-f21ff1c32203",
                "listen_url": "http://${config.eveDomain}:80/groupchat/chat/rooms/a9_chat_room_febeb3b1-c9fe-4374-a2e0-f21ff1c32203?game=a9win&memberid=506746a9-0f5e-4827-9dfc-eb9ccbad8b81&language=en"
            }
            """.trimIndent(),
    )
}

fun Route.groupChatListenChatPost() = post("/chat/rooms/{channel}") {
    // Append {"type":"disconnect","reason":"Replaced by a new connection"} for disconnect
    // also should have leading empty line as I see
    // TODO Keep-Alive
    //call.respondFile(File("stubs/groupchat.json"))
    call.respondText("")
}

fun Route.groupChatListenChatGet() = get("/chat/rooms/{channel}") {
    // Append {"type":"disconnect","reason":"Replaced by a new connection"} for disconnect
    // also should have leading empty line as I see
    // TODO Keep-Alive
    //call.respondFile(File("stubs/groupchat.json"))
    call.respondText("")
}
