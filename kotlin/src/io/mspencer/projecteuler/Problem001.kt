package io.mspencer.projecteuler

@ProjectEuler("Sum of multiples of 3 and 5 under 1000")
fun euler1() = (1 until 1000)
        .filter { it.isDivisibleBy(3) || it.isDivisibleBy(5) }
        .sum()