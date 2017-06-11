#!/usr/bin/env kscript
import kotlin.coroutines.experimental.buildSequence

val FOUR_MILLION = 4000000

fun Int.isEven() = this % 2 == 0

fun fibonacci() = buildSequence {
    var terms = Pair(1, 2)

    while (true) {
        yield(terms.first)
        terms = Pair(terms.second, terms.first + terms.second)
    }
}

println("Sum of even Fibonacci numbers up to four million: " + fibonacci()
        .takeWhile { it <= FOUR_MILLION }
        .filter { it.isEven() }
        .sum())