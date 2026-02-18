package moe.crx.roadblock.objects.game

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class LastEditorData : RObject {

    var credential: Credentials = Credentials()
    var allCredentials: PlatformCredentials? = null

    override fun read(sink: InputSink) {
        credential = sink.readObject()
        allCredentials = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(credential)
        sink.writeOptional(allCredentials)
    }
}