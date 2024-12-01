import solutions.Solution
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/data/$name.txt").readText().trim().lines()

fun List<Solution>.run(day: String) = filter { it.day == day }.forEach { solution ->
    val input = readInput(day)
    solution.run(input)
}

fun List<Solution>.runAll() = forEach { solution ->
    val day = solution.day
    val input = readInput(day)
    solution.run(input)
}

fun List<Solution>.test(day: String) = filter { it.day == day }.forEach { solution ->
    val input = readInput("${day}_test")
    solution.test(input)
}

fun List<Solution>.testAll() = forEach { solution ->
    val day = solution.day
    val input = readInput("${day}_test")
    solution.test(input)
}
