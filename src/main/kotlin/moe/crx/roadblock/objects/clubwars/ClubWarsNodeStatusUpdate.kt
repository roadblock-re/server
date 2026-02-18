package moe.crx.roadblock.objects.clubwars

import moe.crx.roadblock.game.io.ObjectIO.readObject
import moe.crx.roadblock.game.io.ObjectIO.writeObject
import moe.crx.roadblock.game.io.OptionalIO.readOptional
import moe.crx.roadblock.game.io.OptionalIO.writeOptional
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RBoolean
import moe.crx.roadblock.objects.base.RInstant
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RObject
import moe.crx.roadblock.objects.game.Credentials

class ClubWarsNodeStatusUpdate : RObject {

    var defenseMemberCredential: Credentials = Credentials()
    var defenseCar: ClubWarsCarStatusUpdate? = null
    var defenseRaceTime: RInt? = null
    var attackAttemptCount: RInt? = null
    var attackMemberCredential: Credentials? = null
    var attackRace: ClubWarsRaceStatusUpdate? = null
    var attackHelpingMemberCredential: Credentials? = null
    var isConquered: RBoolean? = null
    var attackLockMemberCredential: Credentials? = null
    var attackLockTimestamp: RInstant? = null

    override fun read(sink: InputSink) {
        defenseMemberCredential = sink.readObject()
        defenseCar = sink.readOptional()
        defenseRaceTime = sink.readOptional()
        attackAttemptCount = sink.readOptional()
        attackMemberCredential = sink.readOptional()
        attackRace = sink.readOptional()
        attackHelpingMemberCredential = sink.readOptional()
        isConquered = sink.readOptional()
        attackLockMemberCredential = sink.readOptional()
        attackLockTimestamp = sink.readOptional()
    }

    override fun write(sink: OutputSink) {
        sink.writeObject(defenseMemberCredential)
        sink.writeOptional(defenseCar)
        sink.writeOptional(defenseRaceTime)
        sink.writeOptional(attackAttemptCount)
        sink.writeOptional(attackMemberCredential)
        sink.writeOptional(attackRace)
        sink.writeOptional(attackHelpingMemberCredential)
        sink.writeOptional(isConquered)
        sink.writeOptional(attackLockMemberCredential)
        sink.writeOptional(attackLockTimestamp)
    }
}