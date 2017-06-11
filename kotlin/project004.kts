#!/usr/bin/env kscript

operator fun IntProgression.times(other: Int) = this.map { Triple(it, other, it * other) }
operator fun IntProgression.times(other: IntProgression) = this.flatMap { other * it }

fun String.isPalindrome() = this == reversed()
fun Int.isPalindrome() = toString().isPalindrome()

println("Largest palindrome from two three-digit numbers is: " + ((1000 downTo 100) * (1000 downTo 100))
        .filter { it.third.isPalindrome() }
        .maxBy { it.third }
        ?.let { "${it.first} * ${it.second} = ${it.third}" })