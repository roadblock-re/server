package moe.crx.roadblock.rpc.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.account.Age
import moe.crx.roadblock.objects.account.Gender
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

@Serializable
data class MiscellaneousSetUserAgeAndGenderRequest(
    var age: Age,
    var gender: Gender,
    var deviceCountry: String,
) : RequestPacket()

@Serializable
class MiscellaneousSetUserAgeAndGenderResponse : UpdatesQueueWithRootReactionsResponse()

suspend fun handleMiscellaneousSetUserAgeAndGender(
    session: GameConnection,
    request: MiscellaneousSetUserAgeAndGenderRequest
) {
    session.sendResponse(MiscellaneousSetUserAgeAndGenderResponse())
}