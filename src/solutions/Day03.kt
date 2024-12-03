package solutions

import solutions.Operation.*

object Day03 : Solution() {
    private val MUL = Regex("""mul\(\d{1,3},\d{1,3}\)""")
    private val DO = Regex("""do\(\)""")
    private val DONT = Regex("""don't\(\)""")
    private val OPERATION_REGEX = Regex("""${MUL}|${DO}|${DONT}""")
    private val operations = input.flatMap { findOperators(it) }.also { println(it) }

    override fun part1(): Int {
        return operations.sumOf {
            if (it is Mul) it.a * it.b else 0
        }
    }

    override fun part2(): Int {
        var doMul = true

        return operations.sumOf {
            when (it) {
                is Mul -> if (doMul) it.a * it.b else 0
                is Do -> {
                    doMul = true
                    0
                }
                is Dont -> {
                    doMul = false
                    0
                }
            }
        }
    }

    private fun findOperators(str: String): List<Operation> {
        return OPERATION_REGEX
            .findAll(str)
            .map { match ->
                val group = match.groupValues.first()
                when {
                    MUL.matches(group) -> {
                        val (a, b) = """\d{1,3}"""
                            .toRegex()
                            .findAll(match.value)
                            .map { it.value.toInt() }
                            .toList()
                        Mul(a, b)
                    }

                    DO.matches(group) -> Do
                    DONT.matches(group) -> Dont
                    else -> throw IllegalArgumentException("Invalid operator")
                }
            }
            .toList()
    }
}

sealed class Operation {
    class Mul(val a: Int, val b: Int) : Operation()
    data object Do : Operation()
    data object Dont : Operation()
}