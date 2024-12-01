package solutions

import kotlin.math.abs

object Day01 : Solution(
	test1 = 11,
	test2 = 31
) {
	override fun part1(input: List<String>): Int {
		val (left, right) = getLists(input)

		val totalDistance = (left zip right).sumOf { (first, second) ->
			abs(first - second)
		}

		return totalDistance
	}

	override fun part2(input: List<String>): Int {
		val (left, right) = getLists(input)

		val score = left.sumOf {
			right.count { n -> n == it } * it
		}

		return score
	}

	private fun getLists(input: List<String>): Pair<List<Int>, List<Int>> {
		val left = input.map { it.substringBefore(" ").toInt() }.sorted()
		val right = input.map { it.substringAfter("   ").toInt() }.sorted()

		return Pair(left, right)
	}
}
