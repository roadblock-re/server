package moe.crx.roadblock

import moe.crx.roadblock.core.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.util.*

private val logger: Logger = LoggerFactory.getLogger("roadblock")

object RoadblockServer {

    fun getCommitHash(): Pair<String, String> {
        return Thread.currentThread().contextClassLoader.getResourceAsStream("git.properties").use { stream ->
            Properties().let { props ->
                props.load(stream)
                props.getProperty("git.branch") to props.getProperty("git.commit.id.abbrev")
            }
        }
    }

    fun start(workingDirectory: String, wait: Boolean) {
        val (branch, hash) = getCommitHash()
        logger.info("Starting Roadblock server... (git branch $branch, hash $hash)")

        val config = readConfig(workingDirectory)
        config.writeConfig(workingDirectory)

        if (!config.forceWebsocket) {
            logger.warn("FORCED WEBSOCKET IS DISABLED. It is still not recommended because TCP implementation is rough.")
        }

        httpServer(workingDirectory, config).start(wait = false)
        webSocketServer(workingDirectory, config).start(wait = false)
        tcpServer(workingDirectory, config, wait)
    }
}

fun main() {
    RoadblockServer.start(File("").absolutePath, true)
}
