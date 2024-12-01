package solutions

abstract class Solution(
	val test1: Int,
	val test2: Int
) {
	abstract fun part1(input: List<String>): Int
	abstract fun part2(input: List<String>): Int

	val day = this::class.simpleName ?: error("Day not found")

	fun test(input: List<String>) {
		println("$day Test:")
		println("Part 1 Passed: ${part1(input) == test1}")
		println("Part 2 Passed: ${part2(input) == test2}")
		println()
	}

	fun run(input: List<String>) {
		println("${day}:")
		println("Part 1: ${part1(input)}")
		println("Part 2: ${part2(input)}")
		println()
	}
}