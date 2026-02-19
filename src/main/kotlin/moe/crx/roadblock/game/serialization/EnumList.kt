package moe.crx.roadblock.game.serialization

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class EnumList<T, E : Enum<E>>(private val values: List<T>) {
    operator fun get(index: E): T? {
        return values.getOrNull(index.ordinal)
    }
}

inline fun <T, reified E : Enum<E>> enumListOf(until: E? = null, builder: (E) -> T): EnumList<T, E> {
    return EnumList(buildList {
        enumValues<E>().forEach {
            add(builder(it))
            if (it == until) return@buildList
        }
    })
}