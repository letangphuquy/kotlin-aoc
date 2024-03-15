val OUTCOME_TO_SCORE = mapOf<Int,Int>(0 to 3, 1 to 6, 2 to 0)

fun main() {
    fun parseInput(input: List<String>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        for (line in input) {
            val (opponentChar, myChar) = line.split(' ').map { it[0] }
            val opponentIndex = opponentChar - 'A'
            val myIndex = myChar - 'X'
            result.add(listOf(opponentIndex, myIndex))
        }
        return result
    }
    fun evaluateStrategy(choices: List<List<Int>>): Int {
        var totalScore = 0
        for (line in choices) {
            val (opponentIndex, myIndex) = line
            totalScore += OUTCOME_TO_SCORE[(myIndex - opponentIndex + 3).mod(3)]!!
            totalScore += myIndex + 1
        }
        return totalScore
    }

    val input = readInput("22_02")
    val choices = parseInput(input)

    fun part1(): Int = evaluateStrategy(choices)
    fun part2(): Int = evaluateStrategy(choices.map { listOf(it[0], (it[0] + (it[1]-1) + 3).mod(3)) })
    part1().println()
    part2().println()
}
