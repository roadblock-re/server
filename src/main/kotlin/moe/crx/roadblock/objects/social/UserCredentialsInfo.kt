package moe.crx.roadblock.objects.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.account.Credentials
import moe.crx.roadblock.objects.account.OnlineUserData

@Serializable
data class UserCredentialsInfo(
    var fedId: Credentials,
    var credentials: List<Credentials>,
    var publicUserData: OnlineUserData?,
)