package moe.crx.roadblock.objects.party

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.social.Credentials

@Serializable
data class UserData(
    var isOwner: Boolean,
    var federationId: Credentials,
    var anubisCredential: Credentials,
    var data: PartyClientUserData,
)