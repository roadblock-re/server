package moe.crx.roadblock.serialization

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.serializer
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance

interface VariantCompanion<T : Any> {
    fun variants(version: SerializationVersion): List<KClass<out T>>
}

private object NoCompanion : VariantCompanion<Any> {
    override fun variants(version: SerializationVersion) = emptyList<KClass<out Any>>()
}

object VariantCompanionRegistry {
    private val cache = ConcurrentHashMap<KClass<*>, VariantCompanion<*>>()

    fun KClass<*>.getVariantCompanion(): VariantCompanion<*>? {
        val companion = cache.computeIfAbsent(this) {
            (it.companionObjectInstance as? VariantCompanion<*>) ?: NoCompanion
        }

        return if (companion === NoCompanion) null else companion
    }
}

class VersionedMapping(
    val classToIndex: Map<KClass<out Any>, Int>,
    val indexToSerializer: List<KSerializer<out Any>>,
)

object VersionedMappingRegistry {
    private val cache = ConcurrentHashMap<Pair<VariantCompanion<*>, SerializationVersion>, VersionedMapping>()

    @OptIn(InternalSerializationApi::class)
    fun VariantCompanion<*>.getMapping(version: SerializationVersion): VersionedMapping {
        return cache.computeIfAbsent(this to version) {
            val list = variants(version)

            VersionedMapping(
                classToIndex = list.withIndex().associate { it.value to it.index },
                indexToSerializer = list.map { it.serializer() }
            )
        }
    }
}