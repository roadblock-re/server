package moe.crx.roadblock.core.routes

import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*

@Serializable
data class ClubConnectResponse(
    @SerialName("action")
    var action: String,
    @SerialName("rf_token")
    var rfToken: String,
    @SerialName("id_token")
    var idToken: String,
)

fun Route.clubConnect() = get("/clubconnect") {
    call.queryParameters["platform"]
    call.queryParameters["lang"]
    call.queryParameters["gamespace"]
    call.queryParameters["fed_id"]
    call.queryParameters["client_id"]
    call.queryParameters["local_time"]
    call.queryParameters["webview_ses_id"]
    call.queryParameters["first_launch"]
    call.queryParameters["gdid"]
    call.queryParameters["hdidfv"]
    call.queryParameters["consent"]
    call.queryParameters["sdk_version"]

    // action = "authen"
    // rfToken idk
    // TODO idToken is JWT token
    val response = ClubConnectResponse("authen", "", "")
    val encoded = Json.encodeToString(response).toByteArray()
    val base64 = Base64.getEncoder().encodeToString(encoded)

    call.respondRedirect("exit://$base64")
}