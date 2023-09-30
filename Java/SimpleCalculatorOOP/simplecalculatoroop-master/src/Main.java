import logic.AdvancedCalculator;
import interaction.User;

public class Main {
    public static void main(String[] args) {
        User first_number = new User();
        User second_number = new User();
        int num1, num2;

        num1 = first_number.getUserInput();
        num2 = second_number.getUserInput();

        AdvancedCalculator calculator = new AdvancedCalculator();

        calculator.add(num1, num2);
        calculator.div(num1, num2);

        System.out.println("Result of adding up: " + calculator.getResult());
        System.out.println("Result of division: " + calculator.getDivResult());
    }
}
