package moe.crx.roadblock.game

import kotlinx.datetime.*
import kotlinx.datetime.Clock.System.now
import moe.crx.roadblock.core.utils.bytes
import moe.crx.roadblock.core.utils.readFully
import moe.crx.roadblock.core.utils.sink
import moe.crx.roadblock.game.serialization.SerializationVersion
import moe.crx.roadblock.objects.base.RByte
import moe.crx.roadblock.objects.base.RInt
import moe.crx.roadblock.objects.base.RString
import moe.crx.roadblock.objects.blackmarket.BlackMarketFatigue
import moe.crx.roadblock.objects.blackmarket.BlackMarketItemVariant
import moe.crx.roadblock.objects.blackmarket.BlackMarketSlot
import moe.crx.roadblock.objects.career.CareerEventState
import moe.crx.roadblock.objects.career.CareerSeasonState
import moe.crx.roadblock.objects.customization.CarOfficialVisualOption
import moe.crx.roadblock.objects.dailytasks.DailyTask
import moe.crx.roadblock.objects.dailytasks.DailyTaskState
import moe.crx.roadblock.objects.game.*
import moe.crx.roadblock.objects.inventory.*
import moe.crx.roadblock.objects.item.*
import moe.crx.roadblock.objects.models.*
import moe.crx.roadblock.objects.settings.Localization
import moe.crx.roadblock.objects.settings.Vector2f
import java.io.File
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.time.Duration.Companion.days

class StateManager(workingDirectory: String) {

    // TODO Version-agnostic read/write system

    var stateFile = File(workingDirectory, "gamestate.saved")
    var lock: ReentrantLock = ReentrantLock()

    fun specificTime(hour: Int, minute: Int, addDays: Int = 0): Instant {
        val timeZone = TimeZone.currentSystemDefault()

        val date = now().plus(addDays.days).toLocalDateTime(timeZone).let {
            LocalDateTime(it.date, LocalTime(hour, minute))
        }

        return date.toInstant(timeZone)
    }

    fun read(ver: SerializationVersion): State {
        lock.withLock {
            runCatching {
                return stateFile.readBytes().sink(ver).readFully<State>()
            }

            return default(ver)
        }
    }

    // TODO Remove state argument, StateManager should store state
    fun write(state: State, ver: SerializationVersion) {
        lock.withLock {
            stateFile.writeBytes(state.bytes(ver))
        }
    }

