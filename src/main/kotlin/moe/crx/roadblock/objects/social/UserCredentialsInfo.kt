package moe.crx.roadblock.objects.social

import kotlinx.serialization.Serializable

@Serializable
data class UserCredentialsInfo(
    var fedId: Credentials,
    var credentials: List<Credentials>,
    var publicUserData: OnlineUserData?,
)