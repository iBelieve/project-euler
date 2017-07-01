package io.mspencer.projecteuler

fun pythagoreanTriplets(a: Iterable<Int>, b: Iterable<Int>) = combine(a, b)
        .map { (a, b) -> Triple(a, b, Math.sqrt((a * a + b * b).toDouble())) }
        .filterNot { it.third.hasFraction() }
        .map { (a, b, c) -> Triple(a, b, c.toInt()) }

@SolvedProblem("The Pythagorean triplet where a + b + c = 1000", "200 * 375 * 425 = 31875000")
fun euler9() = pythagoreanTriplets(1..1000, 1..1000)
        .find { (a, b, c) -> a + b + c == 1000 }
        ?.let { (a, b, c) -> "$a * $b * $c = ${a * b * c}" }