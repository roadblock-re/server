package moe.crx.roadblock

import moe.crx.roadblock.core.httpServer
import moe.crx.roadblock.core.readConfig
import moe.crx.roadblock.core.tcpServer
import moe.crx.roadblock.core.webSocketServer
import moe.crx.roadblock.core.writeConfig
import org.fusesource.jansi.AnsiConsole
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
    //IntelliJ IDEA workaround
    System.setProperty("jansi.passthrough", "true")
    AnsiConsole.systemInstall()

    RoadblockServer.start(File("").absolutePath, true)
}
