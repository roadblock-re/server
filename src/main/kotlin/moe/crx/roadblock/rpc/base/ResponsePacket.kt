package moe.crx.roadblock.rpc.base

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.game.Error

open class ResponsePacket() : Packet(PacketDirection.RESPONSE) {

    var responseSequence: Int = 0
    var previousRequestSequence: Int = 0
    var timestamp: Instant = now()
    var type: Byte = 0
    var error: Error? = null

    override fun read(sink: InputSink) {
        super.read(sink)
        responseSequence = sink.readInt()
        previousRequestSequence = sink.readInt()
        timestamp = sink.readInstant()
        type = sink.readByte()
        error = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeInt(responseSequence)
        sink.writeInt(previousRequestSequence)
        sink.writeInstant(timestamp)
        sink.writeByte(type)
        sink.writeOptional(error)
    }
}