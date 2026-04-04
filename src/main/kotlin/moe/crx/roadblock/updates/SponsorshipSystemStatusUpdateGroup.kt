package moe.crx.roadblock.updates

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.game.serialization.Variant
import moe.crx.roadblock.objects.SponsorshipContractId
import kotlin.reflect.KClass

@Serializable
sealed class SponsorshipSystemStatusUpdateGroup : StatusUpdateGroup() {
    companion object : Variant<SponsorshipSystemStatusUpdateGroup> {
        override fun variants(version: SerializationVersion): List<KClass<out SponsorshipSystemStatusUpdateGroup>> =
            buildList {
                add(SponsorshipSystemSponsorshipDailyLogin::class)
                add(SponsorshipSystemSponsorshipContractSelected::class)
                add(SponsorshipSystemSponsorshipContractClaimed::class)
                add(SponsorshipSystemSponsorshipContractWillBeFailed::class)
                add(SponsorshipSystemSponsorshipContractFailed::class)
                add(SponsorshipSystemDailyPackObtained::class)
            }
    }
}

@Serializable
data class SponsorshipSystemSponsorshipDailyLogin(
    var timestamp: Instant,
) : SponsorshipSystemStatusUpdateGroup()

@Serializable
data class SponsorshipSystemSponsorshipContractSelected(
    var contractId: SponsorshipContractId,
    var timestamp: Instant,
) : SponsorshipSystemStatusUpdateGroup()

@Serializable
data class SponsorshipSystemSponsorshipContractClaimed(
    var contractId: SponsorshipContractId,
) : SponsorshipSystemStatusUpdateGroup()

@Serializable
data class SponsorshipSystemSponsorshipContractWillBeFailed(
    var contractId: SponsorshipContractId,
) : SponsorshipSystemStatusUpdateGroup()

@Serializable
data class SponsorshipSystemSponsorshipContractFailed(
    var contractId: SponsorshipContractId,
) : SponsorshipSystemStatusUpdateGroup()

@Serializable
class SponsorshipSystemDailyPackObtained : SponsorshipSystemStatusUpdateGroup()