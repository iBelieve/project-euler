package io.mspencer.projecteuler

val triangleInput2 = readResource("/p067_triangle.txt")

@SolvedProblem("Max total from top to bottom of triangle II", "7273")
fun euler67() = Triangle(triangleInput2).maxTotal()