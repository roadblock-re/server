package moe.crx.roadblock

import ch.qos.logback.classic.Level
import org.fusesource.jansi.AnsiConsole
import org.slf4j.LoggerFactory

fun main() {
    LoggerFactory.getLogger("ROOT").let {
        it as ch.qos.logback.classic.Logger
    }.apply {
        level = Level.INFO
    }

    //IntelliJ IDEA workaround
    System.setProperty("jansi.passthrough", "true")
    AnsiConsole.systemInstall()

    httpServer().start(wait = false)
    webSocketServer().start(wait = false)
    tcpServer(wait = true)
}