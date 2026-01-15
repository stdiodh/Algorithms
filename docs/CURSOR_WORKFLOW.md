# Cursor 작업 프로세스 가이드

이 문서는 Cursor AI가 알고리즘 레포지토리를 관리할 때 따라야 할 작업 프로세스를 정의합니다.

---

## 📋 기본 원칙

1. **루트 디렉토리 파일 감지**: 사용자가 루트 디렉토리에 `문제이름.kt` 파일을 생성하면 자동으로 처리
2. **플랫폼 구분**: BOJ 문제와 프로그래머스 문제를 자동으로 구분하여 적절한 위치로 이동
3. **카테고리 분류**: 알고리즘 유형에 따라 적절한 카테고리 디렉토리로 분류
4. **커밋 규칙 준수**: `COMMIT_CONVENTION.md`의 규칙을 엄격히 따름

---

## 🔍 파일 분석 방법

### 1. 플랫폼 구분 (BOJ vs 프로그래머스)

#### BOJ 문제 식별
- **파일명 패턴**: 숫자로 시작하는 파일명 (예: `1234.kt`, `2178.kt`)
- **패키지 선언**: `package BOJ.xxx` 형태
- **파일 내용**: `main()` 함수에서 `System.in` 사용, 문제 번호가 주석이나 코드에 포함

#### 프로그래머스 문제 식별
- **파일명 패턴**: 한글 파일명 (예: `가운데 글자 가져오기.kt`, `두 개 뽑아서 더하기.kt`)
- **패키지 선언**: `package Programmers.xxx` 형태
- **클래스 구조**: `class 문제이름 { fun solution(...) }` 형태

### 2. 알고리즘 카테고리 분류

파일 내용을 분석하여 다음 카테고리 중 하나로 분류:

| 카테고리 | 키워드/패턴 | 디렉토리 경로 |
|---------|------------|--------------|
| **BFS** | `Queue`, `LinkedList`, `bfs`, 레벨별 탐색 | `src/graph/bfs/` |
| **DFS** | `Stack`, `재귀`, `dfs`, 깊이 우선 | `src/graph/dfs/` |
| **DP** | `dp`, `memoization`, `동적 프로그래밍`, 배열 누적 | `src/dynamic-programming/` |
| **Greedy** | `그리디`, `greedy`, 매 순간 최선 선택 | `src/greedy/` |
| **Binary Search** | `이진 탐색`, `binary search`, `lowerBound`, `upperBound` | `src/binary-search/` |
| **Two Pointer** | `투 포인터`, `two pointer`, `left`, `right` | `src/two-pointer/` |
| **Sliding Window** | `슬라이딩 윈도우`, `sliding window`, 고정 크기 윈도우 | `src/sliding-window/` |
| **Prefix Sum** | `누적합`, `prefix sum`, `pSum`, 구간 합 | `src/prefix-sum/` |
| **Stack** | `Stack`, `스택`, `push`, `pop`, LIFO | `src/data-structure/stack/` |
| **Queue** | `Queue`, `큐`, `enqueue`, `dequeue`, FIFO | `src/data-structure/queue/` |
| **Priority Queue** | `PriorityQueue`, `우선순위 큐`, `힙`, `heap` | `src/data-structure/priority-queue/` |
| **Hash Map** | `HashMap`, `Map`, `해시맵`, `groupBy` | `src/data-structure/hash-map/` |
| **Sort** | `sort`, `sorted`, `정렬` | `src/sort/` |
| **String** | 문자열 처리, `substring`, `replace`, `split` | `src/string/` |
| **Math** | 수학 연산, `GCD`, `LCM`, `소수`, `약수` | `src/math/` |
| **Parsing** | 파싱, `parseInt`, `정규식`, `Regex` | `src/parsing/` |
| **Implementation** | 구현, 시뮬레이션, 규칙 기반 | `src/implementation/{boj\|programmers}/` |

**분류 우선순위**: 
1. 파일 내용 분석 (주석, 변수명, 알고리즘 패턴)
2. 파일명 힌트
3. 기본값: `implementation` (구현 문제로 간주)

---

## 📁 디렉토리 구조

