package moe.crx.roadblock.rpc

import kotlinx.datetime.Clock.System.now
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.GameConnection
import moe.crx.roadblock.objects.Age
import moe.crx.roadblock.objects.miscellaneous.Gender
import moe.crx.roadblock.rpc.base.RequestPacket
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse
import moe.crx.roadblock.updates.MiscellaneousUnderageDisclaimerShownChanged
import moe.crx.roadblock.updates.MiscellaneousUserAgeAndGenderChanged

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
    val misc = session.gameState.miscellaneous
    val newUserAgeBase = now()

    val ageReaction = MiscellaneousUserAgeAndGenderChanged(
        oldUserAge = misc.userAge,
        newUserAge = request.age,
        oldUserGender = misc.userGender,
        newUserGender = request.gender,
        oldAgeBaseSecondsFromEpoch = misc.userAgeBaseTimePoint,
        newAgeBaseSecondsFromEpoch = newUserAgeBase,
    )

    val underageReaction = MiscellaneousUnderageDisclaimerShownChanged(
        oldShown = misc.underageDisclaimerShown,
        newShown = true,
    )

    session.gameState.miscellaneous.apply {
        userAge = request.age
        userGender = request.gender
        userAgeBaseTimePoint = newUserAgeBase
        underageDisclaimerShown = true
    }

    session.sendResponse(MiscellaneousSetUserAgeAndGenderResponse().flatten(ageReaction, underageReaction))
}