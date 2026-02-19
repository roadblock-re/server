package moe.crx.roadblock.objects.account

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class UserCustomizableBundleEvent(
    var purchasedBundles: List<AsphaltProductID>,
    var expirationDate: Instant,
)