package moe.crx.roadblock.game.serialization

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
import moe.crx.roadblock.game.serialization.VariantCompanionRegistry.getVariantCompanion
import moe.crx.roadblock.game.serialization.VersionedMappingRegistry.getMapping
import java.io.InputStream

@OptIn(ExperimentalSerializationApi::class)
class RoadblockDecoder(
    private val input: InputStream,
    private val version: SerializationVersion,
    override val serializersModule: SerializersModule = EmptySerializersModule(),
    private val instantSerialName: String = serializersModule.serializer<Instant>().descriptor.serialName,
    private val byteArraySerialName: String = serializersModule.serializer<ByteArray>().descriptor.serialName,
    private val scratchBuffer: ByteArray = ByteArray(8),
    private var elementsCount: Int = 0,
    private val elementAnnotations: List<Annotation>? = null,
) : AbstractDecoder() {

    private fun readBytesOrThrow(count: Int, buffer: ByteArray = scratchBuffer) {
        check(count <= buffer.size) { "Bytes count can't be bigger than buffer size." }
        var totalRead = 0
        while (totalRead < count) {
            val read = input.read(buffer, totalRead, count - totalRead)
            if (read == -1) throw SerializationException("Unexpected EOF")
            totalRead += read
        }
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

    override fun <T> decodeSerializableValue(deserializer: DeserializationStrategy<T>) =
        decodeSerializableValueInternal(deserializer, false)

    @Suppress("UNCHECKED_CAST")
    @OptIn(InternalSerializationApi::class)
    private fun <T> decodeSerializableValueInternal(
        deserializer: DeserializationStrategy<T>,
        ignoreVariantAnnotation: Boolean,
    ): T {
        if (deserializer.descriptor.isNullable) {
            return super.decodeSerializableValue(deserializer)
        }

        if (deserializer.descriptor.serialName == instantSerialName) {
            return decodeInstant() as T
        }

        if (deserializer.descriptor.serialName == byteArraySerialName) {
            return decodeByteArray() as T
        }

        val annotationVariant = if (ignoreVariantAnnotation) null else {
            currentDescriptor?.getElementAnnotations(elementIndex).getVariantCompanion()
                ?: elementAnnotations.getVariantCompanion()
        }

        annotationVariant?.let {
            check(deserializer.descriptor.kind != StructureKind.MAP) { "@VariantOf is not allowed on Map structures." }
        }

        val baseVariant = (deserializer as? AbstractPolymorphicSerializer<*>)?.baseClass?.getVariantCompanion()

        (annotationVariant ?: baseVariant)?.let {
            return decodeVariant(it)
        }

        return super.decodeSerializableValue(deserializer)
    }

    @Suppress("UNCHECKED_CAST")
    @OptIn(InternalSerializationApi::class)
    fun <T : Any> decodeVariant(companion: Variant<*>): T {
        val mapping = companion.getMapping(version)
        val index = decodeInt()

        if (index !in mapping.indexToSerializer.indices) {
            throw SerializationException("Invalid variant index $index for version $version")
        }

        val serializer = mapping.indexToSerializer[index] as KSerializer<T>
        return decodeSerializableValueInternal(serializer, true)
    }

    fun decodeByteArray(): ByteArray {
        val size = decodeInt()
        return ByteArray(size).also { readBytesOrThrow(size, it) }
    }

    fun decodeInstant() = Instant.fromEpochSeconds(decodeLong(), 0)

    override fun decodeBoolean() = decodeByte() != 0.toByte()
    override fun decodeFloat() = Float.fromBits(decodeInt())
    override fun decodeDouble() = Double.fromBits(decodeLong())
    override fun decodeString() = decodeByteArray().toString(Charsets.UTF_8)

    override fun decodeEnum(enumDescriptor: SerialDescriptor): Int {
        return if (
            enumDescriptor.annotations.isByteEnum()
            || elementAnnotations.isByteEnum()
            || currentDescriptor?.getElementAnnotations(elementIndex).isByteEnum()
        ) {
            decodeByte().toInt() and 0xFF
        } else {
            decodeInt()
        }
    }

    override fun decodeByte(): Byte {
        readBytesOrThrow(1)
        val ch1 = scratchBuffer[0]
        return ch1
    }

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
        val elementAnnotations = currentDescriptor?.getElementAnnotations(elementIndex)

        val elementsCount = when (descriptor.kind) {
            StructureKind.LIST -> decodeCollectionSize(descriptor)
            StructureKind.MAP -> decodeCollectionSize(descriptor) * 2
            else -> descriptor.elementsCount
        }

        return RoadblockDecoder(
            input,
            version,
            serializersModule,
            instantSerialName,
            byteArraySerialName,
            scratchBuffer,
            elementsCount,
            elementAnnotations,
        )
    }
}