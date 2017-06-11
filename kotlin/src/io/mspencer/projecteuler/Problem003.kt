package io.mspencer.projecteuler

// Sieve of Eratosthenes
fun primeNumbers(maxPrime: Int): IntArray {
    val numbers = BooleanArray(maxPrime + 1) { true }

    // Loop through all the primes, marking multiples of that prime as non-primes
    // As an optimization, we start at the prime squared, as all smaller multiples will have already been handled.
    for (i in 2..maxPrime.sqrt()) {
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

// Iterative (infinite) version of the Sieve of Eratosthenes
fun primeNumbers() = kotlin.coroutines.experimental.buildSequence {
    var number = 2
    val composites = mutableMapOf<Int, MutableList<Int>>()

    while (true) {
        if (number !in composites) {
            yield(number)
            composites[number * number] = mutableListOf(number)
        } else {
            for (prime in composites[number]!!) {
                composites.getOrPut(number + prime) { mutableListOf() } += prime
            }
            composites.remove(number)
        }

        number++
    }
}

// Calculate prime factors by finding all the prime numbers up to the square root of the number and testing if the
// number is divisible by the prime
fun primeFactors(number: Long) = primeNumbers()
        .takeWhile { it <= number.sqrt() }
        .filter { number % it.toLong() == 0L }

@ProjectEuler("Largest prime factor of 600851475143")
fun euler3() = primeFactors(600851475143).max()