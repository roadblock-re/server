package moe.crx.roadblock.core.routes

import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.transactionsGifts() = post("/transactions/me/gifts") {
    // TODO
    val form = call.receiveParameters()
    println(form)
    call.respond("")
}

fun Route.transactionsGiftBundles() = post("/transactions/me/gift_bundles") {
    // TODO
    val form = call.receiveParameters()
    println(form)
    call.respond("")
}