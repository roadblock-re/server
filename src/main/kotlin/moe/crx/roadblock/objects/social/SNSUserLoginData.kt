package moe.crx.roadblock.objects.social

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.account.CredentialAuthority

@Serializable
data class SNSUserLoginData(
    @UntilVersion("24.0.0")
    var authority: CredentialAuthority = CredentialAuthority.Uninitialized,
    var username: String,
)