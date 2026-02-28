package moe.crx.roadblock.objects.party

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CarId
import moe.crx.roadblock.objects.settings.ControlSchemeType

@Serializable
data class PartyRacerData(
    var carId: CarId = 0u,
    var controlScheme: ControlSchemeType = ControlSchemeType.TouchScreenSmartDrive,
)