package solutions

import readInput

abstract class Solution {
	abstract fun part1(): Int
	abstract fun part2(): Int

	private val test = false
	val day = this::class.simpleName ?: error("No class name")
	val input by lazy { readInput(day + if (test) "_test" else "") }

	fun run() {
		println("${day}:")
		println("Part 1: ${part1()}")
		println("Part 2: ${part2()}")
		println()
	}
}