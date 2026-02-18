package moe.crx.roadblock.core.routes

import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

/* Possible responses: */

//{
//    "error": "AUTH:EXPIRED_CODE",
//    "error_description": "Wrong or expired code"
//}

//{
//    "error": "AUTH:INVALID_CREDENTIALS",
//    "error_description": "Invalid credentials"
//}

fun Route.glidAuthorize() = post("/authorize") {
    val bodyJson = Json.parseToJsonElement(call.receiveText()).jsonObject

    val redirectUri = bodyJson["redirect_uri"]?.jsonPrimitive?.contentOrNull ?: "https://localhost/"

    if (!bodyJson.contains("2fa_code")) {
        call.respondText(
            """
            {
                "result": "2FA_CODE_SENT"
            }
        """.trimIndent()
        )
        return@post
    }

    val authorizationCode = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"

    call.respondText(
        """
        {
            "id_token": "very_long_string_for_id_token",
            "authorization_code": "$authorizationCode",
            "expires": 2222222222,
            "state": "test",
            "redirect_uri": "https://$redirectUri/?code=$authorizationCode&state=test"
        }
    """.trimIndent()
    )
}

fun Route.glidUserInfo() = get("/userinfo") {
    //Bearer token

    call.respondText(
        """
        {
            "uuid": "bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb"
        }
    """.trimIndent()
    )
}