package moe.crx.roadblock.utils

import io.ktor.server.application.*
import io.ktor.server.plugins.*

fun ApplicationCall.realRemoteHost(): String =
    request.headers["X-Forwarded-For"]?.split(",")?.firstOrNull()?.trim() ?: request.headers["X-Real-IP"]
    ?: request.origin.remoteHost