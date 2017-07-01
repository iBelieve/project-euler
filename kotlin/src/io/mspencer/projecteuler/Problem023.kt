package io.mspencer.projecteuler

val Int.isAbundant get() = divisors.sum() > this

fun abundentNumbers() = numbers()