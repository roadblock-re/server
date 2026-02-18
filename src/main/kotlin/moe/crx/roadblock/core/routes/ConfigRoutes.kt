package moe.crx.roadblock.core.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import moe.crx.roadblock.core.utils.realRemoteHost

fun Route.eveAbout() = get("/") {
    call.respondText(
        contentType = ContentType.Application.Json,
        text = "{\"eve\": \"on\", \"version\": \"3.9.59\"}",
    )
}

fun Route.configDatacenters() = get("/{clientId}/datacenters") {
    val clientId = call.parameters["clientId"]

    checkNotNull(clientId)

    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            [
                {
                    "name": "mdc",
                    "status": "active",
                    "preferred": true,
                    "country_code": "CA",
                    "_datacenter_id": "asa~gold"
                }
            ]
        """.trimIndent(),
    )
}

fun Route.configDatacenterUrls() = get("/{clientId}/datacenters/{datacenterId}/urls") {
    val clientId = call.parameters["clientId"]
    val datacenterId = call.parameters["datacenterId"]

    checkNotNull(clientId)
    checkNotNull(datacenterId)

    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            {
                    "ads_agency": "https://%1/a314.gameloft.com/un/index.hhh",
                    "apple_iap": "https://%1/iap.gameloft.com/partners/igcontents",
                    "china_regulation": "https://%1/ecomapis.gameloft.com.cn",
                    "crm_iap": "https://%1/iap-asa/inapp_crm/index.php",
                    "customer_care": "https://%1/customercare.gameloft.com/asa",
                    "ecomm_api_root": "https://%1/iap-asa",
                    "ets": "https://%1/asa-ets-wsg.gameloft.com",
                    "etsv2": "https://%1/etsv2",
                    "ets_gs": "https://%1/asa-ets-wsg.gameloft.com/index_gs.php",
                    "federation": "https://%1/federation",
                    "federation-internal": "https://%1/federation-asa-int.gameloft.com",
                    "game_portal": "https://%1/gameportal",
                    "gdid": "https://%1/gdid",
                    "glid": "https://%1/glid",
                    "gllive-asa": "https://%1/gllive-asa.gameloft.com/ope",
                    "gllive-bdc": "https://%1/gllive-bdc.gameloft.com/ope",
                    "gllive-ope": "https://%1/gllive.gameloft.com/ope",
                    "livewebapp": "https://%1/livewebapp.gameloft.com/glive",
                    "marketing_site": "https://%1/marketing_site",
                    "master_federation": "https://%1/federation-mfg.mdc.gameloft.org",
                    "offline_apple_iap": "https://%1/confirmation.gameloft.com/partners/offline_ingame/item_list.php",
                    "offline_items": "https://%1/confirmation.gameloft.com/partners/offline_ingame/item_list.php",
                    "online_connectivity": "https://%1/oct",
                    "pandora": "https://%1/pandora/%2",
                    "statetrackers": "https://%1/state.gameloft.com",
                    "tapjoy": "https://%1/gllive.gameloft.com/ope/tapjoy_log.php",
                    "gameloftid_abe_url": "https://%1/api-backend.gameloftid.gameloft.com",
                    "glclub_web_url": "https://%1/clubconnect.gameloft.com/?",
                    "status": "none"
            }
        """.trimIndent().replace("%1", call.realRemoteHost()).replace("%2", clientId),
    )
}
