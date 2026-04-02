package moe.crx.roadblock.core.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import moe.crx.roadblock.core.Configuration

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

fun Route.configDatacenterUrls(config: Configuration) = get("/{clientId}/datacenters/{datacenterId}/urls") {
    val clientId = call.parameters["clientId"]
    val datacenterId = call.parameters["datacenterId"]

    checkNotNull(clientId)
    checkNotNull(datacenterId)

    call.respondText(
        contentType = ContentType.Application.Json,
        text = """
            {
                    "ads_agency": "https://${config.eveDomain}/a314.gameloft.com/un/index.hhh",
                    "apple_iap": "https://${config.eveDomain}/iap.gameloft.com/partners/igcontents",
                    "china_regulation": "https://${config.eveDomain}/ecomapis.gameloft.com.cn",
                    "crm_iap": "https://${config.eveDomain}/iap-asa/inapp_crm/index.php",
                    "customer_care": "https://${config.eveDomain}/customercare.gameloft.com/asa",
                    "ecomm_api_root": "https://${config.eveDomain}/iap-asa",
                    "ets": "https://${config.eveDomain}/asa-ets-wsg.gameloft.com",
                    "etsv2": "https://${config.eveDomain}/etsv2",
                    "ets_gs": "https://${config.eveDomain}/asa-ets-wsg.gameloft.com/index_gs.php",
                    "federation": "https://${config.eveDomain}/federation",
                    "federation-internal": "https://${config.eveDomain}/federation-asa-int.gameloft.com",
                    "game_portal": "https://${config.eveDomain}/gameportal",
                    "gdid": "https://${config.eveDomain}/gdid",
                    "glid": "https://${config.eveDomain}/glid",
                    "gllive-asa": "https://${config.eveDomain}/gllive-asa.gameloft.com/ope",
                    "gllive-bdc": "https://${config.eveDomain}/gllive-bdc.gameloft.com/ope",
                    "gllive-ope": "https://${config.eveDomain}/gllive.gameloft.com/ope",
                    "livewebapp": "https://${config.eveDomain}/livewebapp.gameloft.com/glive",
                    "marketing_site": "https://${config.eveDomain}/marketing_site",
                    "master_federation": "https://${config.eveDomain}/federation-mfg.mdc.gameloft.org",
                    "offline_apple_iap": "https://${config.eveDomain}/confirmation.gameloft.com/partners/offline_ingame/item_list.php",
                    "offline_items": "https://${config.eveDomain}/confirmation.gameloft.com/partners/offline_ingame/item_list.php",
                    "online_connectivity": "https://${config.eveDomain}/oct",
                    "pandora": "https://${config.eveDomain}/pandora/$clientId",
                    "statetrackers": "https://${config.eveDomain}/state.gameloft.com",
                    "tapjoy": "https://${config.eveDomain}/gllive.gameloft.com/ope/tapjoy_log.php",
                    "gameloftid_abe_url": "https://${config.eveDomain}/api-backend.gameloftid.gameloft.com",
                    "glclub_web_url": "https://${config.eveDomain}/clubconnect/?",
                    "status": "none"
            }
        """.trimIndent(),
    )
}
