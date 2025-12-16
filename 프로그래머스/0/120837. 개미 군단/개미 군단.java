class Solution {
    public int solution(int hp) {
        Calculator calculator = new Calculator();
        int answer = calculator.totalAntCount(hp);

        return answer;
    }

    enum AntType {
        WARLORD(5),
        SOLDIER(3),
        WORK(1);

        private final int power;

        private AntType(int power) {
            this.power = power;
        }

        public int getAntPower() {
            return this.power;
        }
    }

    public class Calculator {
        public int totalAntCount(int hp) {
            int count = 0;
            int remainHP = hp;
            for (AntType ant : AntType.values()) {
                int needAntCount = remainHP / ant.getAntPower();
                remainHP = remainHP % ant.getAntPower();
                count += needAntCount;
            }
            return count;
        }
    }
}
