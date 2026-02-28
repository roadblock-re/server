package moe.crx.roadblock.core.routes

import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

var currentPlatformUserId = "" // TODO rework later

fun Route.authAuthorize() = post("/authorize") {
    val form = call.receiveParameters()
    val clientId = form["client_id"]
    val deviceId = form["device_id"]
    val scope = form["scope"]
    val password = form["password"]

    checkNotNull(clientId)
    checkNotNull(deviceId)
    checkNotNull(scope)
    checkNotNull(password)

    if (scope == "tracking_bi") {
        call.respondText("506746a9-0f5e-4827-9dfc-eb9ccbad8b81,tracking_bi,a9win:5797:84293:3.9.0j:windows:steam,1716976800.000000,anonymous:eW91YXJlamViYWl0ZWQ=,1234567890123456789,asa~gold|ffffffffffffffffffffffffffffffff")
        return@post
    }

    form["device_country"]
    form["device_firmware"]
    form["device_language"]
    form["device_model"]
    form["device_resolution"]

    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            {
                "access_token": "506746a9-0f5e-4827-9dfc-eb9ccbad8b81,auth chat config https_lobby leaderboard_ro lobby message social_ro storage_ro,a9win:5797:84293:3.9.0j:windows:steam,1716976800.000000,${currentPlatformUserId},1234567890123456789,asa~gold|ffffffffffffffffffffffffffffffff",
                "token_type": "gameloft_online",
                "fed_id": "506746a9-0f5e-4827-9dfc-eb9ccbad8b81",
                "scope": "auth chat config https_lobby leaderboard_ro lobby message social_ro storage_ro",
                "refresh_token": "refresh|506746a9-0f5e-4827-9dfc-eb9ccbad8b81,auth chat config https_lobby leaderboard_ro lobby message social_ro storage_ro,a9win:5797:84293:3.9.0j:windows:steam,1716976800.000000,${currentPlatformUserId},1234567890123456789,asa~gold|ffffffffffffffffffffffffffffffff"
            }
            """.trimIndent(),
    )
}

fun Route.authUsersAuthorize() = post("/users/{userId}/authorize") {
    //call.respondText(
    //    status = HttpStatusCode.Forbidden,
    //    contentType = ContentType.Application.Json,
    //    text = """
    //    {
    //        "error": "Target account is disabled",
    //        "reason": "{\"asset_name\":\"ban_tool_custom_messages\",\"text_id\":\"game_temp_ban_7_days\"}"
    //    }
    //""".trimIndent())
    //return@post

    val userId = call.parameters["userId"]

    checkNotNull(userId)

    currentPlatformUserId = userId

    val form = call.receiveParameters()
    val clientId = form["client_id"]
    form["device_country"]
    form["device_firmware"]
    form["device_id"]
    form["device_language"]
    form["device_model"]
    form["device_resolution"]
    // ALU uses device_information instead of separate fields
    form["device_information"]
    val scope = form["scope"]
    val password = form["password"]

    checkNotNull(clientId)
    checkNotNull(scope)
    checkNotNull(password)

    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            {
                "access_token": "506746a9-0f5e-4827-9dfc-eb9ccbad8b81,auth chat config https_lobby leaderboard_ro lobby message social_ro storage_ro,a9win:5797:84293:3.9.0j:windows:steam,1716976800.000000,${currentPlatformUserId},1234567890123456789,asa~gold|ffffffffffffffffffffffffffffffff",
                "token_type": "gameloft_online",
                "fed_id": "506746a9-0f5e-4827-9dfc-eb9ccbad8b81",
                "scope": "auth chat config https_lobby leaderboard_ro lobby message social_ro storage_ro",
                "refresh_token": "refresh|506746a9-0f5e-4827-9dfc-eb9ccbad8b81,auth chat config https_lobby leaderboard_ro lobby message social_ro storage_ro,a9win:5797:84293:3.9.0j:windows:steam,1716976800.000000,${currentPlatformUserId},1234567890123456789,asa~gold|ffffffffffffffffffffffffffffffff"
            }
            """.trimIndent(),
    )
}

fun Route.authUsersAuthorizeSpecific() = post("/users/{clientId}/{clientId2}/authorize") {
    val clientId = call.parameters["clientId"]
    val clientId2 = call.parameters["clientId2"]

    checkNotNull(clientId)
    checkNotNull(clientId2)

    val form = call.receiveParameters()
    val clientIdForm = form["client_id"]
    val deviceCountry = form["device_country"]
    val deviceFirmware = form["device_firmware"]
    val deviceId = form["device_id"]
    val deviceLanguage = form["device_language"]
    val deviceModel = form["device_model"]
    val deviceResolution = form["device_resolution"]
    val scope = form["scope"]
    val password = form["password"]

    checkNotNull(clientIdForm)
    checkNotNull(deviceCountry)
    checkNotNull(deviceFirmware)
    checkNotNull(deviceId)
    checkNotNull(deviceLanguage)
    checkNotNull(deviceModel)
    checkNotNull(deviceResolution)
    checkNotNull(scope)
    checkNotNull(password)

    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            {
                "access_token": "506746a9-0f5e-4827-9dfc-eb9ccbad8b81,auth chat config https_lobby leaderboard_ro lobby message social_ro storage_ro,a9win:5797:84293:3.9.0j:windows:steam,1716976800.000000,${currentPlatformUserId},1234567890123456789,asa~gold|ffffffffffffffffffffffffffffffff",
                "token_type": "gameloft_online",
                "fed_id": "506746a9-0f5e-4827-9dfc-eb9ccbad8b81",
                "scope": "auth chat config https_lobby leaderboard_ro lobby message social_ro storage_ro",
                "refresh_token": "refresh|506746a9-0f5e-4827-9dfc-eb9ccbad8b81,auth chat config https_lobby leaderboard_ro lobby message social_ro storage_ro,a9win:5797:84293:3.9.0j:windows:steam,1716976800.000000,${currentPlatformUserId},1234567890123456789,asa~gold|ffffffffffffffffffffffffffffffff"
            }
            """.trimIndent(),
    )
}

