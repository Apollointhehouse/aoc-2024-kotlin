package solutions

import kotlin.math.sign

typealias Report = List<Int>
typealias Reports = List<Report>

object Day02 : Solution() {
	override fun part1(): Int {
		return reports.count { report -> report.isSafe() }
	}

	override fun part2(): Int {
		return reports.count {
			it.isSafe() || it.indices.any { i ->
				(it.take(i) + it.drop(i + 1)).isSafe()
			}
		}
	}

	private fun Report.isSafe(): Boolean =
		zipWithNext { a, b -> a - b }.sumOf { it.sign } == size - 1

	private val reports: Reports = input.map { line -> line.split(" ").map { it.toInt() } }
}