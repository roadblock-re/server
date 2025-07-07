package moe.crx.roadblock.rpc.response

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import moe.crx.roadblock.io.OptionalIO.readOptional
import moe.crx.roadblock.io.OptionalIO.writeOptional
import moe.crx.roadblock.io.sinks.InputSink
import moe.crx.roadblock.io.sinks.OutputSink
import moe.crx.roadblock.objects.social.SocialConnectionList
import moe.crx.roadblock.objects.social.SocialRequestList
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class PostLoginSocialUpdateResponse : UpdatesQueueWithRootReactionsResponse() {

    var friendsList: SocialConnectionList? = SocialConnectionList()
    var friendRequestsList: SocialRequestList? = SocialRequestList()
    var sentFriendRequestsList: SocialRequestList? = SocialRequestList()
    var blockedList: SocialConnectionList? = SocialConnectionList()
    var blockedByList: SocialConnectionList? = SocialConnectionList()
    var recentlyPlayedWithUsers: SocialConnectionList? = SocialConnectionList()
    var recentlyPlayedWithUsersTimepoint: Instant = now()
    var nextRefreshTime: Int = Int.MAX_VALUE
    var nextUpdateOnlineStatusTime: Int = Int.MAX_VALUE
    var minimumTimeBetweenPlatformUsersRefreshes: Int = Int.MAX_VALUE
    var requestSocialProfileCooldownTime: Int = Int.MAX_VALUE

    override fun read(sink: InputSink) {
        super.read(sink)
        friendsList = sink.readOptional()
        friendRequestsList = sink.readOptional()
        sentFriendRequestsList = sink.readOptional()
        blockedList = sink.readOptional()
        blockedByList = sink.readOptional()
        recentlyPlayedWithUsers = sink.readOptional()
        recentlyPlayedWithUsersTimepoint = sink.readInstant()
        nextRefreshTime = sink.readInt()
        nextUpdateOnlineStatusTime = sink.readInt()
        minimumTimeBetweenPlatformUsersRefreshes = sink.readInt()
        requestSocialProfileCooldownTime = sink.readInt()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeOptional(friendsList)
        sink.writeOptional(friendRequestsList)
        sink.writeOptional(sentFriendRequestsList)
        sink.writeOptional(blockedList)
        sink.writeOptional(blockedByList)
        sink.writeOptional(recentlyPlayedWithUsers)
        sink.writeInstant(recentlyPlayedWithUsersTimepoint)
        sink.writeInt(nextRefreshTime)
        sink.writeInt(nextUpdateOnlineStatusTime)
        sink.writeInt(minimumTimeBetweenPlatformUsersRefreshes)
        sink.writeInt(requestSocialProfileCooldownTime)
    }
}