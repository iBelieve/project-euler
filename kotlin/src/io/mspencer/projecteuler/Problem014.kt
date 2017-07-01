package io.mspencer.projecteuler

import kotlin.coroutines.experimental.buildSequence

val ONE_MILLION = 1000000L

fun collatzSequence(start: Long) = buildSequence {
    var number = start
    yield(number)

    while (number != 1L) {
        number = if (number.isEven) {
            number / 2
        } else {
            3 * number + 1
        }

        yield(number)
    }
}

@SolvedProblem("Starting number under 1 million that produces the longest Collatz chain", "837799 (525)")
fun euler14() = (1 until ONE_MILLION).map { Pair(it, collatzSequence(it).count()) }
        .maxBy { it.second }!!
        .let { "${it.first} (${it.second})" }