package moe.crx.roadblock.rpc.base

enum class PacketDirection(val byteValue: Byte) {

    // TODO Separate client and server directions, move to game layer

    //From client to server:
    //LogInRequest, ResetStateRequest, ReconnectRequest, ActionRequest

    //From server to client:
    //LogInResult, ResetStateResult, ReconnectResult, ConcurrentAccessDetected, ServerError, ActionResult, PushMessage

    //For 24.1.0:
    //From ClientToServer:
    //    LogInRequest,
    //    ResetStateRequest,
    //    ReconnectRequest,
    //    ActionRequest,
    //    AlertControlRequest,
    //From ServerToClient:
    //    LogInResult,
    //    ResetStateResult,
    //    ReconnectResult,
    //    ConcurrentAccessDetected,
    //    ServerError,
    //    InactiveUserDetected,
    //    ClientVersionStatusChanged,
    //    ActionResult,
    //    Alert,
    //    AlertControlResult,
    //    PushMessage,

    //AlertControlRequest types:
    //    EnableStatusLineUpdatedAlertRequest = 0x0,
    //    DisableStatusLineUpdatedAlertRequest = 0x1,
    //    EmitStatusLineUpdatedAlertCheatRequest = 0x2,
    //    EnableSocialUserProfileUpdatedAlertRequest = 0x3,
    //    DisableSocialUserProfileUpdatedAlertRequest = 0x4,
    //    EmitSocialUserProfileUpdatedAlertCheatRequest = 0x5,
    //    EnableFriendRequestReceivedAlertRequest = 0x6,
    //    DisableFriendRequestReceivedAlertRequest = 0x7,
    //    EmitFriendRequestReceivedAlertCheatRequest = 0x8,
    //    EnableFriendRequestAcceptedAlertRequest = 0x9,
    //    DisableFriendRequestAcceptedAlertRequest = 0xa,
    //    EmitFriendRequestAcceptedAlertCheatRequest = 0xb,
    //    EnableFriendRequestRejectedAlertRequest = 0xc,
    //    DisableFriendRequestRejectedAlertRequest = 0xd,
    //    EmitFriendRequestRejectedAlertCheatRequest = 0xe,
    //    EnableFriendRequestCancelledAlertRequest = 0xf,
    //    DisableFriendRequestCancelledAlertRequest = 0x10,
    //    EmitFriendRequestCancelledAlertCheatRequest = 0x11,
    //    EnableFriendRequestIgnoredAlertRequest = 0x12,
    //    DisableFriendRequestIgnoredAlertRequest = 0x13,
    //    EmitFriendRequestIgnoredAlertCheatRequest = 0x14,
    //    EnableFriendRemovedAlertRequest = 0x15,
    //    DisableFriendRemovedAlertRequest = 0x16,
    //    EmitFriendRemovedAlertCheatRequest = 0x17,
    //    EnableOneWayConnectionAddedAlertRequest = 0x18,
    //    DisableOneWayConnectionAddedAlertRequest = 0x19,
    //    EmitOneWayConnectionAddedAlertCheatRequest = 0x1a,
    //    EnableOneWayConnectionDeletedAlertRequest = 0x1b,
    //    DisableOneWayConnectionDeletedAlertRequest = 0x1c,
    //    EmitOneWayConnectionDeletedAlertCheatRequest = 0x1d,
    //    EnablePartyInvitationAlertRequest = 0x1e,
    //    DisablePartyInvitationAlertRequest = 0x1f,
    //    EmitPartyInvitationAlertCheatRequest = 0x20,

    LOGIN(0),
    REQUEST(3),
    RESPONSE(7),
    PUSH(6),
}