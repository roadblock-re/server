package moe.crx.roadblock.objects.inventory

import kotlinx.serialization.Serializable
import moe.crx.roadblock.game.serialization.FromVersion
import moe.crx.roadblock.game.serialization.UntilVersion
import moe.crx.roadblock.objects.CalendarEventId
import moe.crx.roadblock.objects.Money

@Serializable
data class WalletState(
    // TODO Verify that all versions has this balance/currency order.
    @FromVersion("45.0.0")
    var currency: CurrencyType = CurrencyType.Credits,
    var balance: Money = 0,
    @FromVersion("3.9.0") @UntilVersion("45.0.0")
    var legacyCurrency: CurrencyType = currency,
    @FromVersion("3.9.0") @UntilVersion("24.6.0")
    var eventId: CalendarEventId? = null,
)