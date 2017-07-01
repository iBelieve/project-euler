package io.mspencer.projecteuler

fun Int.factors(existingFactors: Set<Int>): Map<Int, Int> {
    var remainder = this
    val newFactors = mutableMapOf<Int, Int>()

    for (f in existingFactors) {
        while (remainder % f == 0 && f != 1) {
            newFactors[f] = 1 + (newFactors[f] ?: 0)
            remainder /= f
        }
    }

    if (remainder > 0) {
        newFactors[remainder] = 1
    }

    return newFactors
}

fun smallestNumberDivisibleBy(numbers: IntArray): Int {
    val factors = mutableMapOf<Int, Int>()

    for (n in numbers) {
        val newFactors = n.factors(factors.keys)

        newFactors.forEach { factor, count ->
            factors[factor] = maxOf(factors[factor] ?: 0, count)
        }
    }

    return factors.map { it.key.pow(it.value) }.reduce { a, b -> a * b }
}

fun smallestNumberDivisibleBy(range: IntRange) = smallestNumberDivisibleBy(range.toList().toIntArray())

@SolvedProblem("Smallest number divisible by 1 through 20", "232792560")
fun euler5() = smallestNumberDivisibleBy(1..20)