@file:JvmName("Main")

package io.mspencer.projecteuler

import kotlin.properties.Delegates.notNull
import kotlin.reflect.full.findAnnotation
import kotlin.system.measureTimeMillis

val problems = listOf(::euler1, ::euler2, ::euler3, ::euler4, ::euler5, ::euler6, ::euler7, ::euler8)

fun main(args: Array<String>) {
    problems.forEachIndexed { index, problem ->
        val problemNumber = index + 1
        val annotation = problem.findAnnotation<ProjectEuler>()!!

        var result by notNull<String>()
        val time = measureTimeMillis {
            result = problem.invoke().toString()
        }

        if (annotation.answer.isNotEmpty() && annotation.answer != result) {
            println("$problemNumber: ${annotation.description}: $result !+ ${annotation.answer} ($time ms)")
        } else {
            println("$problemNumber: ${annotation.description}: $result ($time ms)")
        }
    }
}