package moe.crx.roadblock.objects.game

enum class GameplayTutorialType {
    TutorialRaceStart,
    TutorialRaceEnd,
    Drift,
    DriftLeft,
    DriftRight,
    DriftChargesNitro,
    Nitro,
    PerfectNitro,
    FlatSpin,
    FlatSpin2,
    Shockwave,
    Shockwave2,
    SmartDriveSwipeLeft,
    SmartDriveSwipeRight,
    SmartDriveNoNeedToSteer,
    Steering,
    SteeringLeft,
    SteeringRight,
    Accelerate,
    Brake,
    ManualNeedToAccelerate,
    AutoAccelerate;

    companion object {
        fun lastEntryFor(ver: SerializationVersion): GameplayTutorialType {
            return if (ver newer "24.0.0") {
                AutoAccelerate
            } else {
                Accelerate
            }
        }
    }
}