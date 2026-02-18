package moe.crx.roadblock.core.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.ratelimit.*
import io.ktor.server.routing.*
import moe.crx.roadblock.core.Configuration
import moe.crx.roadblock.core.routes.assetsGetAsset
import moe.crx.roadblock.core.routes.assetsGetAssetMetadata
import moe.crx.roadblock.core.routes.authAuthorize
import moe.crx.roadblock.core.routes.authTokenEncrypt
import moe.crx.roadblock.core.routes.authUsersAuthorize
import moe.crx.roadblock.core.routes.authUsersAuthorizeSpecific
import moe.crx.roadblock.core.routes.authUsersMe
import moe.crx.roadblock.core.routes.configDatacenterUrls
import moe.crx.roadblock.core.routes.configDatacenters
import moe.crx.roadblock.core.routes.etsV2Binary
import moe.crx.roadblock.core.routes.eveAbout
import moe.crx.roadblock.core.routes.gameportalAuthToken
import moe.crx.roadblock.core.routes.gameportalMigrate
import moe.crx.roadblock.core.routes.gdidAssignGlobalId
import moe.crx.roadblock.core.routes.glidAuthorize
import moe.crx.roadblock.core.routes.glidUserInfo
import moe.crx.roadblock.core.routes.groupChatListenChatGet
import moe.crx.roadblock.core.routes.groupChatListenChatPost
import moe.crx.roadblock.core.routes.groupChatRoomsSubscribe
import moe.crx.roadblock.core.routes.iapIndexGet
import moe.crx.roadblock.core.routes.iapIndexPost
import moe.crx.roadblock.core.routes.iapOrders
import moe.crx.roadblock.core.routes.leaderboardRankings
import moe.crx.roadblock.core.routes.leaderboardRankingsFedId
import moe.crx.roadblock.core.routes.leaderboardRankingsMeClans
import moe.crx.roadblock.core.routes.leaderboardRankingsMeLocation
import moe.crx.roadblock.core.routes.lobbyRegions
import moe.crx.roadblock.core.routes.marketingInGameNews
import moe.crx.roadblock.core.routes.marketingRedirUpdate
import moe.crx.roadblock.core.routes.matchmakerQuickLaunch
import moe.crx.roadblock.core.routes.messageMe
import moe.crx.roadblock.core.routes.octConnectionStatus
import moe.crx.roadblock.core.routes.pandoraLocate
import moe.crx.roadblock.core.routes.socialGroups
import moe.crx.roadblock.core.routes.socialGroupsFindKeyword
import moe.crx.roadblock.core.routes.socialGroupsFindRecommended
import moe.crx.roadblock.core.routes.socialGroupsMembers
import moe.crx.roadblock.core.routes.socialMeRequests
import moe.crx.roadblock.core.routes.socialMeRequestsSent

// TODO cleanup routes code and response data

fun Application.configureApiRouting(workingDirectory: String, config: Configuration) {
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
                gameportalAuthToken()
            }
            // Eve config -> federation
            route("/federation") {
                route("/v2") {
                    authUsersAuthorize()
                    authUsersMe()
                }
                route("/v1") {
                    socialMeRequests()
                    assetsGetAsset(workingDirectory, config)
                    assetsGetAssetMetadata(workingDirectory, config)
                    matchmakerQuickLaunch(config)
                    authTokenEncrypt()
                    messageMe()
                    //groupChatRoomsSubscribe() //FIXME
                }
            }
            // Pandora locate -> asset
            route("/asset") {
                assetsGetAsset(workingDirectory, config)
                assetsGetAssetMetadata(workingDirectory, config)
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
                matchmakerQuickLaunch(config)
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
            route("/glid") {
                glidAuthorize()
                glidUserInfo()
            }
        }
    }
}