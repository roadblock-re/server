package moe.crx.roadblock.core.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import moe.crx.roadblock.core.Configuration

fun Route.lobbyRegions(config: Configuration) = get("/lobby/regions") {
    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            {
                "regions": [
                    {
                        "controllers": [
                            {
                                "port": 46307,
                                "public_host": "${config.eveDomain}"
                            }
                        ],
                        "region": "europe"
                    },
                    {
                        "controllers": [
                            {
                                "port": 34689,
                                "public_host": "${config.eveDomain}"
                            }
                        ],
                        "region": "default"
                    },
                    {
                        "controllers": [
                            {
                                "port": 45359,
                                "public_host": "${config.eveDomain}"
                            }
                        ],
                        "region": "north_asia"
                    }
                ],
                "matched_region": "russia"
            }
            """.trimIndent(),
    )
}
