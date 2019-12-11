package org.example

/* For more info on what an n-gram is, see https://en.wikipedia.org/wiki/N-gram
 *
 * This method should take in an input string with a gram size n and return all of the unique ngrams sorted by count in descending order
 *
 * Say your input was inputString = TESTTEST, gramSize = 2
 *
 * Output would look like: [TE:2, ES:2, ST:2, TT:1}
 *
 * Note that TE, ES, and ST all occurred the same number of times, so any arbitrary order is fine for those
 *
 */
data class Ngram(
    val gram: String,
    val count: Int
)

private fun processNgrams(input: String, gramSize: Int): List<Ngram> {
    val grams = mutableListOf<String>()

    for (i in 0..(input.length - gramSize)) {
        grams.add(input.substring(i, i + gramSize))
    }

    return grams
        .map { s -> Ngram(s, grams.count { n -> n == s }) }
        .toSet()
        .sortedByDescending { n -> n.count }
}

fun main(args: Array<String>) {
    println(
        processNgrams("TESTTEST", 2).joinToString(
            prefix = "[",
            postfix = "]",
            separator = ", "
        ) { n -> n.gram + ":" + n.count });
}

