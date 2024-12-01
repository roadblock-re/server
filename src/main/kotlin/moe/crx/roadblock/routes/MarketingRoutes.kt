package moe.crx.roadblock.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import moe.crx.roadblock.utils.decryptDesEcbZeroPadding
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val logger: Logger = LoggerFactory.getLogger("roadblock.marketing")

fun Route.marketingInGameNews() = post("/redir/ingamenews.php") {
    // Contains form-data

    call.respondText(
        contentType = ContentType.Application.Json,
        text = "{\"success\":false,\"current-id\":-1,\"unread\":-1}",
    )
}

fun Route.marketingRedirUpdate() = get("/redir/") {
    var data = call.queryParameters["data"]
    val enc = call.queryParameters["enc"]

    checkNotNull(data)

    if (enc == "2") {
        // HTTP and Base64 shenanigans
        data = data.replace(' ', '+')
        data = decryptDesEcbZeroPadding(data, "qPKBGA==")
    }

    logger.info("Redir called with: {}", data)

    call.respondRedirect("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
}
