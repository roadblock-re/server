package moe.crx.roadblock.routes

import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val logger: Logger = LoggerFactory.getLogger("roadblock.oct")

fun Route.octConnectionStatus() = post("/connectionstatus") {
    val form = call.receiveParameters()
    form["type"]
    form["status"]
    form["domain"]
    val connectionStatus = form["connectionstatus"]
    form["device_id"]
    form["client_id"]

    // TODO fix ChatRoomError
    if (connectionStatus != null && !connectionStatus.contains("ChatRoomError") && !connectionStatus.contains("iris.fetch")) {
        //logger.info("Got oct status: {}", connectionStatus) // TODO config option
    }

    call.respondText(
        text = "OK",
    )
}