@file:JvmName("Main")

package io.mspencer.projecteuler

import kotlin.properties.Delegates.notNull
import kotlin.reflect.full.findAnnotation
import kotlin.system.measureTimeMillis

val problems = listOf(
        ::euler1, ::euler2, ::euler3, ::euler4, ::euler5,
        ::euler6, ::euler7, ::euler8, ::euler9, ::euler10,
        ::euler11, ::euler12, ::euler13, ::euler14, ::euler15,
        ::euler16, ::euler17, ::euler18, ::euler67, ::euler19, ::euler20,
        ::euler21, ::euler22)

fun main(args: Array<String>) {
    if (args.firstOrNull() == "last") {
        runProblem(problems.lastIndex)
    } else {
        for (i in 0..problems.lastIndex) {
            runProblem(i)
        }
    }
}

fun runProblem(index: Int) {
    val problem = problems[index]
    val problemNumber = if (problem.name.startsWith("euler")) {
        problem.name.substring("euler".length).toInt()
    } else {
        index + 1
    }
    val solved = problem.findAnnotation<SolvedProblem>()
    val unsolved = problem.findAnnotation<UnsolvedProblem>()

    require((solved != null).xor(unsolved != null)) { "Must have either solved or unsolved annotation " }

    var result by notNull<String>()
    val time = measureTimeMillis {
        result = problem.invoke().toString()
    }

    if (solved != null) {
        if (solved.answer != result) {
            println("❌ $problemNumber: ${solved.description}: $result != ${solved.answer} ($time ms)")
        } else {
            println("✅ $problemNumber: ${solved.description}: $result ($time ms)")
        }
    } else if (unsolved != null) {
        println("🔘 $problemNumber: ${unsolved.description}: $result ($time ms)")
    }
}