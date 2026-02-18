package moe.crx.roadblock.updates.miscellaneous

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.game.io.EnumIO.readEnum
import moe.crx.roadblock.game.io.EnumIO.writeEnum
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Gender

class MiscellaneousUserAgeAndGenderChanged : RObject {

    var oldUserAge: Byte = 0
    var newUserAge: Byte = 0
    var oldUserGender: Gender = Gender.Unknown
    var newUserGender: Gender = Gender.Unknown
    var oldAgeBaseSecondsFromEpoch: Instant = now()
    var newAgeBaseSecondsFromEpoch: Instant = now()

    override fun read(sink: InputSink) {
        oldUserAge = sink.readByte()
        newUserAge = sink.readByte()
        oldUserGender = sink.readEnum()
        newUserGender = sink.readEnum()
        oldAgeBaseSecondsFromEpoch = sink.readInstant()
        newAgeBaseSecondsFromEpoch = sink.readInstant()
    }

    override fun write(sink: OutputSink) {
        sink.writeByte(oldUserAge)
        sink.writeByte(newUserAge)
        sink.writeEnum(oldUserGender)
        sink.writeEnum(newUserGender)
        sink.writeInstant(oldAgeBaseSecondsFromEpoch)
        sink.writeInstant(newAgeBaseSecondsFromEpoch)
    }
}