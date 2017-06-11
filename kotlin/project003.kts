#!/usr/bin/env kscript

fun sqrt(number: Int) = Math.ceil(Math.sqrt(number.toDouble())).toInt()
fun sqrt(number: Long) = Math.ceil(Math.sqrt(number.toDouble())).toInt()

// Sieve of Eratosthenes
fun primeNumbers(maxPrime: Int): IntArray {
    val numbers = BooleanArray(maxPrime + 1) { true }

    // Loop through all the primes, marking multiples of that prime as non-primes
    // As an optimization, we start at the prime squared, as all smaller multiples will have already been handled.
    for (i in 2..sqrt(maxPrime)) {
        if (numbers[i]) {
            var j = i * i
            while (j <= maxPrime) {
                numbers[j] = false
                j += i
            }
        }
    }

    // Get the numbers still marked as primes
    return numbers
            .mapIndexed { index, b -> Pair(index, b) }
            .filter { it.first > 1 && it.second }
            .map { it.first }
            .toIntArray()
}

// Calculate prime factors by finding all the prime numbers up to the square root of the number and testing if the
// number is divisible by the prime
fun primeFactors(number: Long) = primeNumbers(sqrt(number))
        .filter { number % it.toLong() == 0L }

println("Largest prime factor of 600851475143 is: " + primeFactors(600851475143).last())