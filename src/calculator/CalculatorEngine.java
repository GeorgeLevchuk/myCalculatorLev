package calculator;

public class CalculatorEngine {
    private final AdvancedMathOperations advancedMath;

    public CalculatorEngine() {
        this.advancedMath = new AdvancedMathOperations();
    }

    public double calculate(double num1, double num2, Operation operation) {
        switch (operation) {
            case ADD:
                return num1 + num2;
            case SUBTRACT:
                return num1 - num2;
            case MULTIPLY:
                return num1 * num2;
            case DIVIDE:
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на ноль невозможно");
                }
                return num1 / num2;
            case POWER:
                return advancedMath.power(num1, num2);
            default:
                throw new UnsupportedOperationException("Эта операция требует одного аргумента");
        }
    }

    public double calculate(double num, Operation operation, boolean radians) {
        switch (operation) {
            case SQRT:
                return advancedMath.squareRoot(num);
            case ABS:
                return advancedMath.absolute(num);
            case FACTORIAL:
                return advancedMath.factorial((int) num);
            case SIN:
                return advancedMath.sin(num, radians);
            case COS:
                return advancedMath.cos(num, radians);
            case TAN:
                return advancedMath.tan(num, radians);
            default:
                throw new UnsupportedOperationException("Неподдерживаемая операция");
        }
    }
}