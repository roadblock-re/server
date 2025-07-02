package moe.crx.roadblock.routes

import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject

fun Route.gameportalMigrate() = post("/orchestrator/migrate") {
    // Contains form-data

    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            {
                "credential": "steam:12345678901234567",
                "fed_id": "506746a9-0f5e-4827-9dfc-eb9ccbad8b81",
                "status": "FULLY_MIGRATED",
                "started_at": "2024-05-29 10:00:00Z",
                "finished_at": "2024-05-29 10:00:00Z",
                "extra_info": null,
                "services": [
                    {
                        "status": "DONE",
                        "result": "SUCCESS",
                        "service_name": "AUTHORIZATION",
                        "is_required": true,
                        "started_at": "2024-05-29 10:00:00Z",
                        "finished_at": "2024-05-29 10:00:00Z",
                        "extra_parameters": null,
                        "composite_services": []
                    },
                    {
                        "status": "DONE",
                        "result": "SUCCESS",
                        "service_name": "USER_PROFILE",
                        "is_required": true,
                        "started_at": "2024-05-29 10:00:00Z",
                        "finished_at": "2024-05-29 10:00:00Z",
                        "extra_parameters": "{\"keys\":\"user_state.bin,vault_persistent_state\"}",
                        "composite_services": []
                    },
                    {
                        "status": "DONE",
                        "result": "SUCCESS",
                        "service_name": "SOCIAL_ACCOUNT",
                        "is_required": false,
                        "started_at": "2024-05-29 10:00:00Z",
                        "finished_at": "2024-05-29 10:00:00Z",
                        "extra_parameters": "{\"group_type\":\"all\"}",
                        "composite_services": [
                            {
                                "status": "DONE",
                                "result": "SUCCESS",
                                "service_name": "SOCIAL_GROUP",
                                "is_required": false,
                                "started_at": 1716976800000,
                                "finished_at": 1716976800000,
                                "extra_parameters": null,
                                "composite_services": []
                            }
                        ]
                    }
                ]
            }
        """.trimIndent()
    )
}

fun Route.gameportalAuthToken() = post("/auth/token/") {
    Json.parseToJsonElement(call.receiveText()).jsonObject

    call.respondText(
        """
        {
            "id_token": "very_long_string_for_id_token",
            "access_token": "even_very_very_longer_string_for_access_token",
            "expires_in": 3600,
            "token_type": "bearer",
            "scope": "openid",
            "refresh_token": "cccccccccccccccccccccccccccccccccccccccc"
        }
    """.trimIndent()
    )
}