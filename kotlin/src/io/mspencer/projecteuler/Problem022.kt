package io.mspencer.projecteuler

val String.alphabeticValue get() = toUpperCase().map { (it - 'A') + 1 }.sum()

@SolvedProblem("Name scores", "871198282")
fun euler22() = readResource("/p022_names.txt")
        .trim().replace("\"", "").split(',')
        .sorted()
        .mapIndexed { index, name -> name.alphabeticValue * (index + 1) }
        .sum()