package moe.crx.roadblock.routes

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import moe.crx.roadblock.utils.sha256
import java.io.File

val downloadResources = false

fun Route.assetsGetAsset() = get("/assets/{clientId}/{assetId}") {
    val clientId = call.parameters["clientId"]
    val assetId = call.parameters["assetId"]

    checkNotNull(clientId)
    checkNotNull(assetId)

    runCatching {
        if (!File("resources", assetId).exists() && !assetId.contains("GameOptions") && downloadResources) {
            val bytes = HttpClient(CIO) {
                followRedirects = true
            }.get("https://asa-iris.gameloft.com/assets/$clientId/$assetId").bodyAsBytes()
            File("resources", assetId).parentFile.mkdirs()
            File("resources", assetId).writeBytes(bytes)
        }
    }

    if (assetId.startsWith("PPMT_A9_IG_")) {
        call.respondFile(File("game/override_web_ad.zip"))
        return@get
    }

    if (File("resources", assetId).exists()) {
        call.respondFile(File("resources", assetId))
        return@get
    }

    call.respond(HttpStatusCode.NotFound)
}

fun Route.assetsGetAssetMetadata() = get("/assets/{clientId}/{assetId}/metadata") {
    val clientId = call.parameters["clientId"]
    val assetId = call.parameters["assetId"]

    checkNotNull(clientId)
    checkNotNull(assetId)

    runCatching {
        if (!File("resources", assetId).exists() && !assetId.contains("GameOptions") && downloadResources) {
            val bytes = HttpClient(CIO) {
                followRedirects = true
            }.get("https://asa-iris.gameloft.com/assets/$clientId/$assetId").bodyAsBytes()
            File("resources", assetId).parentFile.mkdirs()
            File("resources", assetId).writeBytes(bytes)
        }
    }

    if (assetId.startsWith("PPMT_A9_IG_")) {
        val bytes = File("game/override_web_ad.zip").readBytes()
        val hash = bytes.sha256()
        val size = bytes.size

        call.respondText(
            contentType = ContentType.Application.Json,
            text = "{\"hash\":\"$hash\",\"size\":$size}",
        )
        return@get
    }

    if (File("resources", assetId).exists()) {
        val bytes = File("resources", assetId).readBytes()
        val hash = bytes.sha256()
        val size = bytes.size

        call.respondText(
            contentType = ContentType.Application.Json,
            text = "{\"hash\":\"$hash\",\"size\":$size}",
        )
        return@get
    }

    call.respond(HttpStatusCode.NotFound)
}
