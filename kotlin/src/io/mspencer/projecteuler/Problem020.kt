package io.mspencer.projecteuler

import java.math.BigInteger

fun factorial(value: BigInteger): BigInteger = if (value == BigInteger.ONE) {
    value
} else {
    value * factorial(value - BigInteger.ONE)
}

@SolvedProblem("Sum of the digits in the number 100!", "648")
fun euler20() = factorial(BigInteger("100")).sumOfDigits