```
src/
├── graph/
│   ├── bfs/          # BOJ BFS 문제
│   └── dfs/          # BOJ DFS 문제
├── dynamic-programming/  # BOJ DP 문제
├── greedy/           # BOJ 그리디 문제
├── binary-search/    # BOJ 이진 탐색
├── two-pointer/      # BOJ 투 포인터
├── sliding-window/   # BOJ 슬라이딩 윈도우
├── prefix-sum/       # BOJ 누적합
├── data-structure/
│   ├── stack/        # BOJ 스택
│   ├── queue/        # BOJ 큐
│   ├── priority-queue/  # BOJ 우선순위 큐
│   └── hash-map/     # BOJ 해시맵
├── sort/             # BOJ 정렬
├── string/           # BOJ 문자열
├── math/             # BOJ 수학
├── parsing/          # BOJ 파싱
└── implementation/
    ├── boj/          # BOJ 구현 문제
    └── programmers/  # 프로그래머스 문제
        ├── implementation/
        ├── string/
        ├── math/
        ├── java/
        └── lv2/
```

---

## 🔄 작업 프로세스

### Step 1: 루트 디렉토리 파일 감지
```bash
# 루트 디렉토리에서 .kt 파일 찾기
find . -maxdepth 1 -name "*.kt" -type f
```

### Step 2: 파일 분석
1. 파일 내용 읽기 (최소 20줄)
2. 패키지 선언 확인 (`package BOJ.xxx` 또는 `package Programmers.xxx`)
3. 알고리즘 패턴 분석 (주석, 변수명, 자료구조 사용)
4. 파일명 분석 (숫자 시작 = BOJ, 한글 = 프로그래머스)

### Step 3: 플랫폼 및 카테고리 결정
- **BOJ 문제**: `src/{category}/` 또는 `src/implementation/boj/`
- **프로그래머스 문제**: `src/implementation/programmers/{category}/`

### Step 4: 파일 이동
```bash
git mv {루트경로}/{파일명}.kt {목적지경로}/{파일명}.kt
```

### Step 5: 커밋 메시지 작성
`COMMIT_CONVENTION.md` 규칙에 따라:

**새로운 문제 풀이 추가:**
```bash
feat({platform}): solve {problem-number} problem using {algorithm}

- {간단한 설명}
- time complexity: O(...)
```

**예시:**
```bash
feat(boj): solve 2178 problem using BFS

- use queue for level-order traversal
- time complexity: O(V+E)
```

```bash
feat(programmers): solve 가운데 글자 가져오기 using string processing

- extract middle character from string
- time complexity: O(1)
```

### Step 6: 커밋 실행
```bash
git add {이동된파일경로}
git commit -m "{위에서 작성한 커밋 메시지}"
```

---

## 📝 커밋 타입 가이드

| 상황 | Type | Scope | 예시 |
|------|------|-------|------|
| 새 문제 풀이 | `feat` | `boj` 또는 `programmers` | `feat(boj): solve 1234 using BFS` |
| 버그 수정 | `fix` | 문제 번호 또는 카테고리 | `fix(dp): fix index error in 1463` |
| 코드 개선 | `refactor` | 카테고리 | `refactor(bfs): optimize queue usage` |
| 파일 이동 | `chore` | - | `chore: move 1234.kt to graph/bfs/` |

---

## ⚠️ 주의사항

1. **BOJ Hub 디렉토리 보존**: 
   - `백준/` 디렉토리는 절대 건드리지 않음
   - `프로그래머스/` 디렉토리는 절대 건드리지 않음

2. **파일명 규칙**:
   - BOJ: 숫자로 시작 (예: `2178.kt`)
   - 프로그래머스: 한글 파일명 유지 (예: `가운데 글자 가져오기.kt`)

3. **중복 파일 처리**:
   - 같은 이름의 파일이 이미 존재하면 사용자에게 확인 요청
   - 또는 파일명에 타임스탬프 추가

4. **카테고리 불명확 시**:
   - `implementation` 카테고리로 분류
   - 사용자에게 알림

---

## 🎯 작업 체크리스트

새로운 문제 파일을 처리할 때:

- [ ] 루트 디렉토리에서 `.kt` 파일 확인
- [ ] 파일 내용 분석 (패키지, 알고리즘 패턴)
- [ ] 플랫폼 구분 (BOJ vs 프로그래머스)
- [ ] 카테고리 결정
- [ ] 적절한 디렉토리로 파일 이동
- [ ] `COMMIT_CONVENTION.md` 규칙에 맞는 커밋 메시지 작성
- [ ] 커밋 실행

---

## 📚 참고 문서

- `COMMIT_CONVENTION.md`: 커밋 메시지 규칙
- `README.md`: 레포지토리 구조 및 개요
