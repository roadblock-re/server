package moe.crx.roadblock.game.handlers

import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.game.GameRegion
import moe.crx.roadblock.objects.game.PingAddress
import moe.crx.roadblock.rpc.request.ListRegionsRequest
import moe.crx.roadblock.rpc.request.MiscellaneousResetAdsReplacementStateRequest
import moe.crx.roadblock.rpc.request.MiscellaneousUpdateProfileConsentRequest
import moe.crx.roadblock.rpc.request.ProcessOrphanTransactionsRequest
import moe.crx.roadblock.rpc.response.ListRegionsResponse
import moe.crx.roadblock.rpc.response.MiscellaneousResetAdsReplacementStateResponse
import moe.crx.roadblock.rpc.response.MiscellaneousUpdateProfileConsentResponse
import moe.crx.roadblock.rpc.response.ProcessOrphanTransactionsResponse

suspend fun handleMiscellaneousResetAdsReplacementState(
    session: GameConnection,
    request: MiscellaneousResetAdsReplacementStateRequest
) {
    session.send(MiscellaneousResetAdsReplacementStateResponse())
}

suspend fun handleListRegions(
    session: GameConnection,
    request: ListRegionsRequest
) {
    // TODO What is this ping address?
    session.send(ListRegionsResponse().apply {
        regions = listOf(
            GameRegion().apply {
                region = "default"
                pingAddresses = listOf(
                    PingAddress().apply {
                        host = "localhost"
                        port = 4449
                    }
                )
            }
        )
    })
}

suspend fun handleProcessOrphanTransactions(
    session: GameConnection,
    request: ProcessOrphanTransactionsRequest
) {
    session.send(ProcessOrphanTransactionsResponse())
}

suspend fun handleMiscellaneousUpdateProfileConsent(
    session: GameConnection,
    request: MiscellaneousUpdateProfileConsentRequest
) {
    session.send(MiscellaneousUpdateProfileConsentResponse())
}