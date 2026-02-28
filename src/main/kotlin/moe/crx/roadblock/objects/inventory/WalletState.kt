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
    @FromVersion("45.0.0")
    var balance: Money = 0,
    @UntilVersion("45.0.0")
    var legacyBalance: Money = balance,
    @UntilVersion("45.0.0")
    var legacyCurrency: CurrencyType = currency,
    @UntilVersion("24.6.0")
    var eventId: CalendarEventId? = null,
)