package moe.crx.roadblock.core

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

val json = Json {
    encodeDefaults = true
    ignoreUnknownKeys = true
    prettyPrint = true
    explicitNulls = true
    allowStructuredMapKeys = true
}

@Serializable
data class Configuration(
    val httpPort: Int = 80,
    val httpsPort: Int = 443,
    val wsPort: Int = 480,
    val wssPort: Int = 4443,
    val tcpPort: Int = 4447,
    val downloadResources: Boolean = true,
    val forceWebsocket: Boolean = true,
    val checkReceivedRequestSize: Boolean = false,
    val reportOctStatus: Boolean = true,
    val eveDomain: String = "eve.gameloft.com",
    val messageOfTheDay: String? = "Welcome to Roadblock!",
)

fun readConfig(workingDirectory: String): Configuration {
    try {
        val file = File(workingDirectory, "config.json")
        return json.decodeFromString(file.readText())
    } catch (_: Throwable) {
        return Configuration()
    }
}

fun Configuration.writeConfig(workingDirectory: String) {
    json.encodeToString(this).let {
        File(workingDirectory, "config.json").writeText(it)
    }
}