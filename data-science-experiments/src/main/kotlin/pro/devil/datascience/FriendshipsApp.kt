package pro.devil.datascience

val users = setOf<String>(
    "Hero",
    "Dunn",
    "Sue",
    "Chi",
    "Thor",
    "Clive",
    "Hicks",
    "Devin",
    "Kate",
    "Klein"
)

val relations = listOf<Pair<Int, Int>>(
    0 to 1,
    0 to 2,
    1 to 2,
    1 to 3,
    2 to 3,
    3 to 4,
    4 to 5,
    5 to 6,
    5 to 7,
    6 to 8,
    7 to 8,
    8 to 9
)

/**
 * Кол-во друзей одного пользователя
 */
fun MutableMap<Int, MutableList<Int>>.numberOfFriends(userId: Int) = this[userId]?.size ?: 0

fun main() {

    val relationsMap = users.withIndex().associate { it.index to mutableListOf<Int>() }.toMutableMap()

    relations.map {
        relationsMap[it.first]?.add(it.second)
        relationsMap[it.second]?.add(it.first)
    }


    users.forEachIndexed { i, v ->
        println("Пользователь $v имеет ${relationsMap.numberOfFriends(i)} друзей")
    }

    /**
     * Среднее число связей
     */

    val averageBinds = users.indices.map { relationsMap.numberOfFriends(it) }.sum() / users.size.toFloat()

    println("Среднее кол-во связей равно $averageBinds")

    /**
     * Наибольшее число друзей
     */

    // Сортируем по убыванию друзей (для этого преобразуем в список пар, сортируем пары, возвращаем в словарь
    val sortedRelations = relationsMap.toList().sortedBy { (_, v) -> -v.size }.toMap()

    println("Отсортировано по убыванию друзей $sortedRelations")
}