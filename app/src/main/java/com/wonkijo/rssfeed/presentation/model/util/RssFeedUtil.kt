package com.wonkijo.rssfeed.presentation.model.util

fun getKeywords(description: String?): List<String> {
    if (description.isNullOrEmpty()) return listOf()

    val entries = description.split(" ")
        .filter { it.length >= 2 }
        .groupingBy { it }
        .eachCount()
        .entries

    val keys = entries.sortedWith(object : Comparator<Map.Entry<String, Int>> {
        override fun compare(o1: Map.Entry<String, Int>?, o2: Map.Entry<String, Int>?): Int {
            if (o1 == null || o2 == null) return 0
            if (o1.value > o2.value) {
                return -1
            } else if (o1.value < o2.value) {
                return 1
            } else {
                return o1.key.compareTo(o2.key)
            }
        }
    })
        .map { it.key }
        .take(3)

    return keys
}