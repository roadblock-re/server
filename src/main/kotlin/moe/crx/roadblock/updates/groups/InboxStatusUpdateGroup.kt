package moe.crx.roadblock.updates.groups

import moe.crx.roadblock.objects.base.RVariant
import moe.crx.roadblock.updates.inbox.InboxMessageRead
import moe.crx.roadblock.updates.inbox.InboxRemoveEvents

class InboxStatusUpdateGroup : RVariant(
    InboxMessageRead::class,
    InboxRemoveEvents::class,
)