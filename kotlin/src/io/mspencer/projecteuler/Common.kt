package io.mspencer.projecteuler

import java.math.BigInteger
import kotlin.coroutines.experimental.buildSequence

@Target(AnnotationTarget.FUNCTION)
annotation class UnsolvedProblem(val description: String)

@Target(AnnotationTarget.FUNCTION)
annotation class SolvedProblem(val description: String, val answer: String)


val Int.isEven get() = isDivisibleBy(2)
fun Int.isDivisibleBy(factor: Int) = this % factor == 0
fun Int.pow(exp: Int) = (1..exp).map { this }.reduce { a, b -> a * b }
fun Int.sqrt() = Math.ceil(Math.sqrt(toDouble())).toInt()
val Int.sumOfDigits get() = toString().map { it.toString().toInt() }.sum()
val Int.factors get() = (1..this.sqrt() + 1)
        .filter { this.isDivisibleBy(it) }
        .flatMap { listOf(it, this / it) }
        .toSet()
val Int.divisors get() = factors.filterNot { it == this }

val Long.isEven get() = isDivisibleBy(2)
fun Long.isDivisibleBy(factor: Long) = this % factor == 0L
fun Long.sqrt() = Math.ceil(Math.sqrt(toDouble())).toLong()
val Long.factors get() = (1..this.sqrt() + 1)
        .filter { this.isDivisibleBy(it) }
        .flatMap { listOf(it, this / it) }
        .toSet()

fun Double.hasFraction() = this != toLong().toDouble()

val BigInteger.sumOfDigits get() = toString().map { it.toString().toInt() }.sum()

fun <A, B> combine(a: Iterable<A>, b: Iterable<B>) = a.flatMap { itA -> b.map { Pair(itA, it) } }

fun numbers(start: Int = 1, step: Int = 1) = buildSequence {
    var number = start

    while (true) {
        yield(number)
        number += step
    }
}

fun readResource(name: String) = Triangle::class.java.getResource(name).readText()

fun <T> Sequence<T>.batch(n: Int): Sequence<List<T>> {
    return BatchingSequence(this, n)
}

private class BatchingSequence<T>(val source: Sequence<T>, val batchSize: Int) : Sequence<List<T>> {
    override fun iterator(): Iterator<List<T>> = object : AbstractIterator<List<T>>() {
        val iterate = if (batchSize > 0) source.iterator() else emptyList<T>().iterator()
        override fun computeNext() {
            if (iterate.hasNext()) setNext(iterate.asSequence().take(batchSize).toList())
            else done()
        }
    }
}