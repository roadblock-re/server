package moe.crx.roadblock.updates.quarantine

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.QuarantineEvidence

class QuarantineEvidenceAdded : RObject {

    var evidence: QuarantineEvidence = QuarantineEvidence()
    var weight: Float = 0.0f

    override fun read(sink: InputSink) {
        evidence = sink.readObject()
        weight = sink.readFloat()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(evidence)
        sink.writeFloat(weight)
    }
}