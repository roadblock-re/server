package moe.crx.roadblock.objects.customization

import kotlinx.serialization.Serializable
import moe.crx.roadblock.objects.CarCustomPartId

@Serializable
data class CustomParts(
    var frontBumperId: CarCustomPartId,
    var licensePlateId: CarCustomPartId,
    var glassTint: TRGBAColor?,
    var readBumperId: CarCustomPartId,
    var rimsId: CarCustomPartId,
    var roofId: CarCustomPartId,
    var sideSkirtsId: CarCustomPartId,
    var tiresId: CarCustomPartId,
    var wingId: CarCustomPartId,
    var useBaseColorForAeroKit: Boolean,
    var tiresTint: TRGBAColor?,
    var hoodId: CarCustomPartId,
    var trunkId: CarCustomPartId,
    var carbonHood: Boolean,
    var carbonTrunk: Boolean,
    var carbonWings: Boolean,
)