fun Route.authTokenEncrypt() = post("/token/encrypt") {
    val form = call.receiveParameters()
    val accessToken = form["access_token"]
    val nonce = form["nonce"]

    checkNotNull(accessToken)
    checkNotNull(nonce)

    call.respondText("eW91YXJlamViYWl0ZWR5b3VhcmVqZWJhaXRlZHlvdWFyZWplYmFpdGVkeW91YXJlamViYWl0ZWR5b3VhcmVqZWJhaXRlZHlvdWFyZWplYmFpdGVkeW91YXJlamViYWl0ZWR5b3VhcmVqZWJhaXRlZHlvdWFyZWplYmFpdGVkeW91YXJlamViYWl0ZWR5b3VhcmVqZWJhaXRlZHlvdWFyZWplYmFpdGVkeW91YXJlamViYWl0ZWR5b3VhcmVqZWJhaXRlZHlvdWFyZWplYmFpdGVkeW91YXJlamViYWl0ZWR5b3VhcmVqZWJhaXRlZHlvdWFyZWplYmFpdGVkeW91YXJlamViYWl0ZWR5b3VhcmVqZWJhaXRlZHlvdWFyZWplYmFpdGVkeW91YXJlamViYWl0ZWR5b3VhcmVqZWJhaXRlZHlvdWFyZWplYmFpdGVkeW91YXJlamViYWl0ZWR5b3VhcmVqZWJhaXRlZA==")
}

fun Route.authUsersMe() = get("/users/me") {
    // ALU provides token via Access-Token header
    //val accessToken = call.queryParameters["access_token"]
    //checkNotNull(accessToken)

    // IMPORTANT: Game crashes if Steam ID is wrong!

    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            {
                "account": "506746a9-0f5e-4827-9dfc-eb9ccbad8b81",
                "credentials": [
                    "${currentPlatformUserId}"
                ],
                "client_ids": [],
                "alias": [
                    "roadblock"
                ],
                "installations": [
                    {
                        "device_id": "1234567890123456789",
                        "carrier": null,
                        "model": "TESTING-PC",
                        "download_code": null,
                        "language": "en",
                        "country": "RU",
                        "resolution": null,
                        "firmware": "6.2.9200"
                    }
                ],
                "last_login": null,
                "is_ghost": false
            }
            """.trimIndent(),
    )
}
