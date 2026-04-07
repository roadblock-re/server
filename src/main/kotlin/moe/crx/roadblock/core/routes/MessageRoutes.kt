package moe.crx.roadblock.core.routes

import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import moe.crx.roadblock.core.Configuration

// TODO reverse it more
@Serializable
data class GiftMessageBody(
    var gifts: List<String>,
    var message: String,
)

@Serializable
data class GiftMessage(
    var type: String = "gift",
    var body: String,
    @SerialName("gift_type")
    var giftType: String = "dynamic_gift",
    var id: String = "motd_gift_id"
)

fun Route.messageMe(config: Configuration) = get("/messages/secured/me") {
    val messages: MutableList<GiftMessage> = mutableListOf()

    if (config.messageOfTheDay != null) {
        messages += GiftMessage(
            body = Json.encodeToString(
                GiftMessageBody(
                    gifts = listOf(),
                    message = config.messageOfTheDay
                )
            )
        )
    }

    call.respond(messages)
}
