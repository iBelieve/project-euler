package io.mspencer.projecteuler

import java.math.BigInteger

@SolvedProblem("Sum of the digits of the number 2^1000", "1366")
fun euler16() = BigInteger("2").pow(1000).sumOfDigits