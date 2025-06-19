package moe.crx.roadblock.objects.tle

import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.base.RVariant

class EventDataVariant : RVariant(
    RString::class, // CalendarEventId
    OsirisEventData::class,
)