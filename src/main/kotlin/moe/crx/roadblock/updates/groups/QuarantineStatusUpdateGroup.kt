package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.quarantine.QuarantineEnterReasonChanged
import moe.crx.roadblock.updates.quarantine.QuarantineEntered
import moe.crx.roadblock.updates.quarantine.QuarantineEvidenceAdded
import moe.crx.roadblock.updates.quarantine.QuarantineExited

class QuarantineStatusUpdateGroup : RVariant(
    QuarantineEvidenceAdded::class,
    QuarantineEntered::class,
    QuarantineEnterReasonChanged::class,
    QuarantineExited::class,
)