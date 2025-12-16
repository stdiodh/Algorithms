import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] array, int height) {
        List<Integer> students = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
        ClassRoom classRoom = new ClassRoom(students);
        int answer = classRoom.countTaller(height);

        return answer;
    }

    public class ClassRoom {
        List<Integer> students;

        private ClassRoom(List<Integer> students) {
            validate(students);
            this.students = students;
        }

        private void validate(List<Integer> students) {
            for (int student : students) {
                if (student < 0) {
                    throw new IllegalArgumentException("키가 0 이하인 학생은 포함할 수 없습니다.");
                }
            }
        }

        public int countTaller(int height) {
            int count = 0;
            for (int student : students) {
                if (height < student) {
                    count++;
                }
            }
            return count;
        }
    }
}
