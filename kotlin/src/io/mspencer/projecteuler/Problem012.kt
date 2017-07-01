package io.mspencer.projecteuler

import kotlin.coroutines.experimental.buildSequence

fun triangleNumbers() = buildSequence {
    var number = 1L
    var triangleNumber = number

    while (true) {
        yield(triangleNumber)
        triangleNumber += (++number)
    }
}

@SolvedProblem("The first triangle number to have over five hundred divisors", "76576500 (576 factors)")
fun euler12() = triangleNumbers()
        .first { it.factors.size > 500 }
        .let { "$it (${it.factors.size} factors)" }