package moe.crx.roadblock.io.sinks

import moe.crx.roadblock.serialization.SerializationVersion
import java.io.InputStream

class InputStreamSink(val input: InputStream, ver: SerializationVersion) : InputSink(ver) {

    override fun readBytes(n: Int): ByteArray {
        return input.readNBytes(n).let {
            check(it.size == n) {
                "Reached end of stream, expected size is $n bytes, actual size is ${it.size} bytes"
            }
            it
        }
    }

    override fun available(): Int {
        return input.available()
    }
}