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
    val platform = call.queryParameters["platform"]
    val language = call.queryParameters["lang"]
    val gamespace = call.queryParameters["gamespace"]
    val fedId = call.queryParameters["fed_id"]
    val clientId = call.queryParameters["client_id"]
    val localTime = call.queryParameters["local_time"]
    val webviewSesId = call.queryParameters["webview_ses_id"]
    val firstLaunch = call.queryParameters["first_launch"]
    val gdid = call.queryParameters["gdid"]
    val hdidfv = call.queryParameters["hdidfv"]
    val consent = call.queryParameters["consent"]
    val sdkVersion = call.queryParameters["sdk_version"]

    // action = "authen"
    // rfToken idk
    // TODO idToken is JWT token
    val response = ClubConnectResponse("authen", "", "")
    val encoded = Json.encodeToString(response).toByteArray()
    val base64 = Base64.getEncoder().encodeToString(encoded)

    call.respondRedirect("exit://$base64")
}