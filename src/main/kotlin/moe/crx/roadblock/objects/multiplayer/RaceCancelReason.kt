package moe.crx.roadblock.objects.multiplayer

enum class RaceCancelReason {
    QuitFromPauseMenu,
    QuitFromSpectator,
    Disconnection,
    WifiNotAvailable,
    InternetNotAvailable,
    ApplicationInterruption,
    ApplicationShutdown,
}