fun main() {
    fun getSumList(input: List<String>): List<Int> {
        var curSum = 0
        val listSums = mutableListOf(0)
        for (line in input) {
            if ("" == line) {
                listSums.add(curSum)
                curSum = 0
            } else curSum += line.toInt()
        }
        listSums.sortWith(compareByDescending { it })
        return listSums
//        curSum = 0
//        for (i in 0..2) curSum += listSums[i]
//
//        return input.size
    }

    fun part1(input: List<Int>): Int = input[0]
    fun part2(input: List<Int>): Int = input.subList(0,3).sumOf { it }

    // test if implementation meet criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) > 0)

    val input = readInput("Day01")
    val list = getSumList(input)
    part1(list).println()
    part2(list).println()
}
