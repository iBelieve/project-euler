package io.mspencer.projecteuler

val FOUR_MILLION = 4000000

fun fibonacci() = kotlin.coroutines.experimental.buildSequence {
    var terms = Pair(1, 2)

    while (true) {
        yield(terms.first)
        terms = Pair(terms.second, terms.first + terms.second)
    }
}

@SolvedProblem("Sum of even Fibonacci numbers up to four million", "4613732")
fun euler2() = fibonacci()
        .takeWhile { it <= FOUR_MILLION }
        .filter { it.isEven }
        .sum()