import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

data class User(
    val number: Int,
    val name: String,
    val membership: String,
    val enterTime: LocalTime,
    val exitTime: LocalTime = enterTime.plusMinutes(30)
)

fun membershipPriority(membership: String): Int {
    return when (membership) {
        "VVIP" -> 1
        "VIP" -> 2
        else -> 3
    }
}

fun main() {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    val scanner = Scanner(System.`in`)
    val users = mutableListOf<User>()

    println("입력을 종료하려면 빈 줄을 입력하세요.")

    while (true) {
        val line = scanner.nextLine()
        if (line.isBlank()) break

        val parts = line.split(" ")
        if (parts.size < 4) continue

        val number = parts[0].removeSuffix(".").toInt()
        val time = LocalTime.parse(parts[1], formatter)
        val membership = parts[2]
        val name = parts.subList(3, parts.size).joinToString(" ")

        users.add(User(number, name, membership, time))
    }

    val waitingQueue = PriorityQueue<User> { u1, u2 ->
        val p1 = membershipPriority(u1.membership)
        val p2 = membershipPriority(u2.membership)
        if (p1 != p2) p1 - p2
        else u1.number - u2.number
    }

    val currentUsers = mutableListOf<User>()
    var nextAvailableTime = LocalTime.MIN

    val allTimes = (users.flatMap { listOf(it.enterTime, it.exitTime) } +
            users.map { it.exitTime.plusMinutes(1) })
        .distinct()
        .sorted()

    for (currentTime in allTimes) {
        val exited = currentUsers.filter { it.exitTime == currentTime }
        if (exited.isNotEmpty()) {
            currentUsers.removeAll(exited)
            nextAvailableTime = currentTime.plusMinutes(1)
        }

        val arrivals = users.filter { it.enterTime == currentTime }.sortedBy { it.number }

        for (user in arrivals) {
            if (currentUsers.size < 5 && currentTime >= nextAvailableTime) {
                currentUsers.add(user)
                println("[${currentTime.format(formatter)}] [${user.membership}]${user.name}님이 입장하셨습니다.")
            } else {
                waitingQueue.add(user)
                println("[${currentTime.format(formatter)}] [${user.membership}]${user.name}님이 대기열에 등록되었습니다.")
            }
        }

        while (currentUsers.size < 5 && waitingQueue.isNotEmpty() && currentTime >= nextAvailableTime) {
            val nextUser = waitingQueue.poll()
            currentUsers.add(nextUser)
            println("[${currentTime.format(formatter)}] [${nextUser.membership}]${nextUser.name}님이 입장하셨습니다.")
        }
    }
}
