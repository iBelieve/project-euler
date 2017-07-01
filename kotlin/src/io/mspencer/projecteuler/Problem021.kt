package io.mspencer.projecteuler

fun d(number: Int) = number.divisors.sum()

val Int.isAmicable get() = d(this) != this && d(d(this)) == this

@SolvedProblem("Sum of all amicable numbers under 10000", "31626")
fun euler21() = numbers(2)
        .takeWhile { it < 10000 }
        .filter { it.isAmicable }
        .sum()