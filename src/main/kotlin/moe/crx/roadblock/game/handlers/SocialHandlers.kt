package moe.crx.roadblock.game.handlers

import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.request.PostLoginSocialUpdateRequest
import moe.crx.roadblock.rpc.response.PostLoginSocialUpdateResponse

suspend fun handlePostLoginSocialUpdate(session: GameConnection, request: PostLoginSocialUpdateRequest) {
    session.send(PostLoginSocialUpdateResponse())
}
