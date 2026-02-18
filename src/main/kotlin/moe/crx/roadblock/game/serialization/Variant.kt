package moe.crx.roadblock.game.serialization

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.serializer
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance

interface Variant<T : Any> {
    fun variants(version: SerializationVersion): List<KClass<out T>>
}

private object NoVariant : Variant<Any> {
    override fun variants(version: SerializationVersion) = emptyList<KClass<out Any>>()
}

object VariantCompanionRegistry {
    private val cache = ConcurrentHashMap<KClass<*>, Variant<*>>()

    fun KClass<*>.getVariantCompanion(): Variant<*>? {
        val companion = cache.computeIfAbsent(this) {
            (it.objectInstance as? Variant<*>) ?: (it.companionObjectInstance as? Variant<*>) ?: NoVariant
        }

        return if (companion === NoVariant) null else companion
    }
}

class VersionedMapping(
    val classToIndex: Map<KClass<out Any>, Int>,
    val indexToSerializer: List<KSerializer<out Any>>,
)

object VersionedMappingRegistry {
    private val cache = ConcurrentHashMap<Pair<Variant<*>, SerializationVersion>, VersionedMapping>()

    @OptIn(InternalSerializationApi::class)
    fun Variant<*>.getMapping(version: SerializationVersion): VersionedMapping {
        return cache.computeIfAbsent(this to version) {
            val list = variants(version)

            VersionedMapping(
                classToIndex = list.withIndex().associate { it.value to it.index },
                indexToSerializer = list.map { it.serializer() }
            )
        }
    }
}