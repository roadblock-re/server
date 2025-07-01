package moe.crx.roadblock.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.ratelimit.*
import io.ktor.server.routing.*
import moe.crx.roadblock.routes.*

// TODO cleanup routes code and response data

fun Application.configureApiRouting() {
    routing {
        rateLimit {
            // Eve server
            eveAbout()
            octConnectionStatus()

            route("/config") {
                configDatacenterUrls()
                configDatacenters()
            }
            // ALU uses version prefixes
            route("/v1") {
                route("/config") {
                    configDatacenterUrls()
                    configDatacenters()
                }
            }
            // Eve config -> gdid
            route("/gdid") {
                gdidAssignGlobalId()
            }
            // Eve config -> online_connectivity
            route("/oct") {
                octConnectionStatus()
            }
            // Eve config -> pandora
            route("/pandora") {
                pandoraLocate()
            }
            // Eve config -> etsv2
            route("/etsv2") {
                etsV2Binary()
            }
            // Eve config -> marketing_site
            route("/marketing_site") {
                marketingInGameNews()
                marketingRedirUpdate()
            }
            // Eve config -> crm_iap, ecomm_api_root
            route("/iap-asa") {
                iapOrders()
                iapIndexGet()
                iapIndexPost()
            }
            // Eve config -> game_portal
            route("/gameportal") {
                gameportalMigrate()
            }
            // Eve config -> federation
            route("/federation") {
                route("/v2") {
                    authUsersAuthorize()
                    authUsersMe()
                }
                route("/v1") {
                    socialMeRequests()
                    assetsGetAsset()
                    assetsGetAssetMetadata()
                    matchmakerQuickLaunch()
                    authTokenEncrypt()
                    messageMe()
                    groupChatRoomsSubscribe()
                }
            }
            // Pandora locate -> asset
            route("/asset") {
                assetsGetAsset()
                assetsGetAssetMetadata()
            }
            // Pandora locate -> auth
            route("/auth") {
                authAuthorize()
                authUsersAuthorize()
                authUsersMe()

                // Android only
                authUsersAuthorizeSpecific()
                authTokenEncrypt()
            }
            // Pandora locate -> https_lobby
            route("/https_lobby") {
                lobbyRegions()
            }
            // Pandora locate -> matchmaker
            route("/matchmaker") {
                matchmakerQuickLaunch()
            }
            // Pandora locate -> message
            route("/message") {
                messageMe()
            }
            // Pandora locate -> social
            route("/social") {
                socialMeRequests()
                socialGroupsFindRecommended()
                socialGroupsFindKeyword()
                socialMeRequestsSent()
                socialGroups()
                socialGroupsMembers()
            }
            // Pandora locate -> groupchat
            route("/groupchat") {
                groupChatRoomsSubscribe()
                groupChatListenChatGet()
                groupChatListenChatPost()
            }
            // Pandora locate -> leaderboard
            route("/leaderboard") {
                leaderboardRankings()
                leaderboardRankingsMeLocation()
                leaderboardRankingsMeClans()
                leaderboardRankingsFedId()
            }
        }
    }
}