fun main() {
    val input = readInput("22_03")
    val priority: (Char) -> Int = { 1 + if (it.isLowerCase()) it - 'a' else it - 'A' + 26 }
    val part1 = input.sumOf {
        it.substring(0, it.length.div(2)).toSet().intersect(it.substring(it.length.div(2), it.length).toSet()).sumOf { priority(it) }
    }
    fun part2(): Int {
        var total = 0
        for (i in 0 until input.size step 3) {
            total += input[i].toSet().intersect(input[i+1].toSet()).intersect(input[i+2].toSet()).sumOf(priority)
        }
        return total
    }
    part1.println()
    part2().println()

}
