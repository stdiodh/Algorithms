package BOJ.hash

class BestAlbum {
    fun solution(genres: Array<String>, plays: IntArray): List<Int> {
        val album = mutableListOf<Triple<Int, String, Int>>()
        val answer = mutableListOf<Int>()
        for(index in genres.indices){
            album.add(Triple(index, genres[index], plays[index]))
        }

        val hash = HashMap<String, Int>()
        album.forEach {
            hash[it.second] = hash.getOrDefault(it.second, 0) + it.third
        }

        album.sortWith(compareByDescending<Triple<Int, String, Int>> { it.third }.thenBy { it.first })
        val sortedGenres = hash.entries.sortedByDescending { it.value }.map { it.key }

        for(topGenres in sortedGenres){
            var cnt = 0
            for(idx in album.indices){
                if(album[idx].second == topGenres){
                    answer.add(album[idx].first)
                    cnt++
                    if(cnt == 2){
                        break
                    }
                }
            }
        }
        return answer
    }
}

fun main(){
    val f = BestAlbum()
    println(f.solution(arrayOf("classic", "pop", "classic", "classic", "pop"), intArrayOf(500, 600, 150, 800, 2500)))
}