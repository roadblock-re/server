package moe.crx.roadblock.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.request.*
import org.slf4j.event.Level

fun Application.configureLogging() {
    install(CallLogging) {
        level = Level.INFO
        filter { call ->
            (call.response.status()?.isSuccess()?.not() ?: false) && (!call.request.path().contains("chat/rooms"))
        }
    }
}
