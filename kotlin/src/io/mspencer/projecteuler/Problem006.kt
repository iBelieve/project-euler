package io.mspencer.projecteuler

fun sumOfSquares(iterable: Iterable<Int>) = iterable.map { it * it }.sum()
fun squareOfSum(iterable: Iterable<Int>) = iterable.sum().let { it * it }

@ProjectEuler("The difference between the sum of the squares of 1-100 and the square of the sum", "25164150")
fun euler6() = (1..100).let { squareOfSum(it) - sumOfSquares(it) }