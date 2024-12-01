package moe.crx.roadblock.objects.customization

import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.TRGBAColor

class CustomParts : RObject {

    var frontBumperId: Short = 0
    var licensePlateId: Short = 0
    var glassTint: TRGBAColor? = null
    var readBumperId: Short = 0
    var rimsId: Short = 0
    var roofId: Short = 0
    var sideSkirtsId: Short = 0
    var tiresId: Short = 0
    var wingId: Short = 0
    var useBaseColorForAeroKit: Byte = 0
    var tiresTint: TRGBAColor? = null
    var hoodId: Short = 0
    var trunkId: Short = 0
    var carbonHood: Byte = 0
    var carbonTrunk: Byte = 0
    var carbonWings: Byte = 0

    override fun read(sink: InputSink) {
        frontBumperId = sink.readShort()
        licensePlateId = sink.readShort()
        glassTint = sink.readOptional()
        readBumperId = sink.readShort()
        rimsId = sink.readShort()
        roofId = sink.readShort()
        sideSkirtsId = sink.readShort()
        tiresId = sink.readShort()
        wingId = sink.readShort()
        useBaseColorForAeroKit = sink.readByte()
        tiresTint = sink.readOptional()
        hoodId = sink.readShort()
        trunkId = sink.readShort()
        carbonHood = sink.readByte()
        carbonTrunk = sink.readByte()
        carbonWings = sink.readByte()
    }

    override fun write(sink: OutputSink) {
        sink.writeShort(frontBumperId)
        sink.writeShort(licensePlateId)
        sink.writeOptional(glassTint)
        sink.writeShort(readBumperId)
        sink.writeShort(rimsId)
        sink.writeShort(roofId)
        sink.writeShort(sideSkirtsId)
        sink.writeShort(tiresId)
        sink.writeShort(wingId)
        sink.writeByte(useBaseColorForAeroKit)
        sink.writeOptional(tiresTint)
        sink.writeShort(hoodId)
        sink.writeShort(trunkId)
        sink.writeByte(carbonHood)
        sink.writeByte(carbonTrunk)
        sink.writeByte(carbonWings)
    }
}