    fun default(ver: SerializationVersion): State {
        return State().apply {
            blackMarket.apply {
                isLocked = true
                slots = buildList {
                    add(BlackMarketSlot().apply {
                        item = BlackMarketItemVariant().apply {
                            variant = UpgradeItem().apply {
                                variant = UncommonUpgradeItem().apply {
                                    partType = CarStatType.Handling
                                }
                            }
                        }
                        totalAmount = 5
                        remainingAmount = 5
                        currencyType = 0
                        basePrice = 25000
                        stepAmount = 13000
                        slotType = 0
                    })
                    add(BlackMarketSlot().apply {
                        item = BlackMarketItemVariant().apply {
                            variant = Blueprint().apply {
                                carId = 49
                            }
                        }
                        totalAmount = 5
                        remainingAmount = 5
                        currencyType = 1
                        basePrice = 65
                        stepAmount = 15
                        slotType = 1
                    })
                    add(BlackMarketSlot().apply {
                        item = BlackMarketItemVariant().apply {
                            variant = UpgradeItem().apply {
                                variant = RareUpgradeItem().apply {
                                    partType = CarStatType.Handling
                                    partClass = CarClass.C
                                }
                            }
                        }
                        totalAmount = 5
                        remainingAmount = 5
                        currencyType = 0
                        basePrice = 160000
                        stepAmount = 80000
                        slotType = 0
                    })
                    add(BlackMarketSlot().apply {
                        item = BlackMarketItemVariant().apply {
                            variant = Blueprint().apply {
                                carId = 103
                            }
                        }
                        totalAmount = 5
                        remainingAmount = 5
                        currencyType = 1
                        basePrice = 100
                        stepAmount = 10
                        slotType = 2
                    })
                    add(BlackMarketSlot().apply {
                        item = BlackMarketItemVariant().apply {
                            variant = Blueprint().apply {
                                carId = 26
                            }
                        }
                        totalAmount = 5
                        remainingAmount = 5
                        currencyType = 0
                        basePrice = 60000
                        stepAmount = 30000
                        slotType = 1
                    })
                    add(BlackMarketSlot().apply {
                        item = BlackMarketItemVariant().apply {
                            variant = UpgradeItem().apply {
                                variant = RareUpgradeItem().apply {
                                    partType = CarStatType.Nitro
                                    partClass = CarClass.C
                                }
                            }
                        }
                        totalAmount = 5
                        remainingAmount = 5
                        currencyType = 1
                        basePrice = 140
                        stepAmount = 14
                        slotType = 2
                    })
                    add(BlackMarketSlot().apply {
                        item = BlackMarketItemVariant().apply {
                            variant = Blueprint().apply {
                                carId = 102
                            }
                        }
                        totalAmount = 1
                        remainingAmount = 1
                        currencyType = 2
                        basePrice = 500
                        stepAmount = 50
                        slotType = 3
                    })
                    add(BlackMarketSlot().apply {
                        item = BlackMarketItemVariant().apply {
                            variant = UpgradeItem().apply {
                                variant = EpicUpgradeItem().apply {
                                    carId = 102
                                }
                            }
                        }
                        totalAmount = 1
                        remainingAmount = 1
                        currencyType = 2
                        basePrice = 6000
                        stepAmount = 600
                        slotType = 3
                    })
                }
                fatigueConsecutiveRefreshes = listOf()
                fatigueCooldownRefreshes = slots.map {
                    BlackMarketFatigue().apply {
                        item = it.item ?: BlackMarketItemVariant()
                        refreshes = 1
                    }
                }
                dailyRefreshes = 0
                nextDailyRefreshesResetTime = specificTime(0, 0, 1)
                nextAutoRefreshTime = specificTime(0, 0, 1)
            }

            career.apply {
                careerFlags = 0
                seasons = mapOf(RInt().apply { value = 79 } to CareerSeasonState().apply {
                    state = ProgressState.InProgress
                    flags = 0
                })
                events = mapOf(RInt().apply { value = 1028 } to CareerEventState().apply {
                    state = ProgressState.InProgress
                })
                chapters = mapOf()
            }

            gachaSystem.apply {
                isLocked = true
                nextRetentionBoxReadyTime = now()
                openedGachaBoxes = listOf()
                openedEventBoxes = mapOf()
            }

            inventory.apply {
                cars = buildMap {
                    put(RInt(0x25), CarState().apply { // Lancer
                        blueprints = 0
                        unlockedTiers = 1
                        unlockedLevels = 4
                        carTuning = CarTuningState().apply {
                            stats = buildList { repeat(4) { add(CarStat()) } } // Enumerated list?
                        }
                        epicItems = 0
                        freeUpgrades = buildList { repeat(4) { add(RInt()) } } // Enumerated list?
                        maintenance = CarMaintenanceStats().apply {
                            maintenanceSlots = 6
                        }
                        usageStats = CarUsageStats()
                        customization = CarCustomizationState().apply {
                            visualConfiguration.configuration = CarOfficialVisualOption()
                            lockedCustomization = false
                            lockedCalipers = true
                            lockedRims = true
                            lockedCarbonParts = true
                            lockedNeonTubes = true
                            lockedMaterialMetallic = true
                            lockedMaterialMatte = true
                            lockedDualTone = true
                            lockedMaterialMetallicRims = true
                            lockedMaterialMatteRims = true
                            lockedPaintJobs = true
                            lockedDecals = true
                            lockedTires = true
                            lockedBodyParts = true
                            lockedBodyPartsRoof = true
                            lockedBodyPartsWing = true
                            lockedBodyPartsSkirts = true
                            lockedBodyPartsSpoilerFront = true
                            lockedBodyPartsSpoilerRear = true
                            lockedTintedGlass = true
                            lockedLicensePlate = true
                            lockedBodyPartsHood = true
                            lockedBodyPartsTrunk = true
                        }
                        tierBlueprints = 0
                        ownedCustomParts = listOf()
                        isOwned = true
                        isCarKeyOwned = false
                        ownedDecalVisuals = listOf()
                        currentEvoTier = null
                        evoTierBlueprints = 0
                    })
                }
                wallets = listOf(
                    WalletState().apply {
                        currentType = 0
                        currentBalance = 15000
                    },
                    WalletState().apply {
                        currentType = 1
                        currentBalance = 50
                    },
                    WalletState().apply {
                        currentType = 2
                        currentBalance = 0
                    },
                    WalletState().apply {
                        currentType = 3
                        currentBalance = 0
                    },
                    WalletState().apply {
                        currentType = 4
                        currentBalance = 0
                    },
                    WalletState().apply {
                        currentType = 5
                        currentBalance = 0
                    },
                )
                iapWallets = mapOf()
                wildcardBlueprints = buildList {
                    repeat(5) {
                        add(WildcardBlueprintClassState())
                    }
                } // enumerated list
                wildcardUpgradeItems = buildList {
                    repeat(5) {
                        add(RInt())
                    }
                } // enumerated list
                upgrades = buildList {
                    repeat(4) {
                        add(StatUpgradeInfoState().apply {
                            classInfo = buildList {
                                repeat(5) {
                                    add(StatClassUpgradeInfoState())
                                }
                            } // enumerated list
                        })
                    }
                } // enumerated list
                lastActionTime = now()
                maintenanceBooking = null
                emojis = EmojisState()
            }

            miscellaneous.apply {
                username = "Driver"
                gameSettings.apply {
                    cameraType = "Close"
                    isImperialSpeedUnit = 0
                    enableKnockdowns = true
                    language = Localization().apply {
                        language = 25966
                        script = 757935405
                        region = 11565
                    }
                    region = 29301
                    controls.apply {
                        isTouchDriveDisabled = 0
                        touchControl.apply {
                            touchDriveSensitivity = 0.85f
                            tappingSensitivity = 0.5f
                            iconsScale = 1.0f
                            leftNitroOffset = Vector2f()
                            leftDriftOffset = Vector2f()
                            rightNitroOffset = Vector2f()
                            rightDriftOffset = Vector2f()
                            tiltingSensitivity = 0.5f
                            isHorizonTiltEnabled = true
                            isTiltSteeringEnabled = 1
                        }
                        isRumbleEnabled = true
                        gamepadControls = buildList {
                            //add(RGamepadControlSettings().apply {
                            //    gamepadId = 1298975476841628627 // ???
                            //    isAutoselectEnabled = 0
                            //    tiltingSensitivity = 0.5f
                            //    selectedLayout = 2
                            //    touchDriveSensitivity = 0.8f
                            //    manualSensitivity = 0.5f
                            //})
                        }
                        keyboardControl.apply {
                            isAutoselectEnabled = true
                            manualSensitivity = 0.5f
                            isKeyboardAzerty = 0
                        }
                        isAutoAccelerationEnabled = true
                        isManualAccelerationTutorialNeeded = false
                    }
                }
                regionChangeCount = 0
                userAge = 99
                userAgeTimeBase = now()
                userGender = Gender.Male
                alias = RString().apply { value = "roadblock" }
                deviceCountry = RString().apply { value = "US" }
                claimedEnableSystemNotificationsReward = false
                channelName = null
                privacyPolicy = RByte(3)
                underageDisclaimerShown = false
                platform = null
                xboxLiveOnlyEnabled = null
                uniqueUserNameChangeCount = RInt().apply { value = 1 }
                resetAdsReplacementTimepoint = specificTime(0, 0, 1)
            }

            multiplayerSeries.apply {
                series = mapOf()
                alreadyProcessedRaceTokenTransactions = listOf()
                isLocked = true
                mostRecentDisconnections = listOf()
            }

            playerStats.apply {
                reputationLevel = 1
                reputationPoints = 0
                garageLevel = 1
                missionState = buildList {
                    repeat(32) {
                        add(MissionState())
                    }
                }
                garageValue = 2860 // Lancer 1* garage value
                tutorialOrderTracking = listOf()
                menuTutorials =
                    buildList { repeat(MenuTutorialType.lastEntryFor(ver).ordinal + 1) { add(RInt(2)) } }
                gameplayTutorials =
                    buildList { repeat(GameplayTutorialType.lastEntryFor(ver).ordinal + 1) { add(RInt(2)) } }
                rewardForLevelUpClaimed = true
            }

            clubSystem = ClubSystemState().apply { isLocked = true }

            tlEventsSystem.apply {
                ticketBalance = 10
                lastTicketRefilledTime = now()
                events = mapOf()
                specialEvents = mapOf()
                isLocked = true
            }

            tracking = TrackingState()
            giftSystem = GiftSystemState()
            quarantine = QuarantineState()

            dailyTasks.apply {
                dailyTaskState = DailyTaskState().apply {
                    resetTime = specificTime(0, 0, 1)
                    completedTaskGoal = 2
                }
                dailyTasks = buildList {
                    repeat(10) {
                        add(DailyTask().apply {
                            isLocked = it != 1 && it != 2 // play any race and upgrade cars
                            isEnabled = true
                        })
                    }
                } // Enumerated list?
            }

            relayOfferSystem = RelayOfferSystemState()
            uberSystem = UberSystemState()
            championshipSystem = ChampionshipSystemState()
            seasonPassSystem = SeasonPassSystemState()
            multiplayerChallenges = MultiplayerChallengesState()
            inbox = InboxState()

            clubWarsSystem.apply {
                state.apply {
                    events = mapOf()
                    isLocked = true
                }
                market.apply {
                    nextAutoRefreshTime = specificTime(0, 0, 7)
                    isLocked = true
                }
            }

            privateLobby = PrivateLobbyState()
            bonusPassSystem = BonusPassSystemState()
            piggyBankSystem = PiggyBankSystemState()
            legendFundSystem = LegendFundSystemState()

            gauntletSystem = GauntletSystemState().apply {
                market.apply {
                    nextAutoRefreshTime = specificTime(0, 0, 7)
                }
            }
        }
    }
}