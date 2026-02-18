package moe.crx.roadblock.rpc.request

import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.rpc.base.RequestPacket

class MiscellaneousSetUserAgeAndGenderRequest : RequestPacket() {

    var age: Byte = 0
    var gender: Int = 0
    var deviceCountry: String = ""

    override fun read(sink: InputSink) {
        super.read(sink)
        age = sink.readByte()
        gender = sink.readInt()
        deviceCountry = sink.readString()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeByte(age)
        sink.writeInt(gender)
        sink.writeString(deviceCountry)
    }
}