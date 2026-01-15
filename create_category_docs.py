#!/usr/bin/env python3
import os
import re
from pathlib import Path

def get_problems_in_directory(dir_path):
    """Get list of problem files in directory"""
    problems = []
    for file in dir_path.iterdir():
        if file.is_file() and (file.suffix == '.kt' or file.suffix == '.java'):
            problem_num = re.search(r'^(\d+)', file.name)
            if problem_num:
                problems.append({
                    'num': problem_num.group(1),
                    'name': file.name
                })
    return sorted(problems, key=lambda x: int(x['num']))

def create_category_docs():
    """Create category-level docs.md files"""
    
    categories = {
        'graph/bfs': {
            'title': 'BFS (너비 우선 탐색)',
            'description': 'BFS는 그래프를 레벨별로 탐색하는 알고리즘입니다. 큐를 사용하여 같은 레벨의 노드들을 먼저 방문합니다.',
            'key_points': [
                '큐(Queue) 자료구조 사용',
                '최단 경로 문제에 적합',
                '레벨별 탐색으로 거리 계산 가능'
            ],
            'complexity': {
                'time': 'O(V + E)',
                'space': 'O(V)'
            },
            'common_use_cases': [
                '미로 탐색',
                '최단 경로 찾기',
                '연결 요소 찾기'
            ]
        },
        'graph/dfs': {
            'title': 'DFS (깊이 우선 탐색)',
            'description': 'DFS는 그래프를 깊이 우선으로 탐색하는 알고리즘입니다. 스택 또는 재귀를 사용합니다.',
            'key_points': [
                '스택(Stack) 또는 재귀 사용',
                '백트래킹 문제에 적합',
                '경로 탐색, 사이클 탐지에 활용'
            ],
            'complexity': {
                'time': 'O(V + E)',
                'space': 'O(V)'
            },
            'common_use_cases': [
                '경로 탐색',
                '사이클 탐지',
                '트리 순회'
            ]
        },
        'dynamic-programming': {
            'title': 'Dynamic Programming (동적 프로그래밍)',
            'description': 'DP는 큰 문제를 작은 하위 문제로 나누어 해결하고, 결과를 저장하여 재사용하는 알고리즘 기법입니다.',
            'key_points': [
                '메모이제이션 또는 타뷸레이션 사용',
                '중복 계산을 피하여 효율성 향상',
                '최적 부분 구조와 중복 부분 문제 조건 필요'
            ],
            'complexity': {
                'time': 'O(n²) ~ O(n³) (문제에 따라 다름)',
                'space': 'O(n) ~ O(n²)'
            },
            'common_use_cases': [
                '최적화 문제',
                '경로의 개수 계산',
                '최대/최소 값 찾기'
            ]
        },
        'greedy': {
            'title': 'Greedy Algorithm (그리디 알고리즘)',
            'description': '그리디 알고리즘은 각 단계에서 최선의 선택을 하는 방식으로 문제를 해결합니다.',
            'key_points': [
                '매 순간 최선의 선택',
                '전역 최적해를 보장하지 않을 수 있음',
                '활동 선택, 최소 신장 트리 등에 활용'
            ],
            'complexity': {
                'time': 'O(n log n) (정렬 포함)',
                'space': 'O(1) ~ O(n)'
            },
            'common_use_cases': [
                '활동 선택 문제',
                '최소 비용 문제',
                '간격 스케줄링'
            ]
        },
        'binary-search': {
            'title': 'Binary Search (이진 탐색)',
            'description': '이진 탐색은 정렬된 배열에서 특정 값을 효율적으로 찾는 알고리즘입니다.',
            'key_points': [
                '정렬된 데이터에서만 사용 가능',
                '매 단계마다 탐색 범위를 절반으로 줄임',
                '매우 빠른 탐색 속도'
            ],
            'complexity': {
                'time': 'O(log n)',
                'space': 'O(1)'
            },
            'common_use_cases': [
                '정렬된 배열에서 값 찾기',
                '파라메트릭 서치',
                '최적값 찾기'
            ]
        },
        'two-pointer': {
            'title': 'Two Pointer (투 포인터)',
            'description': '투 포인터는 배열이나 문자열에서 두 개의 포인터를 사용하여 효율적으로 문제를 해결하는 기법입니다.',
            'key_points': [
                '두 개의 포인터를 조작하여 탐색',
                'O(n²)를 O(n)으로 최적화 가능',
                '정렬된 배열에서 특히 유용'
            ],
            'complexity': {
                'time': 'O(n)',
                'space': 'O(1)'
            },
            'common_use_cases': [
                '합이 특정 값인 쌍 찾기',
                '부분 배열 문제',
                '정렬된 배열 처리'
            ]
        },
        'sliding-window': {
            'title': 'Sliding Window (슬라이딩 윈도우)',
            'description': '슬라이딩 윈도우는 고정된 크기의 윈도우를 이동시키며 문제를 해결하는 기법입니다.',
            'key_points': [
                '고정 또는 가변 크기 윈도우',
                '중복 계산을 피하여 효율성 향상',
                '연속된 부분 배열/문자열 문제에 적합'
            ],
            'complexity': {
                'time': 'O(n)',
                'space': 'O(k) (윈도우 크기)'
            },
            'common_use_cases': [
                '최대/최소 부분 배열',
                '고유 원소 개수',
                '부분 문자열 문제'
            ]
        },
        'prefix-sum': {
            'title': 'Prefix Sum (누적합)',
            'description': '누적합은 배열의 각 위치까지의 합을 미리 계산하여 구간 합을 빠르게 구하는 기법입니다.',
            'key_points': [
                '구간 합을 O(1)에 계산 가능',
                '1차원, 2차원 배열 모두 적용 가능',
                '구간 쿼리 문제에 유용'
            ],
            'complexity': {
                'time': 'O(n) (전처리), O(1) (쿼리)',
                'space': 'O(n)'
            },
            'common_use_cases': [
                '구간 합 계산',
                '2D 배열 부분 합',
                '구간 쿼리 최적화'
            ]
        },
        'data-structure/stack': {
            'title': 'Stack (스택)',
            'description': '스택은 LIFO(Last In First Out) 원칙을 따르는 선형 자료구조입니다.',
            'key_points': [
                '후입선출 구조',
                'push, pop 연산이 O(1)',
                '괄호 매칭, 후위 표기법 등에 활용'
            ],
            'complexity': {
                'time': 'O(1) (push/pop)',
                'space': 'O(n)'
            },
            'common_use_cases': [
                '괄호 매칭',
                '후위 표기법 계산',
                '역순 처리'
            ]
        },
        'data-structure/queue': {
            'title': 'Queue (큐)',
            'description': '큐는 FIFO(First In First Out) 원칙을 따르는 선형 자료구조입니다.',
            'key_points': [
                '선입선출 구조',
                'enqueue, dequeue 연산이 O(1)',
                'BFS, 스케줄링에 활용'
            ],
            'complexity': {
                'time': 'O(1) (enqueue/dequeue)',
                'space': 'O(n)'
            },
            'common_use_cases': [
                'BFS 구현',
                '작업 스케줄링',
                '버퍼 관리'
            ]
        },
        'data-structure/priority-queue': {
            'title': 'Priority Queue (우선순위 큐)',
            'description': '우선순위 큐는 우선순위가 높은 요소가 먼저 나오는 자료구조입니다. 보통 힙으로 구현합니다.',
            'key_points': [
                '최대/최소 힙으로 구현',
                '우선순위에 따른 자동 정렬',
                '최소/최대 값 빠른 접근'
            ],
            'complexity': {
                'time': 'O(log n) (insert/extract)',
                'space': 'O(n)'
            },
            'common_use_cases': [
                '최소/최대 값 관리',
                '다익스트라 알고리즘',
                '힙 정렬'
            ]
        },
        'data-structure/hash-map': {
            'title': 'Hash Map (해시맵)',
            'description': '해시맵은 키-값 쌍을 저장하는 자료구조로, 평균적으로 O(1)의 접근 시간을 제공합니다.',
            'key_points': [
                '키를 해시 함수로 변환하여 저장',
                '평균 O(1) 접근 시간',
                '중복 체크, 카운팅에 유용'
            ],
            'complexity': {
                'time': 'O(1) 평균, O(n) 최악',
                'space': 'O(n)'
            },
            'common_use_cases': [
                '빠른 조회',
                '중복 체크',
                '카운팅'
            ]
        },
        'sort': {
            'title': 'Sorting (정렬)',
            'description': '정렬은 데이터를 특정 순서대로 나열하는 알고리즘입니다.',
            'key_points': [
                '다양한 정렬 알고리즘 존재',
                '시간 복잡도: O(n log n) 최적',
                '정렬 후 이진 탐색 등 활용'
            ],
            'complexity': {
                'time': 'O(n log n) (최적)',
                'space': 'O(1) ~ O(n)'
            },
            'common_use_cases': [
                '데이터 정렬',
                '정렬 후 처리',
                '중복 제거'
            ]
        },
        'string': {
            'title': 'String Processing (문자열 처리)',
            'description': '문자열 처리 알고리즘은 문자열을 다루는 다양한 기법들을 포함합니다.',
            'key_points': [
                '문자열 매칭, 파싱',
                '정규식 활용',
                '문자열 변환'
            ],
            'complexity': {
                'time': 'O(n) ~ O(n²)',
                'space': 'O(n)'
            },
            'common_use_cases': [
                '문자열 검색',
                '파싱',
                '문자열 변환'
            ]
        },
        'math': {
            'title': 'Mathematics (수학)',
            'description': '수학 알고리즘은 수학적 개념을 활용하여 문제를 해결합니다.',
            'key_points': [
                '약수, 배수, 소수',
                '최대공약수, 최소공배수',
                '조합론, 정수론'
            ],
            'complexity': {
                'time': '문제에 따라 다양',
                'space': 'O(1) ~ O(n)'
            },
            'common_use_cases': [
                '소수 판별',
                '최대공약수 계산',
                '조합 계산'
            ]
        },
        'implementation': {
            'title': 'Implementation (구현)',
            'description': '구현 문제는 특정 알고리즘보다는 문제의 요구사항을 정확히 코드로 옮기는 것이 중요합니다.',
            'key_points': [
                '문제 요구사항 정확한 이해',
                '엣지 케이스 처리',
                '코드의 정확성과 가독성'
            ],
            'complexity': {
                'time': '문제에 따라 다양',
                'space': '문제에 따라 다양'
            },
            'common_use_cases': [
                '시뮬레이션',
                '규칙 기반 문제',
                '복잡한 조건 처리'
            ]
        },
        'parsing': {
            'title': 'Parsing (파싱)',
            'description': '파싱은 입력 데이터를 분석하고 구조화하는 과정입니다.',
            'key_points': [
                '입력 형식 분석',
                '정규식 활용',
                '데이터 추출 및 변환'
            ],
            'complexity': {
                'time': 'O(n)',
                'space': 'O(n)'
            },
            'common_use_cases': [
                '로그 파싱',
                '데이터 추출',
                '형식 변환'
            ]
        }
    }
    
    base_dir = Path('src')
    
    # Remove existing individual docs.md files
    for docs_file in base_dir.rglob('docs.md'):
        if docs_file.parent.name not in ['learning', 'archive', 'misc', 'programmers-legacy']:
            # Check if it's a category-level directory
            parent_name = docs_file.parent.name
            if parent_name in ['bfs', 'dfs', 'stack', 'queue', 'priority-queue', 'hash-map']:
                # Keep it, it's category-level
                continue
            elif any(char.isdigit() for char in parent_name):
                # It's a problem-specific directory, remove
                docs_file.unlink()
                print(f"Removed: {docs_file}")
    
    # Create category-level docs.md
    for category_path, info in categories.items():
        dir_path = base_dir / category_path
        if not dir_path.exists():
            continue
            
        docs_path = dir_path / 'docs.md'
        problems = get_problems_in_directory(dir_path)
        
        problems_list = '\n'.join([
            f"- [{prob['num']}번](https://www.acmicpc.net/problem/{prob['num']}) - {prob['name']}"
            for prob in problems
        ]) if problems else "- 아직 문제가 없습니다."
        
        docs_content = f"""# {info['title']}

## 개요
{info['description']}

## 핵심 개념
{chr(10).join(f"- {point}" for point in info['key_points'])}

## 복잡도
- **시간 복잡도**: {info['complexity']['time']}
- **공간 복잡도**: {info['complexity']['space']}

## 주요 활용 사례
{chr(10).join(f"- {case}" for case in info['common_use_cases'])}

## 포함된 문제
{problems_list}

## 참고 자료
- 각 문제의 풀이 코드는 해당 디렉토리의 `.kt` 파일을 참고하세요.
"""
        
        docs_path.write_text(docs_content, encoding='utf-8')
        print(f"Created: {docs_path}")
    
    # Create docs for top-level categories without subdirectories
    top_level_categories = ['greedy', 'binary-search', 'two-pointer', 'sliding-window', 
                           'prefix-sum', 'sort', 'string', 'math', 'implementation', 'parsing']
    
    for category in top_level_categories:
        dir_path = base_dir / category
        if dir_path.exists() and (base_dir / category / 'docs.md').exists():
            # Already created above
            continue
        elif dir_path.exists():
            # Create if it doesn't exist
            info = categories.get(category, {
                'title': category.replace('-', ' ').title(),
                'description': f'{category} 관련 알고리즘 문제들',
                'key_points': [],
                'complexity': {'time': '문제에 따라 다름', 'space': '문제에 따라 다름'},
                'common_use_cases': []
            })
            problems = get_problems_in_directory(dir_path)
            problems_list = '\n'.join([
                f"- [{prob['num']}번](https://www.acmicpc.net/problem/{prob['num']}) - {prob['name']}"
                for prob in problems
            ]) if problems else "- 아직 문제가 없습니다."
            
            docs_content = f"""# {info['title']}

## 개요
{info['description']}

## 포함된 문제
{problems_list}

## 참고 자료
- 각 문제의 풀이 코드는 해당 디렉토리의 `.kt` 파일을 참고하세요.
"""
            docs_path = dir_path / 'docs.md'
            docs_path.write_text(docs_content, encoding='utf-8')
            print(f"Created: {docs_path}")

if __name__ == '__main__':
    create_category_docs()
