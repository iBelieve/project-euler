package io.mspencer.projecteuler

val onesWords = listOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
        "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
val tensWords = listOf("", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

fun Int.toWord(): String {
    if (this >= 1000) {
        val thousands = this / 1000
        val remainder = this % 1000

        if (remainder > 0) {
            return "${thousands.toWord()} thousand ${remainder.toWord()}"
        } else {
            return "${thousands.toWord()} thousand"
        }
    } else if (this >= 100) {
        val hundreds = this / 100
        val remainder = this % 100

        if (remainder > 0) {
            return "${hundreds.toWord()} hundred and ${remainder.toWord()}"
        } else {
            return "${hundreds.toWord()} hundred"
        }
    } else if (this > 19) {
        val tens = this / 10
        val remainder = this % 10

        if (remainder > 0) {
            return "${tensWords[tens]}-${remainder.toWord()}"
        } else {
            return tensWords[tens]
        }
    } else {
        return onesWords[this]
    }
}

@SolvedProblem("Number of letters used to write 1 to 1000 in words", "21124")
fun euler17() = (1..1000).map { it.toWord().filter { it.isLetter() }.length }.sum()