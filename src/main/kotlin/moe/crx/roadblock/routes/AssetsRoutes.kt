package moe.crx.roadblock.routes

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import moe.crx.roadblock.Configuration
import moe.crx.roadblock.utils.sha256
import java.io.File

fun Route.assetsGetAsset(workingDirectory: String, config: Configuration) = get("/assets/{clientId}/{assetId}") {

    val clientId = call.parameters["clientId"]
    val assetId = call.parameters["assetId"]

    checkNotNull(clientId)
    checkNotNull(assetId)

    val assetFile = File(File(workingDirectory, "resources"), assetId)

    runCatching {
        if (config.downloadResources
            && !assetFile.exists()
            && !assetId.contains("GameOptions")) {
            val bytes = HttpClient(CIO) {
                followRedirects = true
            }.get("https://asa-iris.gameloft.com/assets/$clientId/$assetId").bodyAsBytes()
            assetFile.parentFile.mkdirs()
            assetFile.writeBytes(bytes)
        }
    }

    if (assetId.startsWith("PPMT_A9_IG_")) {
        call.respondFile(File(workingDirectory, "game/override_web_ad.zip"))
        return@get
    }

    if (assetFile.exists()) {
        call.respondFile(assetFile)
        return@get
    }

    call.respond(HttpStatusCode.NotFound)
}

fun Route.assetsGetAssetMetadata(workingDirectory: String, config: Configuration) = get("/assets/{clientId}/{assetId}/metadata") {
    val clientId = call.parameters["clientId"]
    val assetId = call.parameters["assetId"]

    checkNotNull(clientId)
    checkNotNull(assetId)

    val assetFile = File(File(workingDirectory, "resources"), assetId)

    runCatching {
        if (config.downloadResources
            && !assetFile.exists()
            && !assetId.contains("GameOptions")) {
            val bytes = HttpClient(CIO) {
                followRedirects = true
            }.get("https://asa-iris.gameloft.com/assets/$clientId/$assetId").bodyAsBytes()
            assetFile.parentFile.mkdirs()
            assetFile.writeBytes(bytes)
        }
    }

    if (assetId.startsWith("PPMT_A9_IG_")) {
        val bytes = File(workingDirectory, "game/override_web_ad.zip").readBytes()
        val hash = bytes.sha256()
        val size = bytes.size

        call.respondText(
            contentType = ContentType.Application.Json,
            text = "{\"hash\":\"$hash\",\"size\":$size}",
        )
        return@get
    }

    if (assetFile.exists()) {
        val bytes = assetFile.readBytes()
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
