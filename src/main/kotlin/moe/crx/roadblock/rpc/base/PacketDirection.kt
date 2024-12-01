package moe.crx.roadblock.rpc.base

enum class PacketDirection(val byteValue: Byte) {

    //From client to server:
    //LogInRequest, ResetStateRequest, ReconnectRequest, ActionRequest

    //From server to client:
    //LogInResult, ResetStateResult, ReconnectResult, ConcurrentAccessDetected, ServerError, ActionResult, PushMessage

    AUTHORIZATION(0),
    REQUEST(3),
    RESPONSE(5),
    SPECIAL(6),
}