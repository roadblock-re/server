package moe.crx.roadblock.game.handlers

import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.rpc.request.ConfirmLinkingOperationRequest
import moe.crx.roadblock.rpc.request.GetCredentialsForConsoleUsersRequest
import moe.crx.roadblock.rpc.request.LinkAccountWithCredentialRequest
import moe.crx.roadblock.rpc.request.PostLoginSocialUpdateRequest
import moe.crx.roadblock.rpc.response.ConfirmLinkingOperationResponse
import moe.crx.roadblock.rpc.response.GetCredentialsForConsoleUsersResponse
import moe.crx.roadblock.rpc.response.LinkAccountWithCredentialResponse
import moe.crx.roadblock.rpc.response.PostLoginSocialUpdateResponse

suspend fun handlePostLoginSocialUpdate(session: GameConnection, request: PostLoginSocialUpdateRequest) {
    session.send(PostLoginSocialUpdateResponse())
}

suspend fun handleGetCredentialsForConsoleUsers(
    session: GameConnection,
    request: GetCredentialsForConsoleUsersRequest
) {
    session.send(GetCredentialsForConsoleUsersResponse())
}

suspend fun handleLinkAccountWithCredential(
    session: GameConnection,
    request: LinkAccountWithCredentialRequest
) {
    session.send(LinkAccountWithCredentialResponse())
}

suspend fun handleConfirmLinkingOperation(
    session: GameConnection,
    request: ConfirmLinkingOperationRequest
) {
    session.send(ConfirmLinkingOperationResponse())
}