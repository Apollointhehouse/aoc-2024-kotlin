package solutions

import kotlin.math.abs

object Day01 : Solution() {
	override fun part1(): Int {
		val (left, right) = lists
		val totalDistance = (left.sorted() zip right.sorted())
			.sumOf { (l, r) -> abs(l - r) }

		return totalDistance
	}

	override fun part2(): Int {
		val (left, right) = lists
		val score = left.sumOf {
			right.count { n -> n == it } * it
		}

		return score
	}

	private val lists = input.map { line ->
		val left = line.substringBefore(" ").toInt()
		val right = line.substringAfterLast(" ").toInt()

		left to right
	}.unzip()
}
