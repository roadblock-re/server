package moe.crx.roadblock.core.utils

import io.ktor.server.application.*
import io.ktor.server.plugins.*

// TODO you are a weirdo. we probably should nuke you.
fun ApplicationCall.realRemoteHost(): String =
    request.headers["X-Forwarded-For"]?.split(",")?.firstOrNull()?.trim() ?: request.headers["X-Real-IP"]
    ?: request.origin.remoteHost