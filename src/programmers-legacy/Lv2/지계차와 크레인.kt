package Programmers.Lv2

class `지게차와크레인` {
    fun solution(storage: Array<String>, requests: Array<String>): Int {
        val n = storage.size
        val m = storage[0].length

        // 외부 패딩 추가: map 크기 (n+2) x (m+2), 바깥은 '.'로 둔다 (outside)
        val map = Array(n + 2) { CharArray(m + 2) { '.' } }
        for (i in 0 until n) {
            val row = storage[i]
            for (j in 0 until m) {
                map[i + 1][j + 1] = row[j]
            }
        }

        var remaining = n * m
        val dx = intArrayOf(1, -1, 0, 0)
        val dy = intArrayOf(0, 0, 1, -1)

        for (req in requests) {
            val ch = req[0]
            if (req.length >= 2) {
                // 크레인: 해당 문자 전부 제거
                for (i in 1..n) {
                    for (j in 1..m) {
                        if (map[i][j] == ch) {
                            map[i][j] = '.'
                            remaining--
                        }
                    }
                }
            } else {
                // 지게차: 외부에서 접근 가능한 동일 문자만 제거
                val visited = Array(n + 2) { BooleanArray(m + 2) }
                val q = ArrayDeque<Pair<Int, Int>>()
                val toRemove = mutableListOf<Pair<Int, Int>>()

                // outside (0,0)에서 시작
                visited[0][0] = true
                q.add(Pair(0, 0))

                while (q.isNotEmpty()) {
                    val (x, y) = q.removeFirst()
                    for (k in 0..3) {
                        val nx = x + dx[k]
                        val ny = y + dy[k]
                        if (nx !in 0..(n + 1) || ny !in 0..(m + 1)) continue
                        if (visited[nx][ny]) continue

                        val c = map[nx][ny]
                        if (c == '.') {
                            visited[nx][ny] = true
                            q.add(Pair(nx, ny))
                        } else if (c == ch) {
                            // 접근 가능한 목표 컨테이너 — 제거 후보에 추가 (하지만 즉시 '.'로 만들지 않음)
                            visited[nx][ny] = true
                            toRemove.add(Pair(nx, ny))
                        }
                        // 다른 문자는 통과 불가
                    }
                }

                // 한 번에 제거
                for ((x, y) in toRemove) {
                    if (map[x][y] != '.') {
                        map[x][y] = '.'
                        remaining--
                    }
                }
            }
        }
        return remaining
    }
}

fun main(){
    val i = 지게차와크레인()
    val storage = arrayOf("AZWQY", "CAABX", "BBDDA", "ACACA")
    val requests = arrayOf("A", "BB", "A")
    print(i.solution(storage, requests))
}