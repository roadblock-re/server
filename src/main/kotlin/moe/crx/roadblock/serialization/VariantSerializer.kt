package moe.crx.roadblock.serialization

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.modules.SerializersModuleBuilder
import kotlin.reflect.KClass

@OptIn(InternalSerializationApi::class, ExperimentalSerializationApi::class)
class VariantSerializer<T : Any>(
    baseClass: KClass<T>,
    private val variants: List<KClass<out T>>
) : KSerializer<T> {

    companion object {
        fun <T : Any> SerializersModuleBuilder.variant(
            base: KClass<T>,
            children: MutableList<KClass<out T>>.() -> Unit
        ) = contextual(base, VariantSerializer(base, buildList(children)))
    }

    private val serializers: List<KSerializer<out T>> = variants.map { it.serializer() }
    private val classToIndex: Map<KClass<out T>, Int> = variants.withIndex().associate { it.value to it.index }

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor(
        "Variant<${baseClass.simpleName}>"
    ) {
        element<Int>("typeIndex")
        element("payload", buildSerialDescriptor("VariantPayload", StructureKind.OBJECT))
    }

    override fun serialize(encoder: Encoder, value: T) {
        val index = classToIndex[value::class]
            ?: throw SerializationException("Class ${value::class} is not registered. Known variants: ${variants.map { it.simpleName }}")
        val strategy = serializers[index]

        encoder.encodeStructure(descriptor) {
            encodeIntElement(descriptor, 0, index)

            @Suppress("UNCHECKED_CAST")
            encodeSerializableElement(descriptor, 1, strategy as KSerializer<T>, value)
        }
    }

    override fun deserialize(decoder: Decoder): T = decoder.decodeStructure(descriptor) {
        if (decodeSequentially()) {
            val index = decodeIntElement(descriptor, 0)
            val strategy = serializers.getOrNull(index)
                ?: throw SerializationException("Unknown variant index: $index")

            @Suppress("UNCHECKED_CAST")
            return@decodeStructure decodeSerializableElement(descriptor, 1, strategy)
        }

        var index: Int? = null
        var value: Any? = null

        loop@ while (true) {
            when (val i = decodeElementIndex(descriptor)) {
                CompositeDecoder.DECODE_DONE -> {
                    break@loop
                }

                0 -> {
                    index = decodeIntElement(descriptor, i)
                }

                1 -> {
                    index = requireNotNull(index) { "Cannot read polymorphic value before its type token" }
                    val strategy = serializers.getOrNull(index)
                        ?: throw SerializationException("Unknown variant index: $index")

                    value = decodeSerializableElement(descriptor, i, strategy)
                }

                else -> throw SerializationException("Unexpected index: $i")
            }
        }

        @Suppress("UNCHECKED_CAST")
        requireNotNull(value) { "Polymorphic value has not been read" } as T
    }
}