package io.mspencer.projecteuler

import kotlin.coroutines.experimental.buildSequence

data class Month(val year: Int, val month: Int, val weekday: Int) {
    override fun toString() = "$year/$month: $weekday"
}

fun monthStartDays(startYear: Int = 0, startMonth: Int = 0) = buildSequence {
    var year = 1900
    var month = 0
    var weekday = 1

    while (true) {
        if (year >= startYear && month >= startMonth)
            yield(Month(year, month, weekday))

        val isLeapYear = if (year.isDivisibleBy(100)) {
            year.isDivisibleBy(400)
        } else {
            year.isDivisibleBy(4)
        }

        val daysInMonths = intArrayOf(31, if (isLeapYear) 29 else 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

        weekday = (weekday + daysInMonths[month]) % 7
        month++

        if (month >= 12) {
            month = 0
            year++
        }
    }
}

@SolvedProblem("Number of months starting with a Sunday during the twentieth century", "171")
fun euler19() = monthStartDays(1901, 0)
        .takeWhile { it.year < 2001 }
        .filter { it.weekday == 0 }
        .count()