#!/usr/bin/env kscript

println("Sum of multiples of 5 and 5 under 1000: " + (1 until 1000)
        .filter { it % 3 == 0 || it % 5 == 0 }
        .sum())