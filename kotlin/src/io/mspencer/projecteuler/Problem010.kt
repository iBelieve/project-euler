package io.mspencer.projecteuler

val TWO_MILLION = 2000000

@SolvedProblem("Sum of all the primes below two million", "142913828922")
fun euler10() = primeNumbers()
        .takeWhile { it < TWO_MILLION }
        .sum()