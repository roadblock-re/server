package moe.crx.roadblock.rpc.auth

import kotlinx.serialization.json.*
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.base.RObject

class ConnectGameRequest : RObject {

    var fedId: String = ""
    var roomId: String = ""

    override fun read(sink: InputSink) {
        val bytes = sink.readAllBytes()
        val jsonString = bytes.toString(Charsets.UTF_8)
        val json = Json.Default.parseToJsonElement(jsonString)

        fedId = json.jsonObject["fed_id"]?.jsonPrimitive?.contentOrNull.toString()
        roomId = json.jsonObject["room_id"]?.jsonPrimitive?.contentOrNull.toString()
    }

    override fun write(sink: OutputSink) {
        val json = buildJsonObject {
            put("fed_id", fedId)
            put("room_id", roomId)
        }

        sink.writeBytes(*"$json\n".toByteArray())
    }
}