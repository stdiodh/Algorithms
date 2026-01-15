fun main() {
    // ANI Lang 코드 샘플
    val source = """
        FUNC ADD A B
        DO
        RETURN A + B
        END

        FUNC MAIN
        DO
        STATIC INT A
        A = 10
        INT B
        B = 10
        B = 20
        INT SUM
        SUM = ADD A B
        PRINT SUM
        END
    """.trimIndent()

    // ANIInterpreter 인스턴스를 생성하고 코드를 실행합니다.
    val interpreter = AniInterpreter()
    interpreter.execute(source)
}

// ANI Lang 코드를 해석하고 실행하는 클래스
class AniInterpreter {

    // 프로세스 메모리 구조
    private val codeSegment = mutableListOf<String>()  // 텍스트 영역
    private val dataSegment = mutableMapOf<String, Any>()  // 데이터 영역 (전역 변수)
    private val heapSegment = mutableListOf<Any>()  // 힙 영역
    private val stackSegment = mutableListOf<Map<String, Any>>()  // 스택 영역
    private val allocatedMemory = mutableListOf<MemoryBlock>() // 메모리 블록 추적 (가비지 컬렉션을 위해)

    // 함수들을 저장할 맵
    private val functions = mutableMapOf<String, AniFunction>()

    // 메모리 블록 (4바이트 단위, 2바이트 데이터와 2바이트 패딩)
    data class MemoryBlock(val address: Int, val size: Int, val data: Any?)

    // ANI Lang 코드 실행 함수
    fun execute(code: String) {
        // 코드를 줄 단위로 나누고 공백을 제거한 후 비어있는 줄은 제거
        val lines = code.lines().map { it.trim() }.filter { it.isNotEmpty() }
        var i = 0

        // 코드를 한 줄씩 읽으며 해석
        while (i < lines.size) {
            val line = lines[i]
            // FUNC 명령어를 만났을 때 함수 정의 시작
            if (line.startsWith("FUNC")) {
                val parts = line.split(" ")
                val funcName = parts[1] // 함수 이름
                val params = parts.drop(2) // 매개변수 목록
                i++ // DO 줄을 건너뛰기
                val body = mutableListOf<String>()
                // 함수 본문을 읽고 "END"가 나올 때까지 이어서 읽기
                while (!lines[i].startsWith("END")) {
                    body.add(lines[i])
                    i++
                }
                // 함수 정보 저장
                functions[funcName] = AniFunction(funcName, params, body)
            }
            i++
        }

        // MAIN 함수 실행
        functions["MAIN"]?.let { executeFunction(it, listOf()) }

        // 가비지 컬렉션 실행
        garbageCollection()
    }

    // 함수 실행
    private fun executeFunction(func: AniFunction, args: List<Any>): Any? {
        // 함수 내 로컬 변수들을 저장할 맵
        val localScope = mutableMapOf<String, Any>()

        // 매개변수들을 로컬 스코프에 할당
        func.params.forEachIndexed { index, param ->
            localScope[param] = args.getOrNull(index) ?: 0
        }

        // 스택에 로컬 변수 푸시
        stackSegment.add(localScope)

        var returnValue: Any? = null

        // 함수 본문을 한 줄씩 실행
        for (line in func.body) {
            when {
                // STATIC, INT, STRING 변수 선언
                line.startsWith("STATIC") || line.startsWith("INT") || line.startsWith("STRING") -> {
                    val parts = line.split(" ")
                    val varName = parts.last() // 변수 이름
                    val value: Any = if (line.contains("STRING")) "" else 0 // 타입에 따라 기본 값 설정
                    localScope[varName] = value

                    // 메모리 할당 (정수형 데이터 2바이트, 문자열 데이터 8바이트)
                    if (line.contains("STRING")) {
                        val address = allocateMemory(value, 8)
                        localScope[varName] = address
                    } else {
                        val address = allocateMemory(value, 4)  // 정수형은 4바이트
                        localScope[varName] = address
                    }

                    // 데이터 영역에 전역 변수로 저장
                    if (line.startsWith("STATIC")) {
                        dataSegment[varName] = value
                    }
                }
                // 사용자 입력 받기 (INPUT)
                line.startsWith("INPUT") -> {
                    val varName = line.split(" ")[1]
                    print("$varName? ")
                    val input = readln() // 사용자 입력 받기
                    localScope[varName] = input.toIntOrNull() ?: input // 정수 변환 가능하면 변환, 아니면 문자열로 저장
                }
                // 변수 값 출력 (PRINT)
                line.startsWith("PRINT") -> {
                    val varName = line.split(" ")[1]
                    println(localScope[varName] ?: dataSegment[varName]) // 변수 값을 출력 (로컬 스코프, 글로벌 스코프 순으로 확인)
                }
                // 반환값 반환 (RETURN)
                line.startsWith("RETURN") -> {
                    val expr = line.removePrefix("RETURN ") // RETURN 뒤의 표현식을 평가
                    return evaluate(expr, localScope)
                }
                // 함수 호출 (CALL)
                line.startsWith("CALL") -> {
                    val tokens = line.split(" ")
                    val funcName = tokens[1] // 호출할 함수 이름
                    val argsList = tokens.drop(2).map { evaluate(it, localScope) } // 매개변수들 평가
                    executeFunction(functions[funcName]!!, argsList) // 함수 실행
                }
                // 변수에 값 할당
                line.contains("=") -> {
                    val (name, expr) = line.split("=").map { it.trim() }
                    localScope[name] = evaluate(expr, localScope) // 변수에 값 할당
                }
            }
        }

        // 함수 실행 후 스택에서 로컬 변수 팝
        stackSegment.removeAt(stackSegment.size - 1)

        return returnValue
    }

    // 표현식 평가 함수
    private fun evaluate(expr: String, scope: MutableMap<String, Any>): Any {
        return when {
            // 덧셈 연산자 처리
            expr.contains("+") -> {
                val parts = expr.split("+").map { it.trim() }
                val left = scope[parts[0]] ?: parts[0].toIntOrNull() ?: parts[0]
                val right = scope[parts[1]] ?: parts[1].toIntOrNull() ?: parts[1]
                // 두 값이 모두 정수면 더하고, 아니면 문자열 결합
                if (left is Int && right is Int) left + right else "$left$right"
            }
            // 숫자 처리
            expr.matches(Regex("\\d+")) -> expr.toInt()
            // 변수 처리
            else -> scope[expr] ?: 0
        }
    }

    // 메모리 할당 함수 (정수형은 4바이트, 문자열은 8바이트 할당)
    private fun allocateMemory(data: Any, size: Int): Int {
        val address = allocatedMemory.size * 4  // 4바이트 단위로 주소 계산
        allocatedMemory.add(MemoryBlock(address, size, data))
        return address
    }

    // 가비지 컬렉션 (참조되지 않은 메모리 해제)
    private fun garbageCollection() {
        val usedAddresses = mutableSetOf<Int>()

        // 스택과 데이터 영역에서 사용된 메모리 주소 추적
        stackSegment.forEach { localScope ->
            localScope.values.forEach { address ->
                if (address is Int) usedAddresses.add(address)
            }
        }
        dataSegment.values.forEach { address ->
            if (address is Int) usedAddresses.add(address)
        }

        // 사용되지 않은 메모리 블록 제거
        allocatedMemory.removeAll { it.address !in usedAddresses }
        println("Garbage Collection Complete!")
    }
}

// 함수 정보를 담을 데이터 클래스
data class AniFunction(
    val name: String, // 함수 이름
    val params: List<String>, // 매개변수 목록
    val body: List<String> // 함수 본문
)
