package moe.crx.roadblock.core.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*

fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            renderPage(null, call, cause)
        }
        status(HttpStatusCode.NotFound) { code ->
            renderPage(code, call, Exception("Page not found."))
        }
        status(HttpStatusCode.InternalServerError) { code ->
            renderPage(
                code,
                call,
                Exception("Internal server error.")
            )
        }
        status(HttpStatusCode.Unauthorized) { code ->
            renderPage(code, call, Exception("Unauthorized."))
        }
        status(HttpStatusCode.TooManyRequests) { call, status ->
            val retryAfter = call.response.headers["Retry-After"]
            call.respond(
                HttpStatusCode.TooManyRequests,
                mapOf("call" to call.request.uri, "error" to "timeout", "retry_after" to (retryAfter ?: "60"))
            )
        }
    }
}

suspend fun renderPage(code: HttpStatusCode?, call: ApplicationCall, cause: Throwable) {
    val map = mutableMapOf<String, Any>(
        "call" to call.request.uri, "error" to cause.javaClass.simpleName, "return_message" to (cause.message ?: "")
    )

    call.respond(code ?: HttpStatusCode.BadRequest, map)
}

