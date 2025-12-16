class Solution {
    public int solution(int n, int k) {
        Order order = new Order(n, k);
        Calculator calculator = new Calculator(order);

        int drinkService = order.drinkService(n);
        int answer = calculator.totalPrice() - (drinkService * Menu.drink.getPrice());

        return answer;
    }


    enum Menu {
        lamb(12000),
        drink(2000);

        private final int price;

        private Menu(int price) {
            this.price = price;
        }

        public int getPrice() {
            return this.price;
        }
    }

    public class Order {
        int lambCount;
        int drinkCount;

        public Order(int lambCount, int drinkCount) {
            this.lambCount = lambCount;
            this.drinkCount = drinkCount;
        }

        public int drinkService(int lambCount) {
            return lambCount / 10;
        }

        public int getLambCount() {
            return lambCount;
        }

        public int getDrinkCount() {
            return drinkCount;
        }
    }

    public class Calculator {
        Order order;

        public Calculator(Order order) {
            this.order = order;
        }

        public int totalPrice() {
            return Menu.lamb.getPrice() * order.getLambCount() + Menu.drink.getPrice() * order.getDrinkCount();
        }
    }
}
