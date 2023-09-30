package logic;

public class AdvancedCalculator extends Calculator {
    private float divResult;

    public AdvancedCalculator() {
        divResult = 0.0f;
    }

    public float div(float num1, float num2) {
        if (num2 != 0.0f) {
            divResult = num1 / num2;
        } else {
            divResult = 0.0f;
        }
        return divResult;
    }

    public float getDivResult() {
        return divResult;
    }
}
