# Git Commit Convention

이 저장소는 **AngularJS Git Commit Message Conventions**를 따릅니다.
일관된 커밋 메시지를 통해 문제 풀이 이력과 수정 사항을 체계적으로 관리하는 것을 목표로 합니다.

---

## 1. 커밋 메시지 구조 (Commit Message Structure)

커밋 메시지는 **헤더(Header)**, **본문(Body)**, **바닥글(Footer)** 로 구성되며, 각 부분은 빈 줄로 구분합니다.

```text
<type>(<scope>): <subject>

<body>

<footer>

```

### 1.1 Header (필수)

헤더는 변경 사항을 한 줄로 요약합니다. 50자를 넘기지 않는 것을 권장합니다.

* **`<type>`**: 변경 사항의 종류 (아래 'Commit Type' 참고)
* **`<scope>`**: (선택 사항) 변경된 문제의 출처, 카테고리, 또는 문제 번호
* 예: `boj`, `programmers`, `dp`, `graph`, `1000`


* **`<subject>`**: 제목 (간결한 설명)
* **명령문**으로 작성합니다 (예: "Fix..." o, "Fixed..." x).
* 첫 글자는 대문자로 시작하지 않아도 됩니다.
* 끝에 마침표(`.`)를 찍지 않습니다.



### 1.2 Body (선택)

변경 사항의 **'이유(Why)'**와 **'무엇(What)'**을 설명합니다.

* 단순 문제 풀이 추가 시에는 생략 가능합니다.
* 리팩토링이나 로직 수정 시, 이전 코드와의 차이점을 설명하면 좋습니다.

### 1.3 Footer (선택)

* **BREAKING CHANGE**: 큰 변경 사항이 있을 때 작성합니다.
* **Issue Reference**: 관련된 이슈나 문제 번호를 참조합니다. (예: `Closes #1000`)

---

## 2. Commit Type (태그 종류)

알고리즘 문제 풀이에 맞춰 다음과 같이 태그를 정의합니다.

| Type | 설명 (Description) | 예시 상황 |
| --- | --- | --- |
| **feat** | 새로운 기능 추가 | 새로운 문제 풀이 코드 추가 (Solved) |
| **fix** | 버그 수정 | 오답(WA), 시간 초과(TLE) 등으로 인한 로직 수정 |
| **refactor** | 코드 리팩토링 | 로직 변경 없이 코드 구조 개선 (변수명 변경, 메서드 분리 등) |
| **docs** | 문서 수정 | `README.md`, `docs.md`, 주석 추가 및 수정 |
| **style** | 스타일 교정 | 코드 포맷팅, 세미콜론 누락, 들여쓰기 수정 (코드 동작 영향 없음) |
| **test** | 테스트 코드 | 테스트 케이스 추가, 테스트 코드 리팩토링 |
| **chore** | 기타 작업 | 빌드 설정, 패키지 매니저 설정, 파일 이동/삭제 등 |

---

## 3. 예시 (Examples)

### 새로운 문제 풀이 (New Solution)

```text
feat(boj): solve 1234 problem using BFS

- use adjacency list for graph representation
- time complexity: O(V+E)

```

### 버그 수정 (Bug Fix)

```text
fix(dp): fix index out of bounds exception in 1463

initialized dp array size to n + 1 instead of n

```

### 리팩토링 (Refactoring)

```text
refactor(programmers): optimize solution for finding prime numbers

replaced loop with Sieve of Eratosthenes algorithm to improve performance

```

### 문서 작업 (Documentation)

```text
docs: update README with solved problem count

```

### 파일 정리 (Chore)

```text
chore: move legacy files to categorized directories

```
