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
    var number = 2L
    val composites = mutableMapOf<Long, MutableList<Long>>()

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