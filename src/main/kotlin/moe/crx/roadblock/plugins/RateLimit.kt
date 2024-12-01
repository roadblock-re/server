package moe.crx.roadblock.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.ratelimit.*
import kotlin.time.Duration.Companion.seconds

fun Application.configureLimits() {
    install(RateLimit) {
        register {
            rateLimiter(limit = Int.MAX_VALUE, refillPeriod = 60.seconds)
        }
    }
}