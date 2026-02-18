package moe.crx.roadblock.core.routes

import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Route.leaderboardRankings() = get("/leaderboards/{descOrAsc}/{leaderboardId}") {
    call.respondFile(File("stubs/rankings.json"))
}

fun Route.leaderboardRankingsMeLocation() = get("/leaderboards/{descOrAsc}/{leaderboardId}/me/location") {
    call.respondFile(File("stubs/rankings.json"))
}

fun Route.leaderboardRankingsMeClans() = get("/leaderboards/{descOrAsc}/{leaderboardId}/me/clans/{clanId}") {
    // leaderboardId may end with _clubRewards and _members
    call.respondFile(File("stubs/rankings.json"))
}

fun Route.leaderboardRankingsFedId() = get("/leaderboards/{descOrAsc}/{leaderboardId}/{fedId}") {
    call.respondFile(File("stubs/rankings.json"))
}