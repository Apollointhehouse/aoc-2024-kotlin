import solutions.Solution
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/data/$name.txt").readText().trim().lines()

fun List<Solution>.run(day: String) = find { it.day == day }?.run()

fun List<Solution>.runAll() = forEach { it.run() }