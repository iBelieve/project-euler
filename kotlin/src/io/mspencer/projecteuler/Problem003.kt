package io.mspencer.projecteuler

// Calculate prime factors by finding all the prime numbers up to the square root of the number and testing if the
// number is divisible by the prime
fun primeFactors(number: Long) = primeNumbers()
        .takeWhile { it <= number.sqrt() }
        .filter { number % it == 0L }

@SolvedProblem("Largest prime factor of 600851475143", "6857")
fun euler3() = primeFactors(600851475143).max()