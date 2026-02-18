package moe.crx.roadblock.rpc.response

import moe.crx.roadblock.game.io.ListIO.readList
import moe.crx.roadblock.game.io.ListIO.writeList
import moe.crx.roadblock.game.sinks.InputSink
import moe.crx.roadblock.game.sinks.OutputSink
import moe.crx.roadblock.objects.social.UserCredentialInfo
import moe.crx.roadblock.rpc.base.UpdatesQueueWithRootReactionsResponse

class GetCredentialsForConsoleUsersResponse : UpdatesQueueWithRootReactionsResponse() {

    var existingCredentialsList: List<UserCredentialInfo> = listOf()

    override fun read(sink: InputSink) {
        super.read(sink)
        existingCredentialsList = sink.readList()
    }

    override fun write(sink: OutputSink) {
        super.write(sink)
        sink.writeList(existingCredentialsList)
    }
}