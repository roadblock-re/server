package moe.crx.roadblock.serialization

import kotlinx.datetime.Instant
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.encoding.AbstractDecoder
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeDecoder.Companion.DECODE_DONE
import kotlinx.serialization.internal.AbstractPolymorphicSerializer
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import java.io.InputStream
import kotlin.reflect.full.companionObjectInstance

@OptIn(ExperimentalSerializationApi::class)
class RoadblockDecoder(
    private val input: InputStream,
    private val version: SerializationVersion,
    override val serializersModule: SerializersModule = EmptySerializersModule(),
    private var elementsCount: Int = 0,
) : AbstractDecoder() {

    companion object {
        private val byteArrayDescriptor = EmptySerializersModule().serializer<ByteArray>().descriptor.serialName
        private val instantDescriptor = EmptySerializersModule().serializer<Instant>().descriptor.serialName
    }

    private var elementIndex = -1
    private var currentDescriptor: SerialDescriptor? = null

    override fun decodeElementIndex(descriptor: SerialDescriptor): Int {
        currentDescriptor = descriptor

        when (descriptor.kind) {
            StructureKind.CLASS -> {
                while (++elementIndex < elementsCount) {
                    val annotations = descriptor.getElementAnnotations(elementIndex)
                    if (annotations.isPresentIn(version)) return elementIndex
                }
            }

            StructureKind.LIST, StructureKind.MAP -> {
                if (++elementIndex < elementsCount) return elementIndex
            }

            else -> DECODE_DONE
        }

        return DECODE_DONE
    }

    @Suppress("UNCHECKED_CAST")
    @OptIn(InternalSerializationApi::class)
    override fun <T> decodeSerializableValue(deserializer: DeserializationStrategy<T>): T {
        if (deserializer.descriptor.kind == StructureKind.OBJECT) {
            throw SerializationException("Objects are not supported.")
        }

        if (!deserializer.descriptor.isNullable && deserializer is AbstractPolymorphicSerializer<*>) {
            val companion = deserializer.baseClass.companionObjectInstance as? VariantCompanion<*>
            companion?.let {
                return decodeVariant(it)
            }
        }

        return when (deserializer.descriptor.serialName) {
            byteArrayDescriptor -> decodeByteArray()
            instantDescriptor -> decodeInstant()
            else -> super.decodeSerializableValue(deserializer)
        } as T
    }

    @Suppress("UNCHECKED_CAST")
    @OptIn(InternalSerializationApi::class)
    fun <T : Any> decodeVariant(companion: VariantCompanion<*>): T {
        val variants = companion.variants(version)
        val index = decodeInt()
        val valueClass = variants[index]
        val serializer = valueClass.serializer() as KSerializer<T>
        return decodeSerializableValue(serializer)
    }

    fun decodeByteArray(): ByteArray {
        val size = decodeInt()
        return ByteArray(size).also { readBytesOrThrow(size, it) }
    }

    fun decodeInstant() = Instant.fromEpochSeconds(decodeLong(), 0)

    private fun readBytesOrThrow(count: Int, buffer: ByteArray = scratchBuffer) {
        var totalRead = 0
        while (totalRead < count) {
            val read = input.read(buffer, totalRead, count - totalRead)
            if (read == -1) throw SerializationException("Unexpected EOF")
            totalRead += read
        }
    }

    override fun decodeBoolean() = readBytesOrThrow(1).let { scratchBuffer[0] != 0.toByte() }
    override fun decodeByte() = readBytesOrThrow(1).let { scratchBuffer[0] }
    override fun decodeFloat() = Float.fromBits(decodeInt())
    override fun decodeDouble() = Double.fromBits(decodeLong())
    override fun decodeString() = decodeByteArray().toString(Charsets.UTF_8)

    override fun decodeEnum(enumDescriptor: SerialDescriptor): Int {
        val annotations = currentDescriptor?.getElementAnnotations(elementIndex)
        return if (annotations.byteEnum()) {
            decodeByte().toInt() and 0xFF
        } else {
            decodeInt()
        }
    }

    private val scratchBuffer = ByteArray(8)

    override fun decodeShort(): Short {
        readBytesOrThrow(2)
        val ch1 = (scratchBuffer[0].toInt() and 0xFF)
        val ch2 = (scratchBuffer[1].toInt() and 0xFF) shl 8
        return (ch1 or ch2).toShort()
    }

    override fun decodeInt(): Int {
        readBytesOrThrow(4)
        val ch1 = (scratchBuffer[0].toInt() and 0xFF)
        val ch2 = (scratchBuffer[1].toInt() and 0xFF) shl 8
        val ch3 = (scratchBuffer[2].toInt() and 0xFF) shl 16
        val ch4 = (scratchBuffer[3].toInt() and 0xFF) shl 24
        return ch1 or ch2 or ch3 or ch4
    }

    override fun decodeLong(): Long {
        readBytesOrThrow(8)
        val ch1 = (scratchBuffer[0].toLong() and 0xFF)
        val ch2 = (scratchBuffer[1].toLong() and 0xFF) shl 8
        val ch3 = (scratchBuffer[2].toLong() and 0xFF) shl 16
        val ch4 = (scratchBuffer[3].toLong() and 0xFF) shl 24
        val ch5 = (scratchBuffer[4].toLong() and 0xFF) shl 32
        val ch6 = (scratchBuffer[5].toLong() and 0xFF) shl 40
        val ch7 = (scratchBuffer[6].toLong() and 0xFF) shl 48
        val ch8 = (scratchBuffer[7].toLong() and 0xFF) shl 56
        return ch1 or ch2 or ch3 or ch4 or ch5 or ch6 or ch7 or ch8
    }

    override fun decodeNotNullMark() = decodeBoolean()
    override fun decodeNull() = null

    override fun decodeCollectionSize(descriptor: SerialDescriptor) =
        decodeInt()

    override fun beginStructure(descriptor: SerialDescriptor): CompositeDecoder {
        val count = when (descriptor.kind) {
            StructureKind.LIST -> {
                decodeCollectionSize(descriptor)
            }

            StructureKind.MAP -> {
                decodeCollectionSize(descriptor) * 2
            }

            else -> descriptor.elementsCount
        }

        return RoadblockDecoder(input, version, serializersModule, count)
    }
}