package logic;

public class Calculator {
    private int result;

    public Calculator() {
        result = 0;
    }

    public int add(int num1, int num2) {
        result = num1 + num2;
        return result;
    }

    public int getResult() {
        return result;
    }
}
