package moe.crx.roadblock.core.routes

import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import moe.crx.roadblock.core.Configuration
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val logger: Logger = LoggerFactory.getLogger("roadblock.oct")

fun Route.octConnectionStatus(config: Configuration) = post("/connectionstatus") {
    val form = call.receiveParameters()
    form["type"]
    form["status"]
    form["domain"]
    val connectionStatus = form["connectionstatus"]
    form["device_id"]
    form["client_id"]

    // TODO fix ChatRoomError
    if (connectionStatus != null && !connectionStatus.contains("ChatRoomError") && !connectionStatus.contains("iris.fetch")) {
        if (config.reportOctStatus) {
            logger.info("Got oct status: {}", connectionStatus)
        }
    }

    call.respondText(
        text = "OK",
    )
}