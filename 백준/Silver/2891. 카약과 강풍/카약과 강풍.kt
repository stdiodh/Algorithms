import java.io.StreamTokenizer

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())){
    fun nextInt() : Int { nextToken(); return nval.toInt() }

    val n = nextInt(); val s = nextInt(); val r = nextInt()
    val damagedTeams = IntArray(s) { nextInt() }.toMutableList()
    val spareTeams = IntArray(r) { nextInt() }.toMutableList()

    val selfRepaired = damagedTeams.filter { it in spareTeams }
    damagedTeams.removeAll(selfRepaired)
    spareTeams.removeAll(selfRepaired)

    var cnt = 0

    for (team in damagedTeams) {
        when {
            team - 1 in spareTeams -> spareTeams.remove(team - 1)
            team + 1 in spareTeams -> spareTeams.remove(team + 1)
            else -> cnt++
        }
    }

    print(cnt)
}