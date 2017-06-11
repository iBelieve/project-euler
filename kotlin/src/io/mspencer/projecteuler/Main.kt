@file:JvmName("Main")

package io.mspencer.projecteuler

import kotlin.properties.Delegates.notNull
import kotlin.reflect.full.findAnnotation
import kotlin.system.measureTimeMillis

val problems = listOf(::euler1, ::euler2, ::euler3, ::euler4, ::euler5)

fun main(args: Array<String>) {
    val problemNumber = args.firstOrNull()?.toInt() ?: problems.size
    val problem = problems[problemNumber - 1]

    val annotation = problem.findAnnotation<ProjectEuler>()

    require(annotation != null) { "Missing @ProjectEuler annotation on problem $problemNumber" }

    var result by notNull<String>()
    val time = measureTimeMillis {
        result = problem.invoke().toString()
    }

    println("${annotation!!.description}: $result ($time ms)")
}