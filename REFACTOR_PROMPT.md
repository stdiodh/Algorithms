# Role
너는 Kotlin 기반 알고리즘 레포지토리의 구조를 개선하고 문서화를 담당하는 테크 리드야.

# Context
- 이 레포지토리는 BOJ Hub(Chrome Extension)와 연동되어 있어 `백준` 및 `프로그래머스`라는 이름의 자동 생성 디렉토리가 존재함.
- 그 외에 내가 예전에 풀었던 **Legacy 파일들(백준, 프로그래머스 등)**이 산발적으로 흩어져 있음.

# Goal
1. **Legacy 파일 정리**: 흩어져 있는 문제 파일들을 분석하여 알고리즘 유형별(패키지별)로 디렉토리를 만들어 이동시킨다. (프로그래머스 레거시 파일 포함)
2. **개념 문서화**: 각 카테고리 패키지 안에 해당 알고리즘을 설명하는 마크다운 파일(`{CategoryName}.md`)을 생성한다.

# Constraints (중요)
1. **BOJ Hub 폴더 보존**: `백준`과 `프로그래머스`라는 이름의 최상위 디렉토리는 절대 건드리지 않는다. (이동/수정 금지)
2. **Legacy 식별**: 위 두 폴더 밖에 있는 파일들은 모두 Legacy로 간주하고 정리 대상에 포함한다.
3. **Naming**: 디렉토리 및 파일명은 kebab-case(영어 소문자, 하이픈)를 사용한다.

# Instructions

## 1. Directory Restructuring (파일 정리)
- 모든 Legacy 파일(Kotlin 소스)을 스캔하여 적절한 알고리즘 카테고리 폴더로 이동시켜라.
- 예시 구조:
  /src
    /bfs
    /dp
    /greedy
    /implementation
    ...

## 2. Category Documentation (개념 설명 파일 생성)
- **중요**: 개별 문제마다 설명을 달지 말고, **각 카테고리 폴더마다** 그 알고리즘을 설명하는 `{CategoryName}.md` 파일을 하나씩 생성해라.
- 예: `/src/bfs/BFS.md`, `/src/dp/Dynamic-Programming.md`
- **문서 템플릿**:
  ```markdown
  # [알고리즘 이름] (예: Breadth-First Search)

  ## 1. 개념 요약
  - 이 알고리즘이 무엇인지 한두 줄로 간단히 설명.

  ## 2. 주요 특징 및 동작 원리
  - 핵심 로직이나 자료구조(예: Queue 사용 등) 설명.

  ## 3. 시간/공간 복잡도 (일반적)
  - Time: O(...)
  - Space: O(...)

  ## 4. 주로 사용되는 문제 유형
  - 예: 최단 경로 찾기, 연결 요소 개수 구하기 등

```

## 3. Git Commit

* 작업 완료 후 `AngularJS Commit Convention`에 맞춰 커밋 메시지를 제안해라.
* 예: `refactor(structure): organize legacy programmers and boj solutions into categories`
* 예: `docs(bfs): add BFS algorithm concept guide`

# Action Request

1. 먼저 현재 파일 트리를 분석하고, 어떤 파일들을 어떤 폴더로 옮길지 **계획(Plan)**을 리스트로 보여줘.
2. 내가 계획을 승인하면, 파일 이동과 카테고리별 MD 파일 생성을 진행해 줘.
