fun main() {
    val input = readInput("22_04")
    fun getPair(s: String): Pair<Int,Int> {
        val (a,b) = s.split('-').map { it.toInt() }
        return a to b
    }
    val contain = fun(f: Pair<Int,Int>, s: Pair<Int,Int>): Boolean {
        return (f.first == s.first || f.second >= s.second)
    }
    val overlap = fun(f: Pair<Int,Int>, s: Pair<Int,Int>): Boolean {
        return (f.second >= s.first)
    }
    fun compute(rule: (Pair<Int,Int>, Pair<Int,Int>) -> Boolean): Int {
        var cnt = 0
        input.forEach() {
            var (f,s) = it.split(',').map { getPair(it) }
            if (f.first > s.first) f = s.also { s = f }
            if (rule(f,s)) { cnt += 1; }
        }
        return cnt
    }
    val part1 = compute(contain)
    val part2 = compute(overlap)
    part1.println()
    part2.println()
}