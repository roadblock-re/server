package moe.crx.roadblock.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Route.socialMeRequests() = get("/accounts/me/requests") {
    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            []
            """.trimIndent(),
    )
}

fun Route.socialGroupsFindRecommended() = get("/groups/categories/{categoryId}/find/recommendation_score") {
    // TODO Fix recommended groups
    val categoryId = call.parameters["categoryId"]

    checkNotNull(categoryId)

    call.respondFile(File("stubs/recommendation_score.json"))
}

fun Route.socialGroupsFindKeyword() = get("/groups/categories/{categoryId}/find/keyword") {
    val categoryId = call.parameters["categoryId"]

    checkNotNull(categoryId)

    call.respondFile(File("stubs/recommendation_score.json"))
}

fun Route.socialMeRequestsSent() = get("/accounts/me/requests/sent") {
    call.respondText("[]", ContentType.Application.Json)
}

fun Route.socialGroups() = get("/groups/{groupId}") {
    call.respondFile(File("stubs/groupinfo.json"))
}

fun Route.socialGroupsMembers() = get("/groups/{groupId}/members") {
    // Behaves as get users info function, not a member list for current club
    // but does behave as expected for club info in search
    call.respondFile(File("stubs/members.json"))
}
