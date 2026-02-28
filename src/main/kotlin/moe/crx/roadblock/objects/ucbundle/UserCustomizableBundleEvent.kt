package moe.crx.roadblock.objects.ucbundle

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.AsphaltProductID

@Serializable
data class UserCustomizableBundleEvent(
    var purchasedBundles: List<AsphaltProductID>,
    var expirationDate: Instant,
)