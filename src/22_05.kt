const val N = 9

fun main() {
    val input = readInput("22_05")
    val crates = List(N) { mutableListOf<Char>() }
    fun getCrate() {
        for (line in input) {
            if (!line.contains('[')) break
            for (i in 0 until N) {
                val item = line[4*i+1]
                if (item.isLetter()) crates[i].add(item)
            }
        }
        for (i in 0 until N) crates[i].reverse()
    }
    getCrate()
    for (line in input) {
        if (line.isEmpty() || line.first() != 'm') continue
        val numbers = mutableListOf<Int>()
        for (c in line) {
            if (c.isDigit()) numbers[numbers.lastIndex] = 10 * numbers.last() + (c-'0')
            else numbers.add(0)
        }
        val (q,a,b) = numbers.filter { it > 0 }
        val repo = mutableListOf<Char>()
        repeat(q) {
            repo.add(crates[a-1].last())
            crates[a-1].removeLast()
        }
//        repo.reverse()
        for (c in repo) crates[b-1].add(c)
    }
//    println(crates)
    for (i in 0 until N) print(crates[i].last())
}