package io.mspencer.projecteuler

fun Int.isEven() = isDivisibleBy(2)
fun Int.isDivisibleBy(factor: Int) = this % factor == 0
fun Int.pow(exp: Int) = (1..exp).map { this }.reduce { a, b -> a * b }
fun Int.sqrt() = Math.ceil(Math.sqrt(toDouble())).toInt()

fun Long.sqrt() = Math.ceil(Math.sqrt(toDouble())).toLong()

@Target(AnnotationTarget.FUNCTION)
annotation class ProjectEuler(val description: String, val answer: String = "")