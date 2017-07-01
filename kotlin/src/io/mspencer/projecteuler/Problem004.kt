package io.mspencer.projecteuler

operator fun IntProgression.times(other: Int) = this.map { it * other }
operator fun IntProgression.times(other: IntProgression) = this.flatMap { other * it }

fun String.isPalindrome() = this == reversed()
fun Int.isPalindrome() = toString().isPalindrome()

@SolvedProblem("Largest palindrome from two three-digit numbers", "906609")
fun euler4() = ((1000 downTo 100) * (1000 downTo 100))
        .filter { it.isPalindrome() }
        .max()