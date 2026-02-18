package moe.crx.roadblock.core.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.lobbyRegions() = get("/lobby/regions") {
    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            {
                "regions": [
                    {
                        "controllers": [
                            {
                                "port": 46307,
                                "public_host": "eve.gameloft.com"
                            }
                        ],
                        "region": "europe"
                    },
                    {
                        "controllers": [
                            {
                                "port": 34689,
                                "public_host": "eve.gameloft.com"
                            }
                        ],
                        "region": "default"
                    },
                    {
                        "controllers": [
                            {
                                "port": 45359,
                                "public_host": "eve.gameloft.com"
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
