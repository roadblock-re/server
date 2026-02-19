package moe.crx.roadblock

import moe.crx.roadblock.core.*
import java.io.File

object RoadblockServer {
    fun start(workingDirectory: String, wait: Boolean) {
        val config = readConfig(workingDirectory)
        config.writeConfig(workingDirectory)
        httpServer(workingDirectory, config).start(wait = false)
        webSocketServer(workingDirectory, config).start(wait = false)
        tcpServer(workingDirectory, config, wait)
    }
}

fun main() {
    RoadblockServer.start(File("").absolutePath, true)